package org.practice.linkedlists;

public class q160 {

    /*
    Time Complexity:O(max(m,n))
    Space Complexity:O(1)
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int len1 = getLen(headA), len2 = getLen(headB);

            //headA will point to longer list
            if(len1 < len2) {
                ListNode tempNode = headA;
                headA = headB;
                headB = tempNode;

                int temp = len1;
                len1 = len2;
                len2 = temp;
            }

            int extraLen = len1-len2;
            while(extraLen != 0) {
                headA = headA.next;
                extraLen--;
            }
            while(headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        public int getLen(ListNode head) {
            int len = 0;
            while(head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}
