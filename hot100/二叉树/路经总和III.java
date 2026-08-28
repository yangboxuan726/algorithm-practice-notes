public class 路经总和III {
    //https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
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

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        // 以当前节点作为起点
        int ans = dfs(root, targetSum);

        // 再去左子树枚举起点
        ans += pathSum(root.left, targetSum);

        // 再去右子树枚举起点
        ans += pathSum(root.right, targetSum);

        return ans;
    }

    // 必须从当前 root 开始，往下走
    public int dfs(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        // 当前节点正好能把剩余目标凑出来
        if (root.val == target) {
            ans++;
        }

        // 继续往左右孩子走
        ans += dfs(root.left, target - root.val);
        ans += dfs(root.right, target - root.val);

        return ans;
    }
}
