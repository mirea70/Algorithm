package leetcode.top150.interval;

import java.util.ArrayList;
import java.util.List;

public class Q228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> list = new ArrayList<>();
        if(len == 0) return list;

        // 포인터 left, right로 nums 순회
        int left = 0, right = 1;

        while(right <= nums.length) {
            // - 마지막이거나, 현재 수와 직전 수가 연속되지 않았다면
            if(right == len || (long) nums[right] != ((long) nums[right - 1]) + 1L) {
                // -- left ~ 직전까지를 리스트에 담고
                addToList(nums, list, left, right);
                // -- left = right로 갱신
                left = right;
            }
            right++;
        }
        // 순회 끝
        // 리스트 반환
        return list;
    }

    private void addToList(int[] nums, List<String> list, int left, int right) {
        list.add(left == right - 1
                ? String.valueOf(nums[left])
                : nums[left] + "->" + nums[right - 1]);
    }
}
