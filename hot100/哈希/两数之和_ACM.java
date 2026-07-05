public class 两数之和_ACM {
    //https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; ; i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
    }
}
