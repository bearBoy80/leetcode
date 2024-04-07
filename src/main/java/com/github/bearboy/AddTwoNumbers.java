package com.github.bearboy;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = buildNodes(new int[]{2,4,3});
        ListNode l2 = buildNodes(new int[]{5,6,4});
        ListNode result = addTwoNumbers1(l1,l2);
        System.out.println(result);
    }
    public static ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        //定义链表head ，tail
        ListNode head = null,tail = null;
        int carry = 0;
        while (l1!=null || l2 !=null){
            int n1 = l1 !=null ? l1.val:0;
            int n2 = l2 !=null ? l2.val:0;
            int sum = n1+n2+carry;
            if (head == null){
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum%10 );
                tail = tail.next;
            }
            carry = sum/10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if ( carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode buildNodes(int[] nums){
        ListNode head = null,tail = null;
        for (int i = 0;i< nums.length;i++){
            if (head == null){
                head = tail = new ListNode(nums[i]);
            }else {
                tail.next = new ListNode(nums[i]);
                tail = tail.next;
            }
        }
        return head;
    }
}

