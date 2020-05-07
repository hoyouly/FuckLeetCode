package fun.hoyouly;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Leetcode_242 {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.isAnagram("anagram", "nagaram");
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null && t == null) {
                return true;
            }

            if (s == null && t != null) {
                return false;
            }

            if (t == null && s != null) {
                return false;
            }

            if (s.length() != t.length()) {
                return false;
            }
            int length = s.length();
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < length; i++) {
                char c1 = s.charAt(i);
                if (map1.containsKey(c1)) {
                    map1.put(c1, map1.get(c1) + 1);
                } else {
                    map1.put(c1, 0);
                }
                char c2 = t.charAt(i);
                if (map2.containsKey(c2)) {
                    map2.put(c2, map2.get(c2) + 1);
                } else {
                    map2.put(c2, 0);
                }
            }
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                if (!map1.get(entry.getKey()).equals(map2.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }
    }
}
