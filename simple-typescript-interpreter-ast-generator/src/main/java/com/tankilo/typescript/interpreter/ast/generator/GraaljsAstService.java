package com.tankilo.typescript.interpreter.ast.generator;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.PolyglotException;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
public class GraaljsAstService implements AstService {

    private Context context;
    private Value options;
    private Value parseFunc;
    private Value jsonFunc;

    @Override
    public void init() throws Exception {
        context = Context.create("js");
        options = context.eval("js",
                "({\n" +
                        "  sourceType: \"module\",\n" +
                        "\n" +
                        "  plugins: [\n" +
                        "    \"typescript\"\n" +
                        "  ],\n" +
                        "})");
        File validatorBundleJS = new File(
                getClass().getClassLoader().getResource("babelparser_bundled.js").getFile());
        context.eval(Source.newBuilder("js", validatorBundleJS).build());
        parseFunc = context.getBindings("js").getMember("parse");
        jsonFunc = context.eval("js", "x => JSON.stringify(x)");
    }

    @Override
    public String parse(String typeScriptCode) throws SyntaxException {
        try {
            Value value = parseFunc.execute(typeScriptCode, options);
            return jsonFunc.execute(value).asString();
        } catch (PolyglotException polyglotException) {
            throw new SyntaxException("Please check code. Details: " + polyglotException.getMessage());
        }
    }
}
