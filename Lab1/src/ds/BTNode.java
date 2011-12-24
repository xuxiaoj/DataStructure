package ds;

import java.util.LinkedList;

public class BTNode {
	static final int UNINITIALIZED = Integer.MAX_VALUE;

	BTNode left;
	BTNode right;
	int data;
	
	// 0 - untouched; 1 - touched; 2 - visited
	int flag;
	
	BTNode(BTNode l, BTNode r, int d) {
		this.left = l;
		this.right = r;
		this.data = d;
	}
	
	void preorderTraverse() {
		System.out.println(data);
		if (left != null) left.preorderTraverse();
		if (right != null) right.preorderTraverse();
	}
	
	void preorderTraverseIter() {
		LinkedList<BTNode> stk = new LinkedList<BTNode>();
		stk.push(this);
		while (!stk.isEmpty()) {
			BTNode cur = stk.pop();
			BTNode l = cur.left;
			BTNode r = cur.right;
			System.out.println(cur.data);
			if (r != null) {
				stk.push(r);
			}
			if (l != null) {
				stk.push(l);
			}			
		}
	}
	
	void inorderTraverse() {
		if (left != null) left.inorderTraverse();
		System.out.println(data);
		if (right != null) right.inorderTraverse();
	}
	
	void inorderTraverseIter() {
		LinkedList<BTNode> stk = new LinkedList<BTNode>();
		stk.push(this);
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
				System.out.println(cur.data);
				if (r != null) {
					stk.push(r);
				}
			}			
		}
	}
	
	void postorderTraverse() {
		if (left != null) {
			left.postorderTraverse();
		}
		if (right != null) {
			right.postorderTraverse();
		}
		System.out.println(data);		
	}
	
	void postorderTraverseIter() {
		LinkedList<BTNode> stk = new LinkedList<BTNode>();
		stk.push(this);
		while (!stk.isEmpty()) {
			BTNode cur = stk.pop();
			BTNode l = cur.left;
			BTNode r = cur.right;
			if (cur.flag == 0) {
				cur.flag = 1;
				stk.push(cur);
			} else {
				System.out.println(cur.data);
				continue;
			}
			if (r != null) {
				stk.push(r);
			}
			
			if (l != null) {
				stk.push(l);
			}
		}
	}
	
	void levelTraverse() {
		LinkedList<BTNode> q = new LinkedList<BTNode>();
		q.addLast(this);
		while (!q.isEmpty()) {
			BTNode cur = q.removeFirst();
			BTNode l = cur.left;
			BTNode r = cur.right;
			System.out.println(cur.data);
			if (l != null) {
				q.addLast(l);
			}
			
			if (r != null) {
				q.addLast(r);
			}
		}
	}
	
	/*
	 * 
	 * This is a variant of the level-order traversal.
	 * The traversal direction of each level is the reverse
	 * of the previous one.
	 *
	 * 
	 * dir
	 *    0 - left to right
	 *    1 - right to left 
	 */
	void levelTraverseVariant() {
		
		LinkedList<BTNode> q = new LinkedList<BTNode>();
		LinkedList<BTNode> stk = new LinkedList<BTNode>();
		q.addLast(this);
		int dir = 0;
		while (!q.isEmpty()) {
			BTNode cur = q.removeFirst();
			stk.push(cur);
			System.out.println(cur.data);
			
			if (q.isEmpty()) {
				while (!stk.isEmpty()) {
					BTNode stkCur = stk.pop();
					BTNode l = stkCur.left;
					BTNode r= stkCur.right;
					if (dir == 0) {
						if (l != null) {
							q.addLast(l);							
						}
						if (r != null) {
							q.addLast(r);
						}
					} else {
						if (r != null) {
							q.addLast(r);
						}
						if (l != null) {
							q.addLast(l);
						}
					}
				}
				dir = 1 - dir;	// reverse direction
			}			
		}
	}
	
	public static void main(String[] args) {
		BTNode n5 =new BTNode(null, null, 6);
		BTNode n6 = new BTNode(null, null, 7);
		BTNode n3 = new BTNode(null, null, 4);
//		BTNode n3 = null;
		BTNode n4 = new BTNode(null, null, 5);
//		BTNode n4 = null;
		BTNode n1 = new BTNode(n3, n4, 2);
		BTNode n2 = new BTNode(n5, n6, 3);
		BTNode root = new BTNode(n1, n2, 1);
//		root.inorderTraverse();
//		root.inorderTraverseIter();
//		root.preorderTraverse();
//		root.preorderTraverseIter();
//		root.postorderTraverse();
//		root.postorderTraverseIter();
//		root.levelTraverse();
		root.levelTraverseVariant();
	}
}
