import com.sun.source.tree.Tree;

public class 二叉树展开为链表 {
    //https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
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
    private TreeNode pre;

    public void flatten(TreeNode root){
        if (root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;
        pre = root;



    }
}
