package programmers.hash;

import java.util.HashSet;
import java.util.Set;

public class Hash_PhonecketMon {
    public int solution(int[] nums) {
        // nums 길이의 절반을 미리 저장한다.
        int half = nums.length / 2;
        // nums 순회하면서 hashSet에 저장한다.
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        // set 길이와 절반 중 작은 값을 반환
        return Math.min(set.size(), half);
    }
}
