package interview;

import java.util.*;

public class Encar4 {

    public static void main(String[] args) {
        String[] records = {
                "C1,Sunroof|Navi|HeatedSeat",
                "C2,Navi|HeatedSeat",
                "C3,Sunroof|Navi",
                "C4,Sunroof|Navi|HeatedSeat|Camera"
        };

        String[] requiredOptions = {"Sunroof", "Navi"};

        String[] records2 = {
                "A1, sunroof | navi | camera ",
                "A2, Navi|Camera",
                "A3, SUNROOF|NAVI",
                "A4, sunroof | heatedseat "
        };

        String[] requiredOptions2 = {"SunRoof", "NaVi"};


        String[] records3 = {
                "B1,Camera|HeatedSeat",
                "B2,Sunroof",
                "B3,Navi"
        };

        String[] requiredOptions3 = {"Sunroof", "Navi"};


        System.out.println(Arrays.toString(solution(records3, requiredOptions3)));
    }

    public static String[] solution(String[] records, String[] requiredOptions) {
        // requiredOptions 소문자로 변경해두기
        Set<String> requiredOptionSet = new HashSet<>();
        for(int i=0; i<requiredOptions.length; i++) {
            requiredOptionSet.add(requiredOptions[i].toLowerCase());
        }

        List<String> list = new ArrayList<>();
        // records 순회 -> requiredOptions보다 길이가 크거나 같으면서, trueCount가 requiredOptions 길이 이상이면 true
        for(String record : records) {
            String[] arr = record.split(",");
            String carId = arr[0];
            String[] options = arr[1].trim().replaceAll("\\s+", "").split("\\|");

            Set<String> optionSet = new HashSet<>();
            for(String option : options) {
                optionSet.add(option.toLowerCase());
            }

            // true이면 리스트에 담기
            if(optionSet.containsAll(requiredOptionSet)) {
                list.add(carId);
            }
        }
        // 순회 끝
        // 리스트 오름차순 정렬
        Collections.sort(list);

        return list.toArray(new String[0]);
    }
}
