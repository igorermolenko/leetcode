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

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        addCombinations(digits, 0, result, new StringBuilder());

        return result;
    }


    private void addCombinations(String digits, int idx, List<String> result, StringBuilder combination) {
        if (idx == digits.length()) {
            result.add(combination.toString());
            return;
        }
        for (char ch : mapping.get(digits.charAt(idx))) {
            combination.append(ch);
            addCombinations(digits, idx + 1, result, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }


    public static void main(String[] args) {
        LetterCombinations task = new LetterCombinations();
        System.out.println(task.letterCombinations("23"));
        System.out.println(task.letterCombinations("2"));
    }
}
