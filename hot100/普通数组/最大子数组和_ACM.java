import java.util.Scanner;

public class 最大子数组和_ACM {
    //https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args){
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int count = maxSubArray(nums);
        //System.out.println(count);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++){
                nums[i] = sc.nextInt();
            }
            int count = maxSubArray(nums);
            System.out.println(count);

        }
        //9 -2 1 -3 4 -1 2 1 -5 4 ->6

    }

    public static int maxSubArray(int[] nums){
        int n = nums.length;
        int ans = nums[0];
        for (int i = 1,pre = nums[0];i < n;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            ans = Math.max(ans,pre);
        }
        return ans;

    }


}
