package interview;

import java.time.LocalDate;
import java.util.*;

public class Encar1 {
    public static void main(String[] args) {
        String[] records = new String[]{
                "L1,D,ON,12000000,2025-01-03",
                "L2,P,ON,8000000,2025-01-10",
                "L3,D,SOLD,15000000,2025-01-15",
                "L4,D,ON,10000000,2024-12-31",
                "L5,P,SOLD,9000000,2025-01-20"
        };
        String fromDate = "2025-01-01";
        String toDate = "2025-01-31";
        System.out.println(Arrays.toString(solution(records, fromDate, toDate)));
    }

    public static String[] solution(String[] records, String fromDate, String toDate) {
        // records 순회 -> CarInfo 리스트에 담기
        List<CarInfo> list = new ArrayList<>();
        for(String record : records) {
            String[] arr = record.split(",");
            String[] createdDateArr = arr[4].split("-");
            list.add(new CarInfo(
                    arr[0],
                    arr[1],
                    arr[2],
                    Long.parseLong(arr[3]),
                    LocalDate.of(Integer.parseInt(createdDateArr[0]), Integer.parseInt(createdDateArr[1]), Integer.parseInt(createdDateArr[2]))
            ));
        }
        // 리스트 순히 -> 생성일자가 fromDate 이상 toDate 이하이면 통계맵에 누적한다.
        LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);

        Map<String, int[]> map = new HashMap<>();
        for(CarInfo carInfo : list) {
            if (carInfo.createdAt.isAfter(from) && carInfo.createdAt.isBefore(to)) {
                String key = carInfo.status + "-" + carInfo.sellerType;
                int[] value = map.getOrDefault(key, new int[]{0, 0});
                value[1] = (int) (value[1] * value[0] + carInfo.price) / ++value[0];
                map.put(key, value);
            }
        }
        // 통계 정보를 문자열로 변환해 반환한다.
        StringBuilder sb = new StringBuilder();

        // 문자열 배열에 담기
        String[] answer = new String[4];
        for(int i=0; i<answer.length; i++) {
            String key = getKey(i);
            int[] value = map.getOrDefault(key, new int[]{0,0});
            sb.append(key).append(" ").append(value[0]).append(" ").append(value[1]);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        // 반환
        return answer;
    }

    private static String getKey(int index) {
        switch (index) {
            case 0: return "ON-D";
            case 1: return "ON-P";
            case 2: return "SOLD-D";
            case 3: return "SOLD-P";
            default : throw new IndexOutOfBoundsException();
        }
    }
}

class CarInfo {
    String id;
    String sellerType;
    String status;
    long price;
    LocalDate createdAt;

    public CarInfo(String id, String sellerType, String status, long price, LocalDate createdAt) {
        this.id = id;
        this.sellerType = sellerType;
        this.status = status;
        this.price = price;
        this.createdAt = createdAt;
    }
}
