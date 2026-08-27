public class 二叉搜索树中第K小的元素 {
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


    private int ans;
    private int k ;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    public  void dfs(TreeNode root){
        if (root == null || k <= 0) return;

        dfs(root.left);

        if (--k == 0){
            ans = root.val;
        }

        dfs(root.right);
    }
}
