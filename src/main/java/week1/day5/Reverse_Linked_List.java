package week1.day5;

public class Reverse_Linked_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public static void main(String[] args) {
//        public ListNode reverseList (ListNode head){
//            ListNode back = null;
//            ListNode now = head;
//            ListNode front = null;
//
//            while (now != null) {
//                front = now.next;
//                now.next = back;
//                back = now;
//                now = front;
//            }
//            return back;
//        }
//    }
}
