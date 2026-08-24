import java.util.*;

public class 二叉树的层序遍历 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        //作用：将指定元素 root 插入到队列的尾部。
        //返回值：返回 boolean 类型。如果插入成功返回 true；如果因队列容量限制无法插入，则返回 false（不会抛出异常）。

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //作用：获取队列头部的元素，并将其从队列中移除。
                //返回值：返回队头元素；如果队列为空，则返回 null（不会抛出异常）。
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;

    }
}
