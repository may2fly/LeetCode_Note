/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode node = dummyNode;
        while(node.next != null && node.next.next != null){
            ListNode tmp = node.next;
            //确定交换顺序正确
            node.next = node.next.next;
            tmp.next = node.next.next;
            node.next.next = tmp;

            node = node.next.next;
        }


        return dummyNode.next;
    }
}