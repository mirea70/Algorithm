package leetcode.top150.arraystring;

public class Q26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // nums 순회 -> 이전 값과 같지않으면 nums의 앞부터 할당해나간다.
        int writeIdx = 1;

        for(int readIdx = 1; readIdx < nums.length; readIdx++) {
            if(nums[readIdx] != nums[readIdx - 1]) {
                nums[writeIdx++] = nums[readIdx];
            }
        }

        return writeIdx;
    }
}
