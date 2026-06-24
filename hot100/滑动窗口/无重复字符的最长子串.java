import java.util.Arrays;

public class 无重复字符的最长子串 {
    //https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        String str = "abcabcbb";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);

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
