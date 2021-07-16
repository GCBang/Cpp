package Java;

public class Q3_01_toCharArray {
    public static void main(String[] args){
        String s = "abccba";
		System.out.println(solve(s));
    }
    public static String solve(String s){
        if(s.length() <= 1) return "";
		char[] res = s.toCharArray();
        
        for(int i=0; i<s.length()/2; i++){
            if(res[i] != 'a'){
                res[i] = 'a';
                return String.valueOf(res);
            }
        }
        res[res.length-1] = 'b';        
        return String.valueOf(res);
    }
}