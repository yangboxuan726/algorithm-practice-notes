import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);

    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] cntp = new int[26];

        for (char c : p.toCharArray()) {
            cntp[c - 'a']++;
        }
        int[] cnts = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int right = 0;right < s.length();right++) {
            cnts[s.charAt(right) - 'a']++;
            int left = right - p.length() + 1;
            if (left < 0){
                continue;
            }
            if(Arrays.equals(cntp, cnts)){
                ans.add(left);
            }
            cnts[s.charAt(left) - 'a']--;
        }
        return ans;



    }
}
