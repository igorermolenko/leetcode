package com.leetcode;

public class MedianOfTwoSortedArrays {

    // Binary Search / Divide and Conquer   - O(log(M+N))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1.length < nums2.length ? nums1 : nums2;
        int[] big = nums1.length >= nums2.length ? nums1 : nums2;

        int length = nums1.length + nums2.length;
        int halfLength = (length + 1) / 2;

        int left = 0;
        int right = small.length;

        while (left <= right) {
            int midSmall = left + (right - left) / 2;
            int midBig = halfLength - midSmall;

            int lSmall = midSmall == 0 ? Integer.MIN_VALUE : small[midSmall - 1];
            int rSmall = midSmall == small.length ? Integer.MAX_VALUE : small[midSmall];
            int lBig = midBig == 0 ? Integer.MIN_VALUE : big[midBig - 1];
            int rBig = midBig == big.length ? Integer.MAX_VALUE : big[midBig];

            if (lSmall <= rBig && lBig <= rSmall) {
                return length % 2 == 1 ?
                        Math.max(lSmall, lBig) :
                        (Math.max(lSmall, lBig) +  Math.min(rSmall, rBig)) / 2.0;
            }

            if (lSmall > rBig) {
                right = midSmall;
            } else {
                left = midSmall + 1;
            }
        }

        return -1;
    }


    // Two Pointers                         -  O(M+N)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean even = totalLength % 2 == 0;
        int midIdx = even ? totalLength / 2 : totalLength / 2 + 1;
        int median = 0;
        int idx1 = 0;
        int idx2 = 0;
        int currentIdx = 0;

        while (currentIdx < midIdx) {
            if (idx1 == nums1.length) {
                median = nums2[idx2++];
            } else if (idx2 == nums2.length) {
                median = nums1[idx1++];
            } else if (nums1[idx1] < nums2[idx2]) {
                median = nums1[idx1++];
            } else {
                median = nums2[idx2++];
            }
            currentIdx++;
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return median;
        }

        if (idx1 == nums1.length) {
            median += nums2[idx2];
        } else if (idx2 == nums2.length) {
            median += nums1[idx1];
        } else {
            median += Math.min(nums1[idx1], nums2[idx2]);
        }

        return median / 2.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays task = new MedianOfTwoSortedArrays();
        System.out.println(task.findMedianSortedArrays(new int[]{1, 3}, (new int[]{2})));
        System.out.println(task.findMedianSortedArrays(new int[]{1, 2}, (new int[]{3, 4})));
    }
}
