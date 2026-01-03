package programmers.sort;

import java.util.Arrays;

public class SortMaxNumber {
    public String solution(int[] numbers) {
        // numbers를 문자열배열로 변환
        int len = numbers.length;
        String[] arr = new String[len];
        for(int i =0; i<len; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        // 앞자리가 큰 순서대로 정렬
        Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        // 이어붙여서 출력
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
