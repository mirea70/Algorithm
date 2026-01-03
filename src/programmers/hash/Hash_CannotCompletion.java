package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Hash_CannotCompletion {
    public String solution(String[] participant, String[] completion) {
        // completion을 순회하며 map에 인원 별 등장 수 저장.
        Map<String, Integer> personCountMpp = new HashMap<>();
        for(String person : completion){
            int count = personCountMpp.getOrDefault(person, 0);
            personCountMpp.put(person, count + 1);
        }
        // participant 순회하며 map에서 해당 인원의 등장수를 차감하는데, 이미 0이었으면 완주하지 못한 자이다.
        String answer = null;
        for(String participantPerson : participant){
            int count = personCountMpp.getOrDefault(participantPerson, 0);
            if(count == 0) {
                answer = participantPerson;
                break;
            }

            personCountMpp.put(participantPerson, count - 1);
        }

        return answer;
    }
}
