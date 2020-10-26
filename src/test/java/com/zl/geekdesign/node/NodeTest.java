package com.zl.geekdesign.node;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author liusha
 * @date 2020/10/23
 */
public class NodeTest {

    @Test
    public void test1() {
        int[] res = smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
        for (int n : res) System.out.print(n + " ");
    }

    // 是否是回文
    public boolean isReverse(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        ListNode l1 = head, l2 = head;
        while (l2 != null && l2.next != null) {
            l2 = l2.next.next;
            l1 = l1.next;
        }
        // 走完后l1在中点靠后

        ListNode l3 = null;
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l3;
            l3 = l1;
            l1 = l2;
        }
        // 翻转后pre对应head;

        l1 = head;
        while (l3 != null) {
            if (l3.val != l1.val) return false;
            l3 = l3.next;
            l1 = l1.next;
        }
        return true;
    }

    // nums = [8,1,2,2,3]
    // 输出：[4,0,1,1,3]
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] freq = new int[101];
        for (int num : nums) freq[num]++;

        // 小于等于i的数有多少个
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 小于nums[i] = 小于等于nums[i]-1
            if (nums[i] > 0) res[i] = freq[nums[i] - 1];
        }
        return res;
    }
}
