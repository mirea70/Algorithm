package leetcode.top150.arraystring;

public class Q58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // s 를 거꾸로 순회하며, 공백 만날때까지 카운트
        int count = 0;
        for(int i=s.length()-1; i>=0; i--) {
            // 첫 문자 만나기 전 공백이면 스킵
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count > 0) {
                break;
            }
        }
        // 카운트 반환
        return count;
    }
}
