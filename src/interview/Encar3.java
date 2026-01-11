package interview;

import java.util.*;

public class Encar3 {
    public static void main(String[] args) {
        String[] records1 = {
                "D1,10000,ON",
                "D1,20000,ON",
                "D2,15000,ON",
                "D2,30000,SOLD",
                "D3,5000,ON"
        };

        String[] records2 = {
                "D1,10000,SOLD",
                "D2,20000,SOLD"
        };

        String[] records3 = {
                "D10,10000,ON",
                "D2,10000,ON",
                "D1,10000,ON",
                "D3,20000,ON"
        };

        System.out.println(Arrays.toString(solution(records1)));
    }

    public static String[] solution(String[] records) {
        // records 순회 -> ON인 경우만, 집계 Map에 매물 개수, 가격 합계 누적
        Map<String, long[]> statMap = new HashMap<>();
        for(String record : records) {
            String[] recordArr = record.split(",");
            String dealerId = recordArr[0];
            long price = Long.parseLong(recordArr[1]);
            String status = recordArr[2];

            if(!status.equals("ON")) continue;

            long[] stat = statMap.getOrDefault(dealerId, new long[]{0L, 0L});
            stat[0]++;
            stat[1] += price;
            statMap.put(dealerId, stat);
        }
        // Map 정렬
        List<Map.Entry<String, long[]>> statMapList = new ArrayList<>(statMap.entrySet());
        statMapList.sort((e1, e2) -> {
            long c1 = e1.getValue()[0], s1 = e1.getValue()[1];
            long c2 = e2.getValue()[0], s2 = e2.getValue()[1];

            long avg1 = s1 / c1;
            long avg2 = s2 / c2;

            if(avg2 != avg1) {
                return Long.compare(avg2, avg1);
            }

            return e1.getKey().compareTo(e2.getKey());
        });

        // Map 순회 -> String 배열로 변환
        String[] answer = new String[statMapList.size()];
        int idx = 0;
        for(Map.Entry<String, long[]> entry : statMapList) {
            answer[idx++] = entry.getKey() + " " + entry.getValue()[0] + " " + (entry.getValue()[1] / entry.getValue()[0]);
        }
        // String 배열 반환
        return answer;
    }
}
