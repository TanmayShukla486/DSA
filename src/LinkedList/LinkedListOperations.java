package LinkedList;

public class LinkedListOperations {
    public int find(ListNode head, int value) {
        ListNode iterator = head;
        int i = 0;
        while (iterator != null) {
            if (iterator.value == value) return i;
            i++;
            iterator = iterator.next;
        }
        return -1;
    }

    public ListNode addNode(ListNode head, int index, int val) {
        if (index == 0) return new ListNode(val, head);
        ListNode iterator = head;
        for (int i = 0; i < index - 1 && iterator.next != null; i++) iterator = iterator.next;
        if (iterator.next == null) {
            iterator.next = new ListNode(val);
        } else {
            iterator.next = new ListNode(val, iterator.next);
        }
        return head;
    }

    public ListNode deleteNode(ListNode head, int index) {
        if (index == 0) return head.next;
        ListNode iterator = head;
        for (int i = 0; i < index - 1 && iterator.next != null; i++) iterator = iterator.next;
        if (iterator.next == null) return head;
        iterator.next = iterator.next.next;
        return head;
    }

}
