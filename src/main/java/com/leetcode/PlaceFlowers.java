package com.leetcode;

public class PlaceFlowers {
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        int sequentialEmpty = 1;
        for(int value : flowerbed) {
            if (value == 0) {
                sequentialEmpty++;
            } else {
                sequentialEmpty = 0;
            }
            if (sequentialEmpty == 3) {
                count++;
                sequentialEmpty = 0;
            }
        }
        if (sequentialEmpty == 2) {
            count++;
        }

        return count >= n;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = i==0 || flowerbed[i-1] == 0;
                boolean rightEmpty = i==flowerbed.length - 1 || flowerbed[i+1] == 0;
                if (leftEmpty && rightEmpty) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }


    public static void main(String[] args) {
        PlaceFlowers flowers = new PlaceFlowers();
        System.out.println(flowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(flowers.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(flowers.canPlaceFlowers(new int[]{0,1,0,0,1}, 1));
        System.out.println(flowers.canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(flowers.canPlaceFlowers(new int[]{0,1,0,1,0,0}, 1));
    }
}
