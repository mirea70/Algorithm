package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce_14501 {
    static int N;
    static int max_profit = 0;
    static int[][] consult_info;

    public static void main(String[] args) throws IOException {
        // 설계 : 15C7 = 15! / 7! * 8! = 13 * 11 * 5 * 9 = 6435번 * 15 * 15 = 약 10^6 -> 완탐 충분

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        consult_info = new int[N+1][2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            consult_info[i][0] = Integer.parseInt(st.nextToken());
            consult_info[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1개 뽑는 경우 ~ N개 뽑는 경우까지 상담을 하는 일자를 선택하는 경우의 수 뽑아서 최대 수익 갱신
        for(int i=1; i<=N; i++) {
            combination(new boolean[N+1], new int[i], 1, 0, i);
        }
        // 최대 수익 출력
        System.out.print(max_profit);
    }

    // 상담을 하는 일자를 선택하는 경우의 수 뽑기
    private static void combination(boolean[] visited, int[] selected, int start, int depth, int r) {
        if(depth == r) {
            // 뽑아서 불가능한 경우인지 체크
            // 최대 수익 갱신
            int validatedSumResult = getValidatedSumResult(selected);
            if(validatedSumResult != -1) {
                max_profit = Math.max(max_profit, validatedSumResult);
            }
            return;
        }

        for(int i=start; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                combination(visited, selected, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    private static int getValidatedSumResult(int[] selected) {
        // N+1 크기의 날짜 점유 배열 생성
        boolean[] owned = new boolean[N+1];
        int sum = 0;
        // selected 순회
        for(int select_num : selected) {
            // 점유 불가시 -1 리턴
            if(owned[select_num] || select_num + consult_info[select_num][0] - 1 > N) {
                return -1;
            }
            // 상담정보 참조해서 날짜를 점유해나가고, 합계 누적
            for(int i=select_num; i<select_num+consult_info[select_num][0]; i++) {
                owned[i] = true;
            }
            sum += consult_info[select_num][1];
        }
        // 순회 끝
        // 합계 반환
        return sum;
    }
}
