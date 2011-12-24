package ds;

import java.util.LinkedList;

public class BSTNode extends BTNode {

	BSTNode(BSTNode l, BSTNode r, int d) {
		super(l, r, d);
	}
	
	BTNode toDoublyLinkedList() {
		LinkedList<BTNode> stk = new LinkedList<BTNode>();
		stk.push(this);
		BTNode last = null;
		BTNode head = null; 
		while (!stk.isEmpty()) {
			BTNode cur = stk.pop();
			BTNode l = cur.left;
			BTNode r = cur.right;
			if (cur.flag == 0) {
				cur.flag = 1;
				stk.push(cur);
				if (l != null) {
					stk.push(l);
				}
			} else if (cur.flag == 1) {
//				cur.flag = 2;
				if (head == null) head = cur;
				System.out.println(cur.data);
				cur.left = last;
				if (last != null) {
					last.right = cur;
				}
				
				last = cur;
				if (r != null) {
					stk.push(r);
				}
			}			
		}
		
		return head;
	}
	
	static void printDoublyLinkedList(BTNode head) {
		BTNode cur = head;
		while (cur != null) {
			BTNode prev = cur.left;
			BTNode next = cur.right;
			System.out.println(
				(prev == null ? "-1" : prev.data) + "  " +
				cur.data + "  " +
				(next == null ? "-1" : next.data)
			);
			cur = next;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BSTNode n2 = new BSTNode(null, null, 2);
		BSTNode n4 = new BSTNode(null, null, 4);
		BSTNode n3 = new BSTNode(n2, n4, 3);
		
		BSTNode n6 = new BSTNode(null, null, 6);
		BSTNode n8 = new BSTNode(null, null, 8);
		BSTNode n7 = new BSTNode(n6, n8, 7);
		
		BSTNode n5 = new BSTNode(n3, n7, 5);
		
		BTNode head = n5.toDoublyLinkedList();
		printDoublyLinkedList(head);
	}

}
