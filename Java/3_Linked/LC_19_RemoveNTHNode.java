/**
 * 19. 删除链表的倒数第 N 个结点
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
*/

/**
 * 解题思路：
 * 1、快慢指针：快指针先走N步，然后快慢指针一起走，到最后节点后移除倒数第N个节点
 * 2、遍历两次：第一次遍历链表，记录链表的长度，第二次遍历链表，找到倒数第N个节点
*/

/**
 * 遍历两次
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        int count = 0;
        ListNode node = dummyNode;
        while(node.next != null){
            node = node.next;
            count++;
        }

        int carry = count - n;
        node = dummyNode;
        while(carry > 0){
            node = node.next;
            carry--;
        }

        node.next = node.next.next;
        return dummyNode.next;
    }
    /**
     * 快慢指针，注意位置
    */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        int carry = n;
        ListNode fast = dummyNode, slow = dummyNode;
        while(carry > 0){
            fast = fast.next;
            carry--;
        }

        while(fast.next != null){// 快指针走到链表尾部
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyNode.next;
    }
}