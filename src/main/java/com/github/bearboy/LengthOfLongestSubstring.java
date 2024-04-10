package com.github.bearboy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s1 = "abccbde";
        System.out.println(lengthOfLongestSubstring1(s1));
        System.out.println(lengthOfLongestSubstring2(s1));
        System.out.println(lengthOfLongestSubstring3(s1));
        System.out.println(lengthOfLongestSubstring4(s1));

    }

    /**
     * 暴力求解
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }
            res = Math.max(res, set.size());
            set.clear();
        }
        return res;
    }

    /**
     * 滑动窗口 + 哈希表
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        //定义一个指针，不停向右边移动
        int rk = -1;
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk+1));
                rk++;
            }
            res = Math.max(res, rk - i+1);
        }
        return res;
    }

    /**
     * 滑动窗口 + 哈希表
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s){
        int res =0;
        //定义i为左指针，j为有指针
        int i=0,j=0;
        int n = s.length();
        HashSet<Character> set = new HashSet();

        while (i<n && j<n){
            //如果不包含右边指针就继续移动
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res,j-i);
            }else {
                //如果有重复就左边窗口继续向前移动，知道没有重复
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s){
        int res =0;
        //定义i为左指针，j为右指针
        int i=0,j=0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (j=0;j< n;j++){
            //如果包含的话，就直接将i指针移动到重复的位置,注意i只能向前移动
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j))+1);
            }else {
                map.put(s.charAt(j),j);
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
