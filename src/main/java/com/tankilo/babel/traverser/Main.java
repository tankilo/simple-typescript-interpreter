package com.tankilo.babel.traverser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

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
