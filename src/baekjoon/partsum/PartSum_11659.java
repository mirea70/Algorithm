package baekjoon.partsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartSum_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] totalSums = new int[N+1];
        st = new StringTokenizer(br.readLine());

        // 누적합 배열을 미리 구해놓은 뒤
        for(int i=1; i<=N; i++) {
            totalSums[i] = totalSums[i-1] + Integer.parseInt(st.nextToken());
        }
        // 구간별로 누적합 배열에서 바로바로 출력한다.
        while(M--> 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(totalSums[j] - totalSums[i-1]);
        }
    }
}
