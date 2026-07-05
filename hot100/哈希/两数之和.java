import java.util.Arrays;

public class 两数之和 {
    //https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2,7,11,15};
        int[] sum = twoSum(nums, target);
        System.out.println(Arrays.toString(sum));

    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; ; i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
    }
}
