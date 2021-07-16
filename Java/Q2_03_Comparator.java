package Java;

import java.util.Arrays;
import java.util.Comparator;

public class Q2_03_Comparator {
    
    public static void main(String[] args){
        /*
        로그 정렬 조건
        1. letter - digit 순
        2. letter : 알파벳 순, 같으면 먼저 온 순
        3. digit : 먼저 온 순서대로
        */
		String[] input = { 
            "dig1 8 1 5 1", 
            "let1 art can", 
            "dig1 3 6", 
            "let2 own kit dig", 
            "let3 art zero"
        };
        Q2_03_Comparator a = new Q2_03_Comparator();

        String[] res = a.sortLogs(input);
        for(String s : res){
            System.out.println("s : " + s);
        }
    }

    public String[] sortLogs(String[] logs){
        Arrays.sort(logs, (s1, s2)->{
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2) {
                // 1. 모두 문자
                int comp = split1[1].compareTo(split2[1]); //첫 문자를 비교 ( 2번 조건 )
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
                
            } else if (isDigit1 && isDigit2) {
                // 2. 모두 숫자. 
                return 0; //그대로 (3번 조건)

            } else if (isDigit1 && !isDigit2) {
                // 3. 첫번째는 숫자, 두번째는 문자.
                return 1; //숫자가 뒤에 (1번 조건)
            } else {
                // 4. 첫번째는 문자, 두번째는 숫자.
                return -1; //문자가 앞에 (1번 조건)
            }

        });
		return logs;
    }


}
