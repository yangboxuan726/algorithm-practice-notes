import java.util.Arrays;
import java.util.Scanner;

public class 无重复字符的最长子串_ACM {
    //https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //String str = "abcabcbb";
        //int result = lengthOfLongestSubstring(str);
        //System.out.println(result);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int result = lengthOfLongestSubstring(str);
            System.out.println(result);
        }
        //abcabcbb -> 3
        //bbbbb -> 1
        //pwwkew -> 3
    }

    public static int lengthOfLongestSubstring(String str) {
        char[] s = str.toCharArray();
        int m = s.length;
        int[] last = new int[255];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int l = 0, r = 0; r < m; r++) {
            l = Math.max(l, last[s[r]] + 1);
            ans = Math.max(ans, r - l + 1);
            last[s[r]] = r;
        }
        return ans;

    }
}
