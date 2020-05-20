package org.practice.linkedlists;

public class q2 {

    /*
    Time Complexity: O(max(m,n))
    Space Complexity: O(1)
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
            int digit=0, carry=0, val1 = 0, val2 = 0;
            int len1 = listLen(l1), len2 = listLen(l2);
            if(len2 < len1) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            ListNode node1 = l1, node2 = l2;
            while(node1 != null && node2 != null) {
                val1 = node1.val;
                val2 = node2.val;
                digit = (val1+val2+carry)%10;
                carry = (val1+val2+carry)/10;
                node2.val = digit;

                node1 = node1.next;
                node2 = node2.next;
            }
            while(node2 != null && carry != 0) {
                val2 = node2.val;
                node2.val = (val2+carry)%10;
                carry = (val2+carry)/10;
                node2 = node2.next;
            }
            if(carry != 0){
                ListNode temp = new ListNode(carry);
                node2 = l2;
                while(node2.next != null)
                    node2 = node2.next;
                node2.next = temp;
            }
            return l2;
        }

        public int listLen(ListNode head) {
            int len = 0;
            while(head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}
