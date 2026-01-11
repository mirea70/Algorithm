package interview;

import java.util.*;

public class Encar2 {
    public static void main(String[] args) {
        String brand = "HyUnDaI";
        String model = "  Avante   N  ";
        int minPrice = 2000;
        int maxPrice = 1500;
        String sort = "priceAsc";
        String[] options = new String[]{"SunRoof", "  navi", "NAVI", "", "sunroof"};

        System.out.println(solution(brand, model, minPrice, maxPrice, sort, options));
    }

    public static String solution(String brand, String model, int minPrice, int maxPrice, String sort, String[] options) {
        String afterBrand = brand.toLowerCase();

        String afterModel = model.trim();
        afterModel = afterModel.replaceAll("\\s+", " ");

        if(minPrice > maxPrice) {
            int temp = minPrice;
            minPrice = maxPrice;
            maxPrice = temp;
        }

        Set<String> optionList = new TreeSet<>();
        for(String option : options) {
            String afterOption = option.trim();
            if(!afterOption.isEmpty()) {
                afterOption = afterOption.toLowerCase();
                optionList.add(afterOption);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(afterBrand).append("|")
                .append(afterModel).append("|")
                .append(minPrice).append("|")
                .append(maxPrice).append("|")
                .append(sort).append("|");

        if(!optionList.isEmpty()) {
            for(String option : optionList) {
                sb.append(option).append(",");
            }

            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
