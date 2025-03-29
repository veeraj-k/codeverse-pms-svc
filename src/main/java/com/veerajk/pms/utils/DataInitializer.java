package com.veerajk.pms.utils;

import com.veerajk.pms.entities.Problem;
import com.veerajk.pms.entities.ProblemMetaData;
import com.veerajk.pms.entities.TestCase;
import com.veerajk.pms.repos.ProblemMetaDataRepo;
import com.veerajk.pms.repos.ProblemRepo;
import com.veerajk.pms.repos.TestCaseRepo;
import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
//@Order(1)
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProblemRepo problemRepo;
    @Autowired
    private TestCaseRepo testCaseRepository;

    @Autowired
    private ProblemMetaDataRepo problemMetaDataRepo;

    @Override
    public void run(String... args) {
        loadProblems();
        loadTestCases();
        loadMetaData();
    }


    private void loadTestCases() {



        List<TestCase> testCases = List.of(
                TestCase.builder().id(1L).input(Map.of("nums", Arrays.asList(2, 7, 11, 15), "target", 9)).output(Map.of("output", List.of(0, 1))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(2L).input(Map.of("nums", Arrays.asList(3, 2, 4), "target", 6)).output(Map.of("output", List.of(1, 2))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(3L).input(Map.of("nums", Arrays.asList(3, 3), "target", 6)).output(Map.of("output", List.of(0, 1))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(4L).input(Map.of("nums", Arrays.asList(1, 5, 7, 8), "target", 13)).output(Map.of("output", List.of(1, 2))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(5L).input(Map.of("nums", Arrays.asList(11, 35, 7, 8), "target", 42)).output(Map.of("output", List.of(1, 2))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(6L).input(Map.of("nums", Arrays.asList(-3, 4, 3, 90), "target", 0)).output(Map.of("output", List.of(0, 2))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(7L).input(Map.of("nums", Arrays.asList(5, 75, 25), "target", 100)).output(Map.of("output", List.of(1, 2))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(8L).input(Map.of("nums", Arrays.asList(10, 20, 30, 40, 50), "target", 90)).output(Map.of("output", List.of(3, 4))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(9L).input(Map.of("nums", Arrays.asList(1, 1, 1, 1, 2), "target", 3)).output(Map.of("output", List.of(3, 4))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(10L).input(Map.of("nums", Arrays.asList(0, 0, 3, 4), "target", 0)).output(Map.of("output", List.of(0, 1))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(11L).input(Map.of("nums", Arrays.asList(-1, -2, -3, -4, -5), "target", -8)).output(Map.of("output", List.of(2, 4))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(12L).input(Map.of("nums", Arrays.asList(100, 200, 300, 400), "target", 600)).output(Map.of("output", List.of(1, 3))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(13L).input(Map.of("nums", Arrays.asList(1, 4, 45, 6, 10, 8), "target", 16)).output(Map.of("output", List.of(3, 4))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(14L).input(Map.of("nums", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), "target", 19)).output(Map.of("output", List.of(8, 9))).problem(problemRepo.findById(1L).get()).build(),
                TestCase.builder().id(15L).input(Map.of("nums", Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45), "target", 55)).output(Map.of("output", List.of(3, 6))).problem(problemRepo.findById(1L).get()).build(),


                TestCase.builder().id(16L).input(Map.of("x", 121)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(17L).input(Map.of("x", -121)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(18L).input(Map.of("x", 10)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(19L).input(Map.of("x", 0)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(20L).input(Map.of("x", 1)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(21L).input(Map.of("x", 11)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(22L).input(Map.of("x", 12321)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(23L).input(Map.of("x", 1221)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(24L).input(Map.of("x", 1001)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(25L).input(Map.of("x", 1234321)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(26L).input(Map.of("x", 1234554321)).output(Map.of("output", true))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(27L).input(Map.of("x", -12321)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(28L).input(Map.of("x", -101)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(29L).input(Map.of("x", 2147483647)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),
                TestCase.builder().id(30L).input(Map.of("x", -2147483648)).output(Map.of("output", false))
                        .problem(problemRepo.findById(2L).get()).build(),


                TestCase.builder().id(31L)
                        .input(Map.of("s", "III"))
                        .output(Map.of("output", 3))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(32L)
                        .input(Map.of("s", "IV"))
                        .output(Map.of("output", 4))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(33L)
                        .input(Map.of("s", "IX"))
                        .output(Map.of("output", 9))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(34L)
                        .input(Map.of("s", "LVIII"))
                        .output(Map.of("output", 58))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(35L)
                        .input(Map.of("s", "MCMXCIV"))
                        .output(Map.of("output", 1994))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(36L)
                        .input(Map.of("s", "XLII"))
                        .output(Map.of("output", 42))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(37L)
                        .input(Map.of("s", "CCXLVI"))
                        .output(Map.of("output", 246))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(38L)
                        .input(Map.of("s", "CDXLIV"))
                        .output(Map.of("output", 444))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(39L)
                        .input(Map.of("s", "DCCCXC"))
                        .output(Map.of("output", 890))
                        .problem(problemRepo.findById(3L).get())
                        .build(),

                TestCase.builder().id(40L)
                        .input(Map.of("s", "MMMCMXCIX"))
                        .output(Map.of("output", 3999))
                        .problem(problemRepo.findById(3L).get())
                        .build(),


                TestCase.builder().id(41L)
                        .input(Map.of("strs", Arrays.asList("flower", "flow", "flight")))
                        .output(Map.of("output", "fl"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(42L)
                        .input(Map.of("strs", Arrays.asList("dog", "racecar", "car")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(43L)
                        .input(Map.of("strs", Arrays.asList("interspecies", "interstellar", "interstate")))
                        .output(Map.of("output", "inter"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(44L)
                        .input(Map.of("strs", Arrays.asList("apple", "app", "apricot")))
                        .output(Map.of("output", "ap"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(45L)
                        .input(Map.of("strs", Arrays.asList("a", "ab", "abc")))
                        .output(Map.of("output", "a"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(46L)
                        .input(Map.of("strs", Arrays.asList("car", "care", "careful")))
                        .output(Map.of("output", "car"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(47L)
                        .input(Map.of("strs", Arrays.asList("hello", "hell", "helmet")))
                        .output(Map.of("output", "hel"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(48L)
                        .input(Map.of("strs", Arrays.asList("java", "javascript", "javac")))
                        .output(Map.of("output", "java"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(49L)
                        .input(Map.of("strs", Arrays.asList("test", "testing", "tester")))
                        .output(Map.of("output", "test"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(50L)
                        .input(Map.of("strs", Arrays.asList("nothing", "common", "prefix")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(51L)
                        .input(Map.of("strs", Arrays.asList("banana", "band", "banner")))
                        .output(Map.of("output", "ban"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(52L)
                        .input(Map.of("strs", Arrays.asList("go", "gone", "going")))
                        .output(Map.of("output", "go"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(53L)
                        .input(Map.of("strs", Arrays.asList("1234", "123", "12")))
                        .output(Map.of("output", "12"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(54L)
                        .input(Map.of("strs", Arrays.asList("apple", "banana", "cherry")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(55L)
                        .input(Map.of("strs", Arrays.asList("prefix", "predefined", "presentation")))
                        .output(Map.of("output", "pre"))
                        .problem(problemRepo.findById(4L).get()).build(),

                TestCase.builder().id(56L)
                        .input(Map.of("s", "babad"))
                        .output(Map.of("output", "bab")) // "aba" is also a valid output
                        .problem(problemRepo.findById(6L).get()).build(),

        TestCase.builder().id(57L)
                .input(Map.of("s", "cbbd"))
                .output(Map.of("output", "bb"))
                .problem(problemRepo.findById(6L).get()).build(),
        TestCase.builder().id(58L)
                .input(Map.of("s", "a"))
                .output(Map.of("output", "a"))
                .problem(problemRepo.findById(6L).get()).build(),

        TestCase.builder().id(59L)
                .input(Map.of("s", "ac"))
                .output(Map.of("output", "a")) // "c" is also valid
                .problem(problemRepo.findById(6L).get()).build(),

        TestCase.builder().id(60L)
                .input(Map.of("s", "racecar"))
                .output(Map.of("output", "racecar"))
                .problem(problemRepo.findById(6L).get()).build(),
                TestCase.builder().id(61L)
                        .input(Map.of("strs", Arrays.asList("flower", "flow", "flight")))
                        .output(Map.of("output", "fl"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(62L)
                        .input(Map.of("strs", Arrays.asList("dog", "racecar", "car")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(63L)
                        .input(Map.of("strs", Arrays.asList("interspecies", "interstellar", "interstate")))
                        .output(Map.of("output", "inter"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(64L)
                        .input(Map.of("strs", Arrays.asList("apple", "app", "apricot")))
                        .output(Map.of("output", "ap"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(65L)
                        .input(Map.of("strs", Arrays.asList("a", "ab", "abc")))
                        .output(Map.of("output", "a"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(66L)
                        .input(Map.of("strs", Arrays.asList("car", "care", "careful")))
                        .output(Map.of("output", "car"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(67L)
                        .input(Map.of("strs", Arrays.asList("hello", "hell", "helmet")))
                        .output(Map.of("output", "hel"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(68L)
                        .input(Map.of("strs", Arrays.asList("java", "javascript", "javac")))
                        .output(Map.of("output", "java"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(69L)
                        .input(Map.of("strs", Arrays.asList("test", "testing", "tester")))
                        .output(Map.of("output", "test"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(70L)
                        .input(Map.of("strs", Arrays.asList("nothing", "common", "prefix")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(71L)
                        .input(Map.of("strs", Arrays.asList("banana", "band", "banner")))
                        .output(Map.of("output", "ban"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(72L)
                        .input(Map.of("strs", Arrays.asList("go", "gone", "going")))
                        .output(Map.of("output", "go"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(73L)
                        .input(Map.of("strs", Arrays.asList("1234", "123", "12")))
                        .output(Map.of("output", "12"))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(74L)
                        .input(Map.of("strs", Arrays.asList("apple", "banana", "cherry")))
                        .output(Map.of("output", ""))
                        .problem(problemRepo.findById(5L).get()).build(),

                TestCase.builder().id(75L)
                        .input(Map.of("strs", Arrays.asList("prefix", "predefined", "presentation")))
                        .output(Map.of("output", "pre"))
                        .problem(problemRepo.findById(5L).get()).build()




                );

        testCaseRepository.saveAll(testCases);
    }

    @Transactional
    public void loadProblems() {
        List<Problem> problems = Arrays.asList(
                Problem.builder()
                        .id(1L)
                        .title("Two Sum")
                        .difficulty("EASY")
                        .description("Find two numbers in the array that sum up to a specific target.")
                        .constraints(Arrays.asList("2 <= nums.length <= 10^4", "-10^9 <= nums[i] <= 10^9"))
                        .build(),
                Problem.builder()
                        .id(2L)
                        .title("Palindrome Number")
                        .difficulty("EASY")
                        .description("Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.")
                        .constraints(Arrays.asList("-2^31 <= x <= 2^31 - 1"))
                        .build(),
                Problem.builder()
                        .id(3L)
                        .title("Roman to Integer")
                        .difficulty("EASY")
                        .description("Convert a Roman numeral to an integer.")
                        .constraints(Arrays.asList(
                                "1 <= s.length <= 15",
                                "s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')",
                                "It is guaranteed that s is a valid Roman numeral"
                        ))
                        .build(),
                Problem.builder()
                        .id(4L)
                        .title("Longest Common Prefix")
                        .difficulty("EASY")
                        .description("Write a function to find the longest common prefix among an array of strings. If there is no common prefix, return an empty string.")
                        .constraints(Arrays.asList("1 <= strs.length <= 200", "0 <= strs[i].length <= 200", "strs[i] consists of only lowercase English letters."))
                        .build(),
                Problem.builder()
                        .id(5L)
                        .title("Longest Substring Without Repeating Characters")
                        .difficulty("MEDIUM")
                        .description("Find the length of the longest substring without repeating characters.")
                        .constraints(Arrays.asList("0 <= s.length <= 5 * 10^4", "s consists of English letters, digits, symbols, and spaces"))
                        .build(),
                Problem.builder()
                        .id(6L)
                        .title("Longest Palindromic Substring")
                        .difficulty("MEDIUM")
                        .description("Find the longest palindromic substring in a given string.")
                        .constraints(Arrays.asList("1 <= s.length <= 1000", "s consists of only lowercase English letters"))
                        .build()




        );
        problemRepo.saveAll(problems);
    }

    @Transactional
    public void loadMetaData() {
        List<ProblemMetaData> problemMetaDataList = Arrays.asList(
                ProblemMetaData.builder()
                        .problemId(1L)
                        .language("python")
                        .runner("import sys\r\nfrom Solution import Solution\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    nums = input_data[\"nums\"]\r\n    target = input_data[\"target\"]\r\n\r\n    try:\r\n        result = Solution().twoSum(nums, target)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                from typing import List

                                class Solution:
                                    def twoSum(self, nums: List[int], target: int) -> List[int]:
                                        pass
                                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(1L)
                        .language("java")
                        .runner("""
                                import java.util.*;
                                import org.json.*;
                                                                                                 
                                public class Runner {
                                    public static void main(String[] args) {
                                
                                        JSONObject obj = new JSONObject(args[0]);
                                        JSONObject input = obj.getJSONObject("input");
                                
                                        JSONArray numArr = input.getJSONArray("nums");
                                        int[] nums = new int[numArr.length()];
                                
                                        for (int i = 0; i < numArr.length(); i++) {
                                            nums[i] = numArr.getInt(i);
                                        }
                                        int target = input.getInt("target");
                                
                                        try {
                                            int[] result = Solution.twoSum(nums, target);
                                            System.out.println(Arrays.toString(result));
                                        } catch (Exception e) {
                                            System.out.println("Exception: " + e);
                                        }
                                
                                    }
                                }
                                                                                                 """)
                        .evaluator("""
                                class Solution {
                                    public int[] twoSum(int[] nums, int target) {
                                       \s
                                    }
                                }
                                """)
                        .build(),

                ProblemMetaData.builder()
                        .problemId(1L)
                        .language("c")
                        .runner("#include <stdio.h>\n" +
                                "#include <stdlib.h>\n" +
                                "#include <string.h>\n" +
                                "#include <cjson/cJSON.h> \n" +
                                "\n" +
                                "int* twoSum(int* nums, int numsSize, int target, int* returnSize);\n" +
                                "\n" +
                                "int main(int argc, char* argv[]) {\n" +
                                "    if (argc < 2) {\n" +
                                "        printf(\"No input provided\\n\");\n" +
                                "        return 1;\n" +
                                "    }\n" +
                                "\n" +
                                "    // Parse JSON input\n" +
                                "    cJSON* json = cJSON_Parse(argv[1]);\n" +
                                "    if (!json) {\n" +
                                "        printf(\"Invalid JSON\\n\");\n" +
                                "        return 1;\n" +
                                "    }\n" +
                                "\n" +
                                "    // Extract input object\n" +
                                "    cJSON* input = cJSON_GetObjectItem(json, \"input\");\n" +
                                "    cJSON* numsArr = cJSON_GetObjectItem(input, \"nums\");\n" +
                                "    cJSON* targetObj = cJSON_GetObjectItem(input, \"target\");\n" +
                                "\n" +
                                "    int numsSize = cJSON_GetArraySize(numsArr);\n" +
                                "    int* nums = (int*)malloc(numsSize * sizeof(int));\n" +
                                "    for (int i = 0; i < numsSize; i++) {\n" +
                                "        nums[i] = cJSON_GetArrayItem(numsArr, i)->valueint;\n" +
                                "    }\n" +
                                "    int target = targetObj->valueint;\n" +
                                "\n" +
                                "    // Call the solution function\n" +
                                "    int returnSize;\n" +
                                "    int* result = twoSum(nums, numsSize, target, &returnSize);\n" +
                                "\n" +
                                "    // Print result\n" +
                                "    printf(\"[\");\n" +
                                "    for (int i = 0; i < returnSize; i++) {\n" +
                                "        printf(\"%d\", result[i]);\n" +
                                "        if (i < returnSize - 1) printf(\", \");\n" +
                                "    }\n" +
                                "    printf(\"]\\n\");\n" +
                                "\n" +
                                "    // Cleanup\n" +
                                "    free(nums);\n" +
                                "    free(result);\n" +
                                "    cJSON_Delete(json);\n" +
                                "\n" +
                                "    return 0;\n" +
                                "}\n")
                        .evaluator("#include <stdlib.h>\n" +
                                "\n" +
                                "/**\n" +
                                " * Note: The returned array must be malloced, assume caller calls free().\n" +
                                " */\n" +
                                "int* twoSum(int* nums, int numsSize, int target, int* returnSize) {\n" +
                                "}")
                        .build(),
//--------------------------------+------------------------------+------------------------------------+------------------------------------------
                ProblemMetaData.builder()
                        .problemId(2L)
                        .language("python")
                        .runner("import sys\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    x = input_data[\"x\"]\r\n\r\n    try:\r\n        result = Solution().isPalindrome(x)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                class Solution {
                                    public boolean isPalindrome(int x) {
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(2L)
                        .language("java")
                        .runner("""
                                   import java.util.*;
                                   import org.json.*;
                                   
                                   public class Runner {
                                       public static void main(String[] args) {
                                           JSONObject obj = new JSONObject(args[0]);
                                           JSONObject input = obj.getJSONObject("input");
                                   
                                           int x = input.getInt("x");
                                   
                                           try {
                                               boolean result = Solution.isPalindrome(x);
                                               System.out.println(result);
                                           } catch (Exception e) {
                                               System.out.println("Exception: " + e);
                                           }
                                       }
                                   }
                                   """)
                        .evaluator("""
                                class Solution {
                                    public boolean isPalindrome(int x) {
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(2L)
                        .language("c")
                        .runner("""
                                #include <stdio.h>
                                 #include <stdlib.h>
                                 #include <string.h>
                                 #include <cjson/cJSON.h>
                                 
                                 int isPalindrome(int x); // Declaration of user-implemented function
                                 
                                 int main(int argc, char* argv[]) {
                                     if (argc < 2) {
                                         printf("No input provided\\n");
                                         return 1;
                                     }
                                 
                                     // Parse JSON input
                                     cJSON* json = cJSON_Parse(argv[1]);
                                     if (!json) {
                                         printf("Invalid JSON\\n");
                                         return 1;
                                     }
                                 
                                     // Extract input object
                                     cJSON* input = cJSON_GetObjectItem(json, "input");
                                     cJSON* xObj = cJSON_GetObjectItem(input, "x");
                                 
                                     if (!xObj) {
                                         printf("Invalid input format\\n");
                                         cJSON_Delete(json);
                                         return 1;
                                     }
                                 
                                     int x = xObj->valueint;
                                 
                                     // Call the solution function
                                     int result = isPalindrome(x);
                                 
                                     // Print result
                                     printf(result ? "true\\n" : "false\\n");
                                 
                                     // Cleanup
                                     cJSON_Delete(json);
                                 
                                     return 0;
                                 }
                                 
                                   """)
                        .evaluator("""
                                bool isPalindrome(int x) {
                                   \s
                                }
                                """)
                        .build(),

//--------------------------------+------------------------------+------------------------------------+------------------------------------------
                ProblemMetaData.builder()
                        .problemId(3L)
                        .language("python")
                        .runner("import sys\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    s = input_data[\"s\"]\r\n\r\n    try:\r\n        result = Solution().romanToInt(s)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                class Solution {
                                    public int romanToInt(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(3L)
                        .language("java")
                        .runner("""
                                import java.util.*;
                                 import org.json.*;
                                 
                                 public class Runner {
                                     public static void main(String[] args) {
                                         JSONObject obj = new JSONObject(args[0]);
                                         JSONObject input = obj.getJSONObject("input");
                                 
                                         String s = input.getString("s");
                                 
                                         try {
                                             int result = Solution.romanToInt(s);
                                             System.out.println(result);
                                         } catch (Exception e) {
                                             System.out.println("Exception: " + e);
                                         }
                                     }
                                 }
                                 
                                   """)
                        .evaluator("""
                                class Solution {
                                    public int romanToInt(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(3L)
                        .language("c")
                        .runner("""
                                #include <stdio.h>
                                   #include <stdlib.h>
                                   #include <string.h>
                                   #include <cjson/cJSON.h>
                                   
                                   int romanToInt(char* s); // User-defined function to be implemented in Solution.c
                                   
                                   int main(int argc, char* argv[]) {
                                       if (argc < 2) {
                                           printf("No input provided\\n");
                                           return 1;
                                       }
                                   
                                       // Parse JSON input
                                       cJSON* json = cJSON_Parse(argv[1]);
                                       if (!json) {
                                           printf("Invalid JSON\\n");
                                           return 1;
                                       }
                                   
                                       // Extract input object
                                       cJSON* input = cJSON_GetObjectItem(json, "input");
                                       cJSON* sObj = cJSON_GetObjectItem(input, "s");
                                   
                                       if (!sObj || !cJSON_IsString(sObj)) {
                                           printf("Invalid input format\\n");
                                           cJSON_Delete(json);
                                           return 1;
                                       }
                                   
                                       // Get the Roman numeral string
                                       char* s = sObj->valuestring;
                                   
                                       // Call the solution function
                                       int result = romanToInt(s);
                                   
                                       // Print result
                                       printf("%d\\n", result);
                                   
                                       // Cleanup
                                       cJSON_Delete(json);
                                      \s
                                       return 0;
                                   }
                                   """)
                        .evaluator("""
                                int romanToInt(char* s) {
                                   \s
                                }
                                """)
                        .build(),
                //--------------------------------+------------------------------+------------------------------------+------------------------------------------
                ProblemMetaData.builder()
                        .problemId(4L)
                        .language("python")
                        .runner("import sys\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    strs = input_data[\"strs\"]\r\n\r\n    try:\r\n        result = Solution().longestCommonPrefix(strs)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                class Solution {
                                    public String longestCommonPrefix(String[] strs) {
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(4L)
                        .language("java")
                        .runner("""
                                import java.util.*;
                                import org.json.*;
                                                               
                                public class Runner {
                                    public static void main(String[] args) {
                                        JSONObject obj = new JSONObject(args[0]);
                                        JSONObject input = obj.getJSONObject("input");
                                                               
                                        JSONArray strArr = input.getJSONArray("strs");
                                        String[] strs = new String[strArr.length()];
                                                               
                                        for (int i = 0; i < strArr.length(); i++) {
                                            strs[i] = strArr.getString(i);
                                        }
                                                               
                                        try {
                                            String result = Solution.longestCommonPrefix(strs);
                                            System.out.println(result);
                                        } catch (Exception e) {
                                            System.out.println("Exception: " + e);
                                        }
                                    }
                                }            
                                   """)
                        .evaluator("""
                                class Solution {
                                    public String longestCommonPrefix(String[] strs) {
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(4L)
                        .language("c")
                        .runner("""
                                #include <stdio.h>
                                     #include <stdlib.h>
                                     #include <string.h>
                                     #include <cjson/cJSON.h>
                                     
                                     char* longestCommonPrefix(char** strs, int strsSize);
                                     
                                     int main(int argc, char* argv[]) {
                                         if (argc < 2) {
                                             printf("No input provided\\n");
                                             return 1;
                                         }
                                     
                                         // Parse JSON input
                                         cJSON* json = cJSON_Parse(argv[1]);
                                         if (!json) {
                                             printf("Invalid JSON\\n");
                                             return 1;
                                         }
                                     
                                         // Extract input object
                                         cJSON* input = cJSON_GetObjectItem(json, "input");
                                         cJSON* strArr = cJSON_GetObjectItem(input, "strs");
                                     
                                         int strsSize = cJSON_GetArraySize(strArr);
                                         char** strs = (char**)malloc(strsSize * sizeof(char*));
                                     
                                         for (int i = 0; i < strsSize; i++) {
                                             strs[i] = strdup(cJSON_GetArrayItem(strArr, i)->valuestring);
                                         }
                                     
                                         // Call the solution function
                                         char* result = longestCommonPrefix(strs, strsSize);
                                         printf("\\"%s\\"\\n", result);
                                     
                                         // Cleanup
                                         for (int i = 0; i < strsSize; i++) {
                                             free(strs[i]);
                                         }
                                         free(strs);
                                         free(result);
                                         cJSON_Delete(json);
                                     
                                         return 0;
                                     }
                                     
                                   """)
                        .evaluator("""
                                char* longestCommonPrefix(char** strs, int strsSize) {
                                   \s
                                }
                                """)
                        .build(),
                //--------------------------------+------------------------------+------------------------------------+------------------------------------------
                ProblemMetaData.builder()
                        .problemId(5L)
                        .language("python")
                        .runner("import sys\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    s = input_data[\"s\"]\r\n\r\n    try:\r\n        result = Solution().lengthOfLongestSubstring(s)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                class Solution {
                                    public int lengthOfLongestSubstring(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(5L)
                        .language("java")
                        .runner("""
                                import java.util.*;
                                import org.json.*;
                                                                
                                public class Runner {
                                    public static void main(String[] args) {
                                                                
                                        JSONObject obj = new JSONObject(args[0]);
                                        JSONObject input = obj.getJSONObject("input");
                                                                
                                        String s = input.getString("s");
                                                                
                                        try {
                                            int result = Solution.lengthOfLongestSubstring(s);
                                            System.out.println(result);
                                        } catch (Exception e) {
                                            System.out.println("Exception: " + e);
                                        }
                                                                
                                    }
                                }
                                           
                                   """)
                        .evaluator("""
                                class Solution {
                                    public int lengthOfLongestSubstring(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(5L)
                        .language("c")
                        .runner("""
                                #include <stdio.h>
                                     #include <stdlib.h>
                                     #include <string.h>
                                     #include <cjson/cJSON.h>
                                     
                                     int lengthOfLongestSubstring(char* s);
                                     
                                     int main(int argc, char* argv[]) {
                                         if (argc < 2) {
                                             printf("No input provided\\n");
                                             return 1;
                                         }
                                     
                                         // Parse JSON input
                                         cJSON* json = cJSON_Parse(argv[1]);
                                         if (!json) {
                                             printf("Invalid JSON\\n");
                                             return 1;
                                         }
                                     
                                         // Extract input object
                                         cJSON* input = cJSON_GetObjectItem(json, "input");
                                         cJSON* sObj = cJSON_GetObjectItem(input, "s");
                                     
                                         char* s = strdup(sObj->valuestring);
                                     
                                         // Call the solution function
                                         int result = lengthOfLongestSubstring(s);
                                         printf("%d\\n", result);
                                     
                                         // Cleanup
                                         free(s);
                                         cJSON_Delete(json);
                                     
                                         return 0;
                                     }
                                     
                                   """)
                        .evaluator("""
                                int lengthOfLongestSubstring(char* s) {
                                   \s
                                }
                                """)
                        .build(),
                //--------------------------------+------------------------------+------------------------------------+------------------------------------------
                ProblemMetaData.builder()
                        .problemId(6L)
                        .language("python")
                        .runner("import sys\r\nimport json\r\n\r\ndef main():\r\n    if len(sys.argv) < 2:\r\n        print(\"No input provided\")\r\n        return\r\n    \r\n    # Parse JSON input\r\n    try:\r\n        data = json.loads(sys.argv[1])\r\n    except json.JSONDecodeError:\r\n        print(\"Invalid JSON\")\r\n        return\r\n    \r\n    input_data = data[\"input\"]\r\n    s = input_data[\"s\"]\r\n\r\n    try:\r\n        result = Solution().longestPalindrome(s)\r\n        print(result)\r\n    except Exception as e:\r\n        print(f\"Exception: {e}\")\r\n\r\nif __name__ == \"__main__\":\r\n    main()\r\n")
                        .evaluator("""
                                class Solution {
                                    public String longestPalindrome(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(6L)
                        .language("java")
                        .runner("""
                                import java.util.*;
                                import org.json.*;
                                                               
                                public class Runner {
                                    public static void main(String[] args) {
                                                               
                                        JSONObject obj = new JSONObject(args[0]);
                                        JSONObject input = obj.getJSONObject("input");
                                                               
                                        String s = input.getString("s");
                                                               
                                        try {
                                            String result = Solution.longestPalindrome(s);
                                            System.out.println(result);
                                        } catch (Exception e) {
                                            System.out.println("Exception: " + e);
                                        }
                                                               
                                    }
                                }
                                                               
                                           
                                   """)
                        .evaluator("""
                                class Solution {
                                    public String longestPalindrome(String s) {
                                       \s
                                    }
                                }
                                """)
                        .build(),
                ProblemMetaData.builder()
                        .problemId(6L)
                        .language("c")
                        .runner("""
                                #include <stdio.h>
                                       #include <stdlib.h>
                                       #include <string.h>
                                       #include <cjson/cJSON.h>
                                       
                                       char* longestPalindrome(char* s);
                                       
                                       int main(int argc, char* argv[]) {
                                           if (argc < 2) {
                                               printf("No input provided\\n");
                                               return 1;
                                           }
                                       
                                           // Parse JSON input
                                           cJSON* json = cJSON_Parse(argv[1]);
                                           if (!json) {
                                               printf("Invalid JSON\\n");
                                               return 1;
                                           }
                                       
                                           // Extract input object
                                           cJSON* input = cJSON_GetObjectItem(json, "input");
                                           cJSON* sObj = cJSON_GetObjectItem(input, "s");
                                       
                                           char* s = strdup(sObj->valuestring);
                                       
                                           // Call the solution function
                                           char* result = longestPalindrome(s);
                                           printf("%s\\n", result);
                                       
                                           // Cleanup
                                           free(s);
                                           free(result);
                                           cJSON_Delete(json);
                                       
                                           return 0;
                                       }
                                       
                                     
                                   """)
                        .evaluator("""
                                int longestPalindrome(char* s) {
                                   \s
                                }
                                """)
                        .build()







        );

        problemMetaDataRepo.saveAll(problemMetaDataList);

    }
//    private void loadTestCases(){
//        List<TestCase> testCases = Arrays.asList(
//                TestCase.builder()
//                        .id(1L)
//                        .input(Map.of(
//                                "input",Arrays.asList(1,5,7,8),
//                                "output",10
//                        ))
//                        .problem(problemRepo.findById(1L).get())
//                        .build(),
//                TestCase.builder()
//                        .id(2L)
//                        .input(Map.of(
//                                "input",Arrays.asList(11,35,7,8),
//                                "output",130
//                        ))
//                        .problem(problemRepo.findById(1L).get())
//                        .build(),
//                TestCase.builder()
//                        .id(3L)
//                        .input(Map.of(
//                                "input",Arrays.asList(15,55,7,8),
//                                "output",610
//                        ))
//                        .problem(problemRepo.findById(2L).get())
//                        .build()
//        );
//        testCaseRepository.saveAll(testCases);
//    }
//    @Transactional
//    public void loadProblems(){
//        List<Problem> problems = Arrays.asList(
//                Problem.builder()
//                        .id(1L)
//                        .title("Two Sum")
//                        .difficulty("Difficulty.EASY")
//                        .description("Given an array of integers nums and an integer target...")
//                        .constraints(Arrays.asList(
//                                "2 <= nums.length <= 10^4",
//                                "-10^9 <= nums[i] <= 10^9"
//                        ))
////                        .testCases(
////                                Arrays.asList(testCaseRepository.findById(1L).get(),testCaseRepository.findById(2L).get())
////                        )
//                        .build(),
//                Problem.builder()
//                        .id(2L)
//                        .title("Largest Array Sum")
//                        .difficulty("Difficulty.EASY")
//                        .description("Largest Given an array of integers nums and an integer target...")
//                        .constraints(Arrays.asList(
//                                "29 <= nums.length <= 10^4",
//                                "-810^9 <= nums[i] <= 10^9"
//                        ))
////                        .testCases( Arrays.asList(testCaseRepository.findById(3L).get()))
//                        .build(),
//                Problem.builder()
//                        .id(3L)
//                        .title("3 Largest Array Sum")
//                        .difficulty("Difficulty.EASY")
//                        .description("Largest Given an array of integers nums and an integer target...")
//                        .testCases( Arrays.asList(
//                          TestCase.builder()
//                                  .input(Map.of("numssss",Arrays.asList(1,2,3,4)))
//                                  .output(Map.of("target",1))
//                                  .build()))
//                        .build()
//        );
//        problemRepo.saveAll(problems);
//
//    }

}

