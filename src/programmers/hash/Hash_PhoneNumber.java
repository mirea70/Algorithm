package programmers.hash;

import java.util.HashSet;
import java.util.Set;

public class Hash_PhoneNumber {
    public boolean solution(String[] phone_book) {
        // phone_book을 순회하며 Set에 그 값을 저장해둔다.
        Set<String> phoneSet = new HashSet<>();
        for(String phone : phone_book) {
            phoneSet.add(phone);
        }

        // phone_book을 다시 순회하며 각 전화번호의 1자리 ~ 끝자리까지 Set에 존재하는지 확인한다.
        for(String phone : phone_book) {
            for(int i=0; i<phone.length()-1; i++) {
                String partNumber = phone.substring(0, i+1);
                // 존재하면 false 리턴
                if(phoneSet.contains(partNumber)) {
                    return false;
                }
            }
        }
        // 순회 끝
        // true 리턴
        return true;
    }
}
