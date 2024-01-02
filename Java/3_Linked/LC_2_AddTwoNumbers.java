/*
* 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
* 请你将两个数相加，并以相同形式返回一个表示和的链表。
* 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*/

/*
* 解题思路：
* 两个链表相加，在原链表上操作会存在很多条件处理，通过新建链表的方式规避此方面的问题。
* 1. 从头开始，先将两个链表的值相加，然后将结果保存在新的链表中，同时将进位保存在变量中
* 2. 对两个链表完全遍历，已结束链表提前做空值判断处理
* 3. 最后判断是否有进位，如果有，则将进位节点添加到链表末尾
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);  

        int carry = 0;
        ListNode node = dummyNode;
        while(l1 != null || l2 != null){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = v1 + v2 + carry;
            node.next = new ListNode(sum%10);
            carry = sum/10;

            node = node.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry != 0){
            node.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}