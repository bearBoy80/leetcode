package com.github.bearboy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/two-sum/description/
 * 两数求和
 */
public class TwoSumLeetCode {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(bruteAlgo(nums, 9)));
        int[] nums1 = new int[]{3,2,4};
        System.out.println(Arrays.toString(bruteAlgo(nums1, 6)));
        int[] nums2 = new int[]{3,3};
        System.out.println(Arrays.toString(bruteAlgo(nums1, 6)));
        int[] nums3 = new int[]{3,3};
        System.out.println(Arrays.toString(twoSum(nums1, 6)));
    }

    static int[] bruteAlgo(int[] nums, int target){
        int length = nums.length;
        for (int i=0;i< length;i++){
            for (int j=i+1;j<length;j++){
                if (nums[j]+ nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++){
            // target的值 - num[i]的值，用这个值取判断是否存在map中
            Integer value =  map.get(target - nums[i]);
            if ( value != null){
                //为啥要把value值放在前面，因为刚才是map里面是没有值，value小先于i的值
                return  new int[]{value,i};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
