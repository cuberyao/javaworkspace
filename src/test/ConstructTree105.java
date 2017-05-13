package test;

public class ConstructTree105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1,2,3};
		int[] inorder = {2,1,3};	
		buildTree(preorder, inorder);

	}
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return helper(preorder, inorder, 0, preorder.length, 0);
    }
    private static TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int rootIdx) {
        if (inStart >= inEnd) 
            return null;
        //System.out.println("rootIdx="+rootIdx+",low="+low+",high="+high+",preorder[rootIdx]="+preorder[rootIdx]);
        TreeNode root = new TreeNode(preorder[rootIdx]);
        int idx = indexOf(inorder, preorder[rootIdx], inStart, inEnd);
        System.out.println("idx="+idx);
        root.left = helper(preorder, inorder, inStart, idx, rootIdx + 1);
        //System.out.println("right called");
        root.right = helper(preorder, inorder, idx + 1, inEnd, idx + 1);
        return root;
    }
    private static int indexOf(int[] nums, int key, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == key)
                return i;
        }
        return -1;
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

