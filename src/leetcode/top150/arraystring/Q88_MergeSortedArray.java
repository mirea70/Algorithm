package leetcode.top150.arraystring;

public class Q88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // p1(nums1), p2(nums2), k(nums1 전체) 포인터
        int p1 = m-1, p2 = n-1, k = m + n - 1;
        // nums1의 맨 뒤에서부터 크기가 큰 순서대로 거꾸로 채워간다.
        while(p2>=0) {
            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[k--] = nums1[p1--];
            }
            else {
                nums1[k--] = nums2[p2--];
            }
        }
    }
}
