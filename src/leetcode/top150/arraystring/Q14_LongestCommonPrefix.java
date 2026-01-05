package leetcode.top150.arraystring;

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // max 길이, 인덱스 찾기
        int maxLen = 0;
        int maxIdx = 0;
        for(int i=0; i<strs.length; i++) {
            int len = strs[i].length();
            if(len > maxLen) {
                maxLen = len;
                maxIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        // 0번 부터 포인터를 통해 모든 문자열이 동일한지 체크하며 문자열에 더해가기
        outer: while(pointer < maxLen) {
            char target = strs[maxIdx].charAt(pointer);

            for(String s : strs) {
                // 길이 넘어선 문자열 있거나, 다르면 종료
                if(s.length() <= pointer || s.charAt(pointer) != target) {
                    break outer;
                }
            }
            sb.append(target);
            pointer++;
        }
        // sb 길이가 0이면 "" 아니면 문자열로 반환
        return sb.length() != 0 ? sb.toString() : "";
    }
}
