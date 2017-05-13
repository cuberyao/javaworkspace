package test;

import java.util.Stack;

public class AddTwoNumbersII445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Stack<Integer> s1 = new Stack<>();
    	Stack<Integer> s2 = new Stack<>();
    	ListNode h1 = l1;
    	while (h1 != null) {
    		s1.push(h1.val);
    		h1 = h1.next;
    	}
    	h1 = l2;
    	while (h1 != null) {
    		s2.push(h1.val);
    		h1 = h1.next;
    	}
    	ListNode res = new ListNode(0);
    	int carry = 0;
    	while (!s1.isEmpty() || !s2.isEmpty()) {
    		int num1 = s1.isEmpty() ? 0 : s1.pop();
    		int num2 = s2.isEmpty() ? 0 : s2.pop();
    		res.val = (num1 + num2 + carry) % 10;
    		carry = (num1 + num2 + carry) / 10;
    		ListNode tmp = new ListNode(carry);
    		tmp.next = res;
    		res = tmp;
    	}
    	return res.val == 0 ? res.next : res;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 