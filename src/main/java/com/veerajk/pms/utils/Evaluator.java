package com.veerajk.pms.utils;
import java.io.*;
import java.util.*;
import org.json.*;

public class Evaluator {
    public static void main(String[] args) {
        try {

            String testCasesJson = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("test_cases.json")));
            JSONArray testCases = new JSONArray(testCasesJson);

            List<JSONObject> results = new ArrayList<>();

            for (int i = 0; i < testCases.length(); i++) {
                JSONObject testCase = testCases.getJSONObject(i);
                JSONObject testResult = new JSONObject();

                testResult.put("status", "error");
                testResult.put("input", testCase.getJSONObject("input"));
                testResult.put("expected", testCase.get("expected"));
                testResult.put("output", JSONObject.NULL);
                testResult.put("error", JSONObject.NULL);

                try {
                    JSONObject input = testCase.getJSONObject("input");
                    JSONArray numsArray = input.getJSONArray("nums");
                    int target = input.getInt("target");


                    int[] nums = new int[numsArray.length()];
                    for (int j = 0; j < numsArray.length(); j++) {
                        nums[j] = numsArray.getInt(j);
                    }


                    int[] output = new int[]{1,2,3};
                    testResult.put("output", new JSONArray(output));

                    // Check correctness
                    if (Arrays.equals(output, testCase.getJSONArray("expected").toList().stream().mapToInt(o -> (int) o).toArray())) {
                        testResult.put("status", "passed");
                    } else {
                        testResult.put("status", "failed");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    testResult.put("error", e.getMessage());
                }

                results.add(testResult);
            }

            FileWriter file = new FileWriter("output.json");
            file.write(new JSONArray(results).toString(2));
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
