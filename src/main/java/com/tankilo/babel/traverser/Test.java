package com.tankilo.babel.traverser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tankilo.babel.traverser.ast.File;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "  \"type\": \"File\",\n" +
                "  \"start\": 0,\n" +
                "  \"end\": 30,\n" +
                "  \"loc\": {\n" +
                "    \"start\": {\n" +
                "      \"line\": 1,\n" +
                "      \"column\": 0\n" +
                "    },\n" +
                "    \"end\": {\n" +
                "      \"line\": 1,\n" +
                "      \"column\": 30\n" +
                "    }\n" +
                "  },\n" +
                "  \"errors\": [\n" +
                "    \n" +
                "  ],\n" +
                "  \"program\": {\n" +
                "    \"type\": \"Program\",\n" +
                "    \"start\": 0,\n" +
                "    \"end\": 30,\n" +
                "    \"loc\": {\n" +
                "      \"start\": {\n" +
                "        \"line\": 1,\n" +
                "        \"column\": 0\n" +
                "      },\n" +
                "      \"end\": {\n" +
                "        \"line\": 1,\n" +
                "        \"column\": 30\n" +
                "      }\n" +
                "    },\n" +
                "    \"sourceType\": \"module\",\n" +
                "    \"interpreter\": null,\n" +
                "    \"body\": [\n" +
                "      {\n" +
                "        \"type\": \"VariableDeclaration\",\n" +
                "        \"start\": 0,\n" +
                "        \"end\": 30,\n" +
                "        \"loc\": {\n" +
                "          \"start\": {\n" +
                "            \"line\": 1,\n" +
                "            \"column\": 0\n" +
                "          },\n" +
                "          \"end\": {\n" +
                "            \"line\": 1,\n" +
                "            \"column\": 30\n" +
                "          }\n" +
                "        },\n" +
                "        \"declarations\": [\n" +
                "          {\n" +
                "            \"type\": \"VariableDeclarator\",\n" +
                "            \"start\": 4,\n" +
                "            \"end\": 29,\n" +
                "            \"loc\": {\n" +
                "              \"start\": {\n" +
                "                \"line\": 1,\n" +
                "                \"column\": 4\n" +
                "              },\n" +
                "              \"end\": {\n" +
                "                \"line\": 1,\n" +
                "                \"column\": 29\n" +
                "              }\n" +
                "            },\n" +
                "            \"id\": {\n" +
                "              \"type\": \"Identifier\",\n" +
                "              \"start\": 4,\n" +
                "              \"end\": 17,\n" +
                "              \"loc\": {\n" +
                "                \"start\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 4\n" +
                "                },\n" +
                "                \"end\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 17\n" +
                "                },\n" +
                "                \"identifierName\": \"state\"\n" +
                "              },\n" +
                "              \"name\": \"state\",\n" +
                "              \"typeAnnotation\": {\n" +
                "                \"type\": \"TSTypeAnnotation\",\n" +
                "                \"start\": 9,\n" +
                "                \"end\": 17,\n" +
                "                \"loc\": {\n" +
                "                  \"start\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 9\n" +
                "                  },\n" +
                "                  \"end\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 17\n" +
                "                  }\n" +
                "                },\n" +
                "                \"typeAnnotation\": {\n" +
                "                  \"type\": \"TSStringKeyword\",\n" +
                "                  \"start\": 11,\n" +
                "                  \"end\": 17,\n" +
                "                  \"loc\": {\n" +
                "                    \"start\": {\n" +
                "                      \"line\": 1,\n" +
                "                      \"column\": 11\n" +
                "                    },\n" +
                "                    \"end\": {\n" +
                "                      \"line\": 1,\n" +
                "                      \"column\": 17\n" +
                "                    }\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            \"init\": {\n" +
                "              \"type\": \"StringLiteral\",\n" +
                "              \"start\": 20,\n" +
                "              \"end\": 29,\n" +
                "              \"loc\": {\n" +
                "                \"start\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 20\n" +
                "                },\n" +
                "                \"end\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 29\n" +
                "                }\n" +
                "              },\n" +
                "              \"extra\": {\n" +
                "                \"rawValue\": \"enabled\",\n" +
                "                \"raw\": \"\\\"enabled\\\"\"\n" +
                "              },\n" +
                "              \"value\": \"enabled\"\n" +
                "            }\n" +
                "          }\n" +
                "        ],\n" +
                "        \"kind\": \"let\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"directives\": [\n" +
                "      \n" +
                "    ]\n" +
                "  },\n" +
                "  \"comments\": [\n" +
                "    \n" +
                "  ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = objectMapper.readValue(json, File.class);
        System.out.println();
    }
}
