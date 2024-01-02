/**
 * 61. 旋转链表
 * 
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
*/

/**
 * 解题思路：
 * 循环链表方式
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0) return head;//预处理，链表为空或者k为0

        //计算链表长度及到最后一个节点
        ListNode node = head;
        int count = 1;
        while(node.next != null){
            node = node.next;
            count++;
        }
        int carry = count - k%count;
        
        //创建循环链表
        node.next = head;
        while(carry>0){
            node = node.next;
            carry--;
        }

        //获取结果表头，并且解除循环链表
        ListNode result = node.next;
        node.next = null;
        return result;
    }
}