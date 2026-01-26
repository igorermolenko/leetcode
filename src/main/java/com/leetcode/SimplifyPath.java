package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();

        String[] folders = path.split("/+");
        for (String folder : folders) {
            if (!folder.isEmpty() && !folder.equals(".")) {
                if (folder.equals("..")) {
                    deque.pollLast();
                } else {
                    deque.addLast(folder);
                }
            }
        }

//        StringBuilder result = new StringBuilder();
//        while (!deque.isEmpty()){
//            result.append("/").append(deque.pollFirst());
//        }
//        return result.isEmpty() ? "/" : result.toString();

        return "/" + String.join("/", deque);
    }

    public static void main(String[] args) {
        SimplifyPath task = new SimplifyPath();
        System.out.println(task.simplifyPath("/home/"));
        System.out.println(task.simplifyPath("/home//foo/"));
        System.out.println(task.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(task.simplifyPath("/../"));
        System.out.println(task.simplifyPath("/.../a/../b/c/../d/./"));
    }
}
