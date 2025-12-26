package com.leetcode;

public class RemoveArrayElement {

    public int removeElement2(int[] nums, int val) {
        int counter = nums.length;
        int curIdx = 0;
        int lastIdx = nums.length - 1;
        while (curIdx <= lastIdx) {
            if (nums[curIdx] == val) {
                nums[curIdx] = nums[lastIdx--];
                counter--;
            } else {
                curIdx++;
            }
        }
        return counter;
    }

    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int num: nums) {
            if (num != val) {
                nums[counter++] = num;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        RemoveArrayElement task = new RemoveArrayElement();
        System.out.println(task.removeElement(new int[]{1}, 1));
        System.out.println(task.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(task.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(task.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2, 2, 2}, 2));
    }
}
