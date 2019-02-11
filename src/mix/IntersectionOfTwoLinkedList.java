package mix;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // idea: for sure the intersection (if exists) starts and first node of the smallest list
        // so we place the cursors to that index and proceed in parallel node by node until
        //we found the same node

        //1 check if the last node is the same -> it means there is an interesection
        ListNode last1 = headA;
        int size1 = 1;
        int size2 = 1;

        while(last1 != null && last1.next != null) {
            last1 = last1.next;
            size1++;
        }

        ListNode last2 = headB;

        while(last2 != null && last2.next != null) {
            last2 = last2.next;
            size2++;
        }

        if(last1 == null || last2 == null) return null;
        if(!last1.equals(last2)) return null;

        //2 find the starting point
        if(size1 > size2) {
            while(size1 > size2) {
                headA = headA.next;
                size1--;
            }
        }else {
            while(size2 > size1) {
                headB = headB.next;
                size2--;
            }
        }

        //3 find the intersection
        while(!headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }


    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
