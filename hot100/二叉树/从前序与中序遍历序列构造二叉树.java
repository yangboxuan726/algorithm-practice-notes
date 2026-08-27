import java.util.HashMap;

public class 从前序与中序遍历序列构造二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder,int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder,int left,int right){
        if (left > right){
            return  null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);


        int index = map.get(rootVal);

        root.left = dfs(preorder,left,index - 1);
        root.right = dfs(preorder,index + 1,right);

        return  root;
    }
}
