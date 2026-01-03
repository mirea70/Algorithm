package programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort_HIndex {
    public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int h = 0;

        for (int i = 0; i < citations.length; i++) {
            int candidate = i+1;
            if (arr[i] >= candidate) h = candidate;
            else break; // 뒤는 더 작아지니 종료 가능
        }
        return h;
    }
}
