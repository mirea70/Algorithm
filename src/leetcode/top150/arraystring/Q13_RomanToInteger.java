package leetcode.top150.arraystring;

import java.util.Map;

public class Q13_RomanToInteger {
    // 로마문자별 정수값 맵에 저장
    Map<Character, Integer> romanToIntMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L',
            50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int sum = 0;
        // s 문자열 순회
        for(int i=0; i<s.length(); i++) {
            int current = romanToIntMap.get(s.charAt(i));
            int next = i+1 < s.length() ? romanToIntMap.get(s.charAt(i+1)) : 0;
            // 다음 것이 현재보다 크면, 빼고 아니면 더한다.
            if(current < next) {
                sum -= current;
            }
            else {
                sum += current;
            }
        }
        // 순회 끝
        // 결과값 반환
        return sum;
    }
}
