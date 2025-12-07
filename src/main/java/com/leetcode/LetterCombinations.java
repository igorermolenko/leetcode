package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private static final Map<Character, Character[]> mapping = Map.of(
            '2', new Character[]{'a', 'b', 'c'},
            '3', new Character[]{'d', 'e', 'f'},
            '4', new Character[]{'g', 'h', 'i'},
            '5', new Character[]{'j', 'k', 'l'},
            '6', new Character[]{'m', 'n', 'o'},
            '7', new Character[]{'p', 'q', 'r', 's'},
            '8', new Character[]{'t', 'u', 'v'},
            '9', new Character[]{'w', 'x', 'y', 'z'}
    );


    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        result.add("");
        for (char digit : digits.toCharArray()) {
            Character[] chars = mapping.getOrDefault(digit, new Character[0]);
            result = createCombinations(result, chars);
        }
        return result;
    }

    private List<String> createCombinations(List<String> sourceCombinations, Character[] chars) {
        List<String> result = new ArrayList<>();
        for (String sourceCombination : sourceCombinations) {
            for (char c : chars) {
                result.add(sourceCombination + c);
            }
        }
        return result;
    }

    // ===========================================

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits.toCharArray(), 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder builder, char[] digits, int idx) {
        if (idx == digits.length) {
            result.add(builder.toString());
            return;
        }
        Character[] chars = mapping.getOrDefault(digits[idx], new Character[0]);
        for (char c : chars) {
            builder.append(c);
            backtrack(result, builder, digits, idx + 1);
            builder.deleteCharAt(idx);
        }
    }


    public static void main(String[] args) {
        LetterCombinations task = new LetterCombinations();
        System.out.println(task.letterCombinations("23"));
        System.out.println(task.letterCombinations("2"));
    }
}
