package com.tankilo.typescript.interpreter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) {
        TypeScriptInterpreter interpreter = new TypeScriptInterpreter();
        try {
            interpreter.init();
        } catch (Exception e) {
            System.err.println("Failed to initialize");
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("Please input your typescript code, plus an 'end' after last line：");
        String code1 =   "let y = 1;\n" +
                "\n" +
                "if (true) {\n" +
                "  let y = 2;\n" +
                "  console.log(y);\n" +
                "}\n" +
                "\n" +
                "console.log(y);";
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if ("end".equals(line)) {
                    String code = sb.toString();
                    sb = new StringBuilder();
                    System.out.println("====================Input======================");
                    System.out.println(code);
                    System.out.println("====================Output=====================");
                    long startTime = System.currentTimeMillis();
                    try {
                        interpreter.interprete(code);
                        long cost = System.currentTimeMillis() - startTime;
                        System.out.println("Code executed Successfully, cost(ms): " + cost);
                    } catch (SyntaxException e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.println("===============================================");
                    System.out.println("Please input your typescript code, plus an 'end' after last line：");
                } else {
                    sb.append(line).append(LINE_SEPARATOR);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
