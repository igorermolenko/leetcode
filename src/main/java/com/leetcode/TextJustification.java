package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int curIdx = 0;
        int rowStartIdx = 0;
        int rowLength = 0;
        while (curIdx < words.length) {
            int spacesCount = curIdx - rowStartIdx - 1;
            if (rowLength + words[curIdx].length() + spacesCount < maxWidth) {
                rowLength += words[curIdx++].length();
            } else {
                res.add(createLine(words, rowStartIdx, curIdx, rowLength, maxWidth));
                rowStartIdx = curIdx;
                rowLength = 0;
            }
        }
        res.add(createEndLine(words, rowStartIdx, curIdx, maxWidth));

        return res;
    }

    private String createLine(String[] words, int startIdx, int endIdx, int wordsLength, int maxWidth) {
        int gapsCount = endIdx - startIdx - 1;
        int unallocatedLength = wordsLength - words[startIdx].length();

        StringBuilder str = new StringBuilder(words[startIdx]);
        for (int i = startIdx + 1; i < endIdx; i++) {
            int availableLength = maxWidth - str.length() - unallocatedLength;
            int spacesCount = gapsCount > 1 ?
                    (int) Math.ceil((double) (availableLength) / gapsCount) :
                    availableLength;

            str.append(" ".repeat(spacesCount)).append(words[i]);
            gapsCount--;
            unallocatedLength -= words[i].length();
        }
        str.append(" ".repeat(maxWidth - str.length()));
        return str.toString();
    }

    private String createEndLine(String[] words, int startIdx, int endIdx, int maxWidth) {
        StringBuilder str = new StringBuilder(words[startIdx]);
        for (int i = startIdx + 1; i < endIdx; i++) {
            str.append(" ").append(words[i]);
        }
        str.append(" ".repeat(maxWidth - str.length()));
        return str.toString();
    }


    public static void main(String[] args) {
        TextJustification task = new TextJustification();
        System.out.println(task.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(task.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(task.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }
}
