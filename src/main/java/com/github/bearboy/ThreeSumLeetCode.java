package com.github.bearboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumLeetCode {
    public static void main(String[] args) {
        int [] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(bruteAlgo(nums));
        int [] nums1 = new int[]{0,0,0};
        System.out.println(bruteAlgo(nums1));
        int [] nums2 = new int[]{0,1,1};
        System.out.println(bruteAlgo(nums2));
    }

    /**
     * 暴力算法
     * @param nums
     * @return
     */
    public static List<List<Integer>> bruteAlgo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i=0;i< length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 跳过重复的元素
            }
            for (int j = i+1;j< length;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // 跳过重复的元素
                }
                for (int k = j+1;k<length;k++){
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue; // 跳过重复的元素
                    }
                    if (nums[i] + nums[j] + nums[k] ==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return  result;
    }
}
