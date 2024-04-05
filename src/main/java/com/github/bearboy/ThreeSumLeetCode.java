package com.github.bearboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumLeetCode {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums2 = new int[]{0, 1, 1};
        System.out.println(bruteAlgo(nums));
        System.out.println(bruteAlgo(nums1));
        System.out.println(bruteAlgo(nums2));
        System.out.println("------------");
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum1(nums));
        System.out.println(threeSum1(nums1));
        System.out.println(threeSum1(nums2));
    }

    /**
     * 暴力算法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> bruteAlgo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 跳过重复的元素
            }
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // 跳过重复的元素
                }
                for (int k = j + 1; k < length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue; // 跳过重复的元素
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 求x，y，z 三元素之和为0
     * 解题思路
     * 1. 现将数据进行排序，然后通过循环来控制i不动，通过双端指针来计算三数之和是否为0
     * 比如输入数据是[-1,0,-1,2,4]
     * 想将数据排序方便后面去重  ->[-1，-1，0，2，4]
     * 然后通过第一层循环控制x的取值，比如x=-1，令一个指针指向数组左端，
     * 令一个指针指向右端，两个指针不断的逼近中间，
     * 如果两个指针取值+x的值大于0，则右端指针向左侧移动，如果取值小于0，则左端指针向右侧移动，之道找得为0的数据
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { //去重
                continue;
            }
            int k = nums.length - 1;

            for (int j = i + 1; j < nums.length; j++) {

                if (j> i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (j<k && (nums[k] + nums[j] >  - nums[i] )) {
                    k = k - 1;
                }
                //如果相遇了，肯定不满足条件
                if (j == k) {
                    break;
                }
                if ( nums[j] + nums[k] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }


    static List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i< nums.length;i++){
            if (i>0 && nums[i]==nums[i-1]){ //去重
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j< k){
                //y+z > x 则 z像左侧移动
                if (nums[j]+ nums[k] > -nums[i]){
                    k --;
                }else if (nums[j]+ nums[k] < -nums[i]){
                    j++;
                }else {
                    //举例子：-1，-1，0，1，4，查找到数据[-1,0,1]
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 跳过重复数字
                }
            }
        }
        return result;
    }
}
