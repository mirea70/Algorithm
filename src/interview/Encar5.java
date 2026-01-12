package interview;

import java.util.*;

public class Encar5 {
    public static void main(String[] args) {
        String[] logs = {
                "U1,/cars,400",
                "U2,/cars,600",
                "U3,/search,800",
                "U4,/search,700",
                "U5,/login,200"
        };

        String[] logs2 = {
                "A1,/a,600",
                "A2,/a,700",
                "A3,/b,800",
                "A4,/b,900",
                "A5,/c,400",
                "A6,/c,700"
        };


        String[] logs3 = {
                "U1,/x,300",
                "U2,/x,400",
                "U3,/y,500"
        };

        System.out.println(Arrays.toString(solution(logs3)));
    }

    public static String[] solution(String[] logs) {
        // 엔드포인트별 카운트, 합계 Map에 누적
        Map<String, long[]> endpointResponseTimeSumMap = new HashMap<>();
        for(String log : logs) {
            String[] arr = log.split(",");
            String endpoint = arr[1];
            long responseTime = Long.parseLong(arr[2]);
            long[] value = endpointResponseTimeSumMap.getOrDefault(endpoint, new long[]{0L,0L});
            value[0]++;
            value[1] += responseTime;

            endpointResponseTimeSumMap.put(endpoint, value);
        }

        // 평균 계산해서 500ms 초과일 경우에만 평균 맵에 담기
        Map<String, Long> avgMap = new HashMap<>();
        for(Map.Entry<String, long[]> entry : endpointResponseTimeSumMap.entrySet()) {
            long avg = entry.getValue()[1] / entry.getValue()[0];
            if(avg > 500) {
                avgMap.put(entry.getKey(), avg);
            }
        }
        // 평균맵 정렬
        List<Map.Entry<String, Long>> avgMapList = new ArrayList<>(avgMap.entrySet());
        Collections.sort(avgMapList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Map 순회 -> 응답 배열 생성
        String[] answer = new String[avgMapList.size()];
        int index = 0;
        for(Map.Entry<String, Long> entry : avgMapList) {
            answer[index++] = entry.getKey() + " " + entry.getValue();
        }
        // 응답 배열 반환
        return answer;
    }
}
