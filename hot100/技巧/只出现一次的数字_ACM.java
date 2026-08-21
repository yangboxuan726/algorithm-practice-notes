import java.util.Scanner;

public class 只出现一次的数字_ACM {
    //https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-like
    public static void main(String[] args) {
        //int[] num = {4,1,2,1,2};
        //int result = singleNumber(num);
        //System.out.println(result);

        //输入：nums = [4,1,2,1,2]
        //输出：4

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int result = singleNumber(nums);
            System.out.println(result);
        }
        //5 4 1 2 1 2 -> 4
    }

    public static int singleNumber(int[] nums){
        int ans = 0;
        for (int  num :nums){
            ans = ans ^ num;
        }
        return ans;

    }
}
