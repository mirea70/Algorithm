package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Hash_Clothes {
    public int solution(String[][] clothes) {
        int count = 1;
        // 각 의상을 종류별로 맵에 개수를 담는다.
        Map<String, Integer> kindCountMap = new HashMap<>();
        for(String[] cloth : clothes) {
            int cnt = kindCountMap.getOrDefault(cloth[1], 0);
            kindCountMap.put(cloth[1], cnt + 1);
        }
        // 맵을 순회하며 종류별 개수 + 1 로 곱셈으로 누적한다.
        for(String kind : kindCountMap.keySet()) {
            count = count * (kindCountMap.get(kind) + 1);
        }
        // 최소 한벌은 입어야하므로 모두 입지않은 경우는 제외한다.
        // 결과 반환
        return count - 1;
    }
}
