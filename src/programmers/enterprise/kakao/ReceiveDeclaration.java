package programmers.enterprise.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReceiveDeclaration {
    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list 크기 정답 배열 생성
        int len = id_list.length;
        int[] answer = new int[len];
        // id_list 순회 -> id별 인덱스 Map에 저장
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<len; i++) {
            idxMap.put(id_list[i], i);
        }
        // report 순회 -> id별 자신이 신고한 Set을 Map에 담고, id별 신고받은 횟수 카운트
        Map<String, Set<String>> toDeclareSet = new HashMap<>();
        Map<String, Integer> declaredCountMap = new HashMap<>();

        for(String response : report) {
            String[] arr = response.split(" ");
            String from = arr[0];
            String to = arr[1];

            if(toDeclareSet.containsKey(from) && toDeclareSet.get(from).contains(to)) {
                continue;
            }

            toDeclareSet.computeIfAbsent(from, v -> new HashSet<>()).add(to);
            declaredCountMap.put(to, declaredCountMap.getOrDefault(to, 0) + 1);
        }
        // id_list 순회 -> 해당 id 신고한 Set의 신고받은 횟수에 따라 정답 배열 카운트
        for(String id : id_list) {
            Set<String> toDeclares = toDeclareSet.get(id);
            if(toDeclares != null) {
                for(String toDeclare : toDeclares) {
                    if(declaredCountMap.getOrDefault(toDeclare, 0) >= k) {
                        answer[idxMap.get(id)]++;
                    }
                }
            }
        }
        // 정답 배열 반환
        return answer;
    }
}
