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
                "  \"end\": 24,\n" +
                "  \"loc\": {\n" +
                "    \"start\": {\n" +
                "      \"line\": 1,\n" +
                "      \"column\": 0\n" +
                "    },\n" +
                "    \"end\": {\n" +
                "      \"line\": 1,\n" +
                "      \"column\": 24\n" +
                "    }\n" +
                "  },\n" +
                "  \"errors\": [\n" +
                "    \n" +
                "  ],\n" +
                "  \"program\": {\n" +
                "    \"type\": \"Program\",\n" +
                "    \"start\": 0,\n" +
                "    \"end\": 24,\n" +
                "    \"loc\": {\n" +
                "      \"start\": {\n" +
                "        \"line\": 1,\n" +
                "        \"column\": 0\n" +
                "      },\n" +
                "      \"end\": {\n" +
                "        \"line\": 1,\n" +
                "        \"column\": 24\n" +
                "      }\n" +
                "    },\n" +
                "    \"sourceType\": \"module\",\n" +
                "    \"interpreter\": null,\n" +
                "    \"body\": [\n" +
                "      {\n" +
                "        \"type\": \"VariableDeclaration\",\n" +
                "        \"start\": 0,\n" +
                "        \"end\": 24,\n" +
                "        \"loc\": {\n" +
                "          \"start\": {\n" +
                "            \"line\": 1,\n" +
                "            \"column\": 0\n" +
                "          },\n" +
                "          \"end\": {\n" +
                "            \"line\": 1,\n" +
                "            \"column\": 24\n" +
                "          }\n" +
                "        },\n" +
                "        \"declarations\": [\n" +
                "          {\n" +
                "            \"type\": \"VariableDeclarator\",\n" +
                "            \"start\": 4,\n" +
                "            \"end\": 23,\n" +
                "            \"loc\": {\n" +
                "              \"start\": {\n" +
                "                \"line\": 1,\n" +
                "                \"column\": 4\n" +
                "              },\n" +
                "              \"end\": {\n" +
                "                \"line\": 1,\n" +
                "                \"column\": 23\n" +
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
                "                  \"type\": \"TSNumberKeyword\",\n" +
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
                "              \"type\": \"BinaryExpression\",\n" +
                "              \"start\": 20,\n" +
                "              \"end\": 23,\n" +
                "              \"loc\": {\n" +
                "                \"start\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 20\n" +
                "                },\n" +
                "                \"end\": {\n" +
                "                  \"line\": 1,\n" +
                "                  \"column\": 23\n" +
                "                }\n" +
                "              },\n" +
                "              \"left\": {\n" +
                "                \"type\": \"NumericLiteral\",\n" +
                "                \"start\": 20,\n" +
                "                \"end\": 21,\n" +
                "                \"loc\": {\n" +
                "                  \"start\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 20\n" +
                "                  },\n" +
                "                  \"end\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 21\n" +
                "                  }\n" +
                "                },\n" +
                "                \"extra\": {\n" +
                "                  \"rawValue\": 3,\n" +
                "                  \"raw\": \"3\"\n" +
                "                },\n" +
                "                \"value\": 3\n" +
                "              },\n" +
                "              \"operator\": \"+\",\n" +
                "              \"right\": {\n" +
                "                \"type\": \"NumericLiteral\",\n" +
                "                \"start\": 22,\n" +
                "                \"end\": 23,\n" +
                "                \"loc\": {\n" +
                "                  \"start\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 22\n" +
                "                  },\n" +
                "                  \"end\": {\n" +
                "                    \"line\": 1,\n" +
                "                    \"column\": 23\n" +
                "                  }\n" +
                "                },\n" +
                "                \"extra\": {\n" +
                "                  \"rawValue\": 1,\n" +
                "                  \"raw\": \"1\"\n" +
                "                },\n" +
                "                \"value\": 1\n" +
                "              }\n" +
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
