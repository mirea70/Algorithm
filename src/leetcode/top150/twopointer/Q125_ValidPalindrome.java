package leetcode.top150.twopointer;

public class Q125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        // 시작 포인터, 끝 포인터를 각각 오르 내림하면서 서로 다르면 false
        String normalized = normalize(s);
        int start = 0;
        int end = normalized.length() -1;

        while(start < end) {
            if(normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        // 순회 끝
        // true
        return true;
    }

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
