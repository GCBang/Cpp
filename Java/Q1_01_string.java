package Java;

public class Q1_01_string {
    public static void main(String[] args){
        String sa = "(()())(())";
        System.out.println(solve(sa));
    }

    public static String solve(String s){
        //1 data structure
        StringBuilder sb = new StringBuilder();
        int open=0, close=0, start=0;

        //2 for문
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }else if(s.charAt(i) == ')'){
                close++;
            }

            if(open==close){
                sb.append(s.substring(start+1, i));
                start = i+1;
            }
        }
        return sb.toString();        
    }    
}