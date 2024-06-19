package com.github.bearboy;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 *
 * 本题关键是怎么保证空间复杂度是O(1)
 */
public class rotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        rotate_01(nums,3);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * 我们可以使用额外的数组来将每个元素放至正确的位置。
     * 用 n 表示数组的长度，我们遍历原数组，
     * 将原数组下标为 i 的元素放至新数组下标为 (i+k) mod n 的位置，
     * 最后将新数组拷贝至原数组即可.
     * 时间复杂度O(n),空间复杂度O(n)
     * nums = [1,2,3,4,5,6,7], k = 3
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums,int k){
        int n = nums.length;
        int [] newArr = new int[n];
        for (int i=0;i<n;i++){
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
    /**
     * 数组翻转
     *该方法基于如下的事实：当我们将数组的元素向右移动 k 次后，
     * 尾部 k mod n 个元素会移动至数组头部，
     * 其余元素向后移动 k mod n个位置。
     */
    public static void rotate_01(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
