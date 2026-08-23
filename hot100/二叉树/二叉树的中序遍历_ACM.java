import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 二叉树的中序遍历_ACM {
    // https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
    /*
     * ACM 输入格式（支持读到 EOF 的多组数据）：
     * n
     * n 行，每行 3 个数：val left right
     * 节点按输入顺序编号 0 ~ n-1，0 号节点是根，left/right 是孩子的编号，-1 表示没有这个孩子
     *
     * 示例输入（对应 LeetCode 的 [1,null,2,3] 和 [5]）：
     * 3
     * 1 -1 1
     * 2 2 -1
     * 3 -1 -1
     * 1
     * 5 -1 -1
     *
     * 示例输出：
     * 1 3 2
     * 5
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            TreeNode root = buildTree(sc, n);
            List<Integer> ans = inorderTraversal(root);
            printList(ans);
        }

        sc.close();
    }

    // 建树要走两趟：第一趟先把 n 个节点都创建出来（left/right 编号可能指向还没创建的节点），
    // 第二趟才能按编号把孩子挂到父节点上，0 号节点就是根。
    private static TreeNode buildTree(Scanner sc, int n) {
        TreeNode[] nodes = new TreeNode[n];
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(sc.nextInt());
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                nodes[i].left = nodes[left[i]];
            }
            if (right[i] != -1) {
                nodes[i].right = nodes[right[i]];
            }
        }

        return n == 0 ? null : nodes[0];
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> ans) {
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

    // 按 ACM 常见格式输出，节点之间只有一个空格，没有方括号和逗号。
    private static void printList(List<Integer> ans) {
        StringBuilder result = new StringBuilder();

        for (int val : ans) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(val);
        }

        System.out.println(result);
    }

    public static class TreeNode {
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
}
