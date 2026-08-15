import java.util.Arrays;

public class 除了自身以外数组的乘积 {
    //https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入: nums = [1,2,3,4]
        //输出: [24,12,8,6]
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));

    }
    //时间复杂度 O(n)，额外空间复杂度 O(1)；如果把返回的 answer 数组也算进去，则总空间复杂度是 O(n)。
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];

        }
        return  answer;
    }

}
