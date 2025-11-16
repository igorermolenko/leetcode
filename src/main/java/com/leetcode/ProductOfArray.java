package com.leetcode;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1, suffix = 1;
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }



    public static void main(String[] args) {
        ProductOfArray product = new ProductOfArray();
        System.out.println(java.util.Arrays.toString(product.productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(java.util.Arrays.toString(product.productExceptSelf(new int[] {-1, 1, 0, -3, 3})));    }
}
