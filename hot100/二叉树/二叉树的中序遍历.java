import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public  void dfs(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        // 左
        dfs(root.left, ans);

        // 根
        ans.add(root.val);


        // 右
        dfs(root.right, ans);
    }
}
