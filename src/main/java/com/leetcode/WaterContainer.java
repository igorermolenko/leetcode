package com.leetcode;

public class WaterContainer {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        WaterContainer container = new WaterContainer();
        System.out.println(container.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(container.maxArea(new int[] {1,1}));
    }
}
