package com.tankilo.babel.traverser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tankilo.babel.traverser.traverse.BabelAstVisitorImpl;
import com.tankilo.babel.traverser.traverse.ContextScope;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

public class BabelParserTest {

    public BabelParserTest() {

    }

    public void parse(String code) {
        // create Polyglot Context for JavaScript and load NPM module validator (bundled as self contained resource)
        Context c = Context.create("js");
        Value options = c.eval("js",
                "({\n" +
                        "  sourceType: \"module\",\n" +
                        "\n" +
                        "  plugins: [\n" +
                        "    \"typescript\"\n" +
                        "  ],\n" +
                        "})");
        try {
            // load output from WebPack for Validator Module - a single bundled JS file
            File validatorBundleJS = new File(
                    getClass().getClassLoader().getResource("babelparser_bundled.js").getFile());
            c.eval(Source.newBuilder("js", validatorBundleJS).build());
            // use validation function isPostalCode(str, locale) from NPM Validator Module to validate postal code
            Value parseFunc = c.getBindings("js").getMember("parse");
            Value value = parseFunc.execute(code, options);

            Value jsonFunc = c.eval("js", "x => JSON.stringify(x)");
            String json = jsonFunc.execute(value).asString();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            com.tankilo.babel.traverser.ast.File file = objectMapper.readValue(json, com.tankilo.babel.traverser.ast.File.class);
            BabelAstVisitorImpl babelAstVisitor = new BabelAstVisitorImpl();
            ContextScope contextScope = new ContextScope();
            babelAstVisitor.visit(file.getProgram(), contextScope);
//            System.out.println("All functions available from Java (as loaded into Bindings) "
//                    + c.getBindings("js").getMemberKeys());

//            System.out.println(contextScope.getVariables().get("state").getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BabelParserTest v = new BabelParserTest();
        String code = "console.log(1 == 1);";
        System.out.println("====================Input=====================");
        System.out.println(code);
        System.out.println("====================Output=====================");
        v.parse(code);
    }
}
