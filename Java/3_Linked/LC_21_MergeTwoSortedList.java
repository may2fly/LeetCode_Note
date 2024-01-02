/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
*/

/**
 * 解题思路：
 * 1. 定义一个虚拟节点dummyNode，用于存储合并后的链表
 * 2. 循环遍历两个链表，链表节点都存在时，比较两个链表的头节点的值，将小的节点添加到合并后的链表中
 * 3. 循环结束后，将剩余的节点添加到合并后的链表中
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();

        ListNode node = dummyNode;
        //两个链表都存在
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if(list1 != null) node.next = list1;
        if(list2 != null) node.next = list2;

        return dummyNode.next;
    }
}