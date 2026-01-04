package leetcode.top150.slidingwindow;

public class Q209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = len + 1;
        // 실시간 합 선언
        int left = 0;
        int right = 0;
        int sum = 0;
        // right를 한칸씩 늘려나가며 nums 길이끝까지 반복
        while(right < len) {
            // - right 값 합에 반영
            sum += nums[right];
            // - 합 >= target 이면, 만족할 동안 min 갱신하면서, left 줄이기
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
            // - right 늘리기
            right++;
        }
        // 반복 끝
        // min == len이면 0, 아니면 min 반환
        return min != len + 1 ? min : 0;
    }
}
