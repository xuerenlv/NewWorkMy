package leetcode_final_new_mac;


public class Linked_List_Random_Node_382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// Definition for ListNode.
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class Solution_Linked_List_Random_Node_382 {
	ListNode head;

	public Solution_Linked_List_Random_Node_382(ListNode head) {
		this.head = head;
	}

	public int getRandom() {

		ListNode c = head;
		int r = c.val;
		for (int i = 1; c.next != null; i++) {

			c = c.next;
			if (randInt(0, i) == i)
				r = c.val;
		}

		return r;
	}

	private int randInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
}
