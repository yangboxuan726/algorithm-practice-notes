public class 缺失的第一个正数 {
    //https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：nums = [7,8,9,11,12]
        //输出：1
        //解释：最小的正数 1 没有出现
        int[] nums = {7,8,9,11,12};
        int result = firstMissingPositive(nums);
        System.out.println(result);

    }

    public static int firstMissingPositive(int[] nums){
        int l = 0;
        int r = nums.length;
        while (l < r){
            if (nums[l] == l +1){
                l++;
            }else if (nums[l] < l || nums[l] > r || nums[nums[l]-1] == nums[l]){
                swap(nums,l,--r);
            }else {
                swap(nums,l,nums[l] -1);
            }

        }
        return l +1;
    }
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
