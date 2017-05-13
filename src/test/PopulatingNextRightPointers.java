package test;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> queue = new LinkedList<>();
        if (root == null)
        	return;
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
        	TreeLinkNode pointer = new TreeLinkNode(0);
        	for (int i = 0; i < (1 << level); i++) {
        		TreeLinkNode tmp = queue.remove(0);
        		if (tmp.left != null) {
        			queue.add(tmp.left);
        			queue.add(tmp.right);
        		}
        		pointer.next = tmp; 
        		pointer = pointer.next;
        		pointer.next = null;
        	}
        	level++;
        }
    }
    public void connect1(TreeLinkNode root) {
        List<TreeLinkNode> queue = new LinkedList<>();
        if (root == null)
        	return;
        queue.add(root);
        while (!queue.isEmpty()) {
        	TreeLinkNode pointer = new TreeLinkNode(0);
        	int len = queue.size();
        	for (int i = 0; i < len; i++) {
        		TreeLinkNode tmp = queue.remove(0);
        		if (tmp.left != null) {
        			queue.add(tmp.left);
        		}
        		if (tmp.right != null) {
        			queue.add(tmp.right);
        		}
        		pointer.next = tmp; 
        		pointer = pointer.next;
        		pointer.next = null;
        	}
        }
    }
}
 class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }