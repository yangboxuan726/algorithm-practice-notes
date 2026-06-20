public class 接雨水 {
    //https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(arr);
        System.out.println(result);

    }
    public static int trap(int[] height){
        int l=1,r = height.length-2,lmax = height[0],rmax = height[height.length -1];
        int ans = 0;
        while(l <= r){
            if (lmax < rmax){
                ans += Math.max(0,lmax-height[l]);
                lmax = Math.max(lmax,height[l++]);

            }else {
                ans += Math.max(0,rmax-height[r]);
                rmax = Math.max(rmax,height[r--]);
            }

        }
        return  ans;
    }

}
