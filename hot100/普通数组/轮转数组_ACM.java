import java.util.Arrays;
import java.util.Scanner;

public class 轮转数组_ACM {
    //https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            rotate(nums, k);
            System.out.println(Arrays.toString(nums));
        }
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //7 1 2 3 4 5 6 7 3

    }
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public static void reverse(int[] nums,int i , int j){
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
