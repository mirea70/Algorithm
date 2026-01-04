package leetcode.top150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> charSet = new HashSet<>();
        // 문자열 순회 -> 해시셋에 저장해간다.
        while(right < s.length()) {
            char val = s.charAt(right);
            // 중복값 존재할 동안 left를 지우고 포인터를 증가시킨다.
            while(charSet.contains(val)) {
                charSet.remove(s.charAt(left++));
            }
            // right 값 해시셋에 저장
            charSet.add(val);
            // - 길이 최댓값을 갱신
            max = Math.max(max, charSet.size());
            // - 길이 증가
            right++;
        }
        // 순회 끝
        // 길이 최댓값 반환
        return max;
    }
}
