package com.leetcode;

public class HighestAltitude {

    public int largestAltitude(int[] gains) {
        int currentAltitude = 0, highestAltitude = 0;
        for(int gain: gains) {
            currentAltitude += gain;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }

        return highestAltitude;
    }


    public static void main(String[] args) {
        HighestAltitude altitude = new HighestAltitude();
        System.out.println(altitude.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(altitude.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
