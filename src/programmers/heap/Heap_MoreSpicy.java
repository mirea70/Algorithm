package programmers.heap;

import java.util.PriorityQueue;

public class Heap_MoreSpicy {
    public int solution(int[] scoville, int K) {
        // scoville을 우선순위 큐에 삽입(오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int num : scoville) {
            pq.add(num);
        }
        // 최앞단 스코빌지수 < K 동안 반복
        int count = 0;
        while(!pq.isEmpty() && pq.peek() < K) {
            if(pq.size() < 2) {
                return -1;
            }

            // - 카운트
            count++;
            // - 최앞단 2개 뽑기
            int first = pq.poll();
            int second = pq.poll();
            // - 섞어서 큐에 삽입
            pq.add(first + second * 2);
        }
        // 반복 종료
        // 카운트 반환
        return count;
    }
}
