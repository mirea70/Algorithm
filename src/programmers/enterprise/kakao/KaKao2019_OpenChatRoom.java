package programmers.enterprise.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KaKao2019_OpenChatRoom {
    private static StringBuilder sb = new StringBuilder();

    public String[] solution(String[] record) {
        // record 순회 -> 닉네임 map 저장
        Map<String, String> nickNameMap = new HashMap<>();
        for(String command : record) {
            String[] arr = command.split(" ");
            if(arr[0].equals("Leave")) {
                continue;
            }
            nickNameMap.put(arr[1], arr[2]);
        }

        // 다시 record 순회 -> Enter와 Leave일 때만 문자열을 만들어서 리스트에 담는다.
        List<String> list = new ArrayList<>();

        for(String command : record) {
            String[] arr = command.split(" ");
            String str = getStr(arr[0], nickNameMap.get(arr[1]));
            if(str != null) {
                list.add(str);
            }
            sb.setLength(0);
        }
        // 리스트 배열로 변환해 반환
        return list.toArray(new String[0]);
    }

    private String getStr(String type, String nickName) {
        switch (type) {
            case "Enter" : return getEnterStr(nickName);
            case "Leave" : return getLeaveStr(nickName);
            default: return null;
        }
    }

    private String getEnterStr(String nickName) {
        sb.append(nickName).append("님이 들어왔습니다.");
        return sb.toString();
    }

    private String getLeaveStr(String nickName) {
        sb.append(nickName).append("님이 나갔습니다.");
        return sb.toString();
    }
}
