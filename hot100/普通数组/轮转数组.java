import java.util.Arrays;

public class 轮转数组 {
    //https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        int[] nums ={1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        reverse(nums,0,n-1);

        reverse(nums,0,k-1);

        reverse(nums,k,n-1);
    }


    public static void reverse(int[] nums,int left,int right){

        while(left < right){

            int temp = nums[left];

            nums[left] = nums[right];

            nums[right] = temp;

            left++;
            right--;
        }
    }
}
