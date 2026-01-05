package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String stripped = s.strip();
        int startIdx = stripped.lastIndexOf(" ");
        return startIdx == -1 ? stripped.length() : stripped.length() - startIdx - 1;
    }


    public static void main(String[] args) {
        LengthOfLastWord task = new LengthOfLastWord();
        System.out.println(task.lengthOfLastWord("Hello World"));
        System.out.println(task.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(task.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(task.lengthOfLastWord(" abracadabra  "));
    }
}
