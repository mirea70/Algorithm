package leetcode.top150.arraystring;

public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        // nums 순회 -> val과 같지 않으면 기존 배열 index자리에 할당, 카운트
        int index = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
                count++;
            }
        }
        // 카운트 반환
        return count;
    }
}
