public class 将有序数组转换为二叉搜索树 {
    //https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
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

    public TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums,0,nums.length-1);

    }
    public TreeNode dfs(int[] nums, int left, int right){
        if (left > right){
            return  null;
        }

        int mid = left + (right - left)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return  root;
    }
}
