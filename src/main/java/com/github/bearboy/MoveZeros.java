package com.github.bearboy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int [] nums1 =new int[] {0,1,0,3,12};
        int [] nums2 =new int[] {0};
        moveZeros(nums1);
        moveZeros(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }

    public static void moveZeros(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int k = 0;//定义一个左指针
        for (int i = 0; i < nums.length; i++) {
            System.out.println("移动数据:" + i);
            if (nums[i] != 0) { //说明需要移动到左边
                if (i != k) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                System.out.println("数组值：" + nums[i]);
                k++;
                System.out.println("k:" + k);
            }

        }
    }
}
