package Java;

import java.util.*;

public class Q1_05_dp {
    public static void main(String[] args){
        String s = "inflearn";

        //내 답안
        String[] wordDict = {"in", "f", "learn"};
        System.out.println(solve_Myself(s, wordDict));
        System.out.println();

        //강의 답안
		Q1_05_dp a = new Q1_05_dp();

		List<String> dict = new ArrayList<>();
		dict.add("f");
		dict.add("in");
		dict.add("learn");
		dict.add("ab");
		System.out.println(a.wordBreak_dp(s, dict));
    }
    public boolean wordBreak_dp(String s, List<String> dic) {
        //DP : 동적계획법 string(s) 에서 탐색하여 wordDict에 해당 값이 있는지를 체크
        Set<String> wordDictSet = new HashSet(dic); //중복되지 않기 위하여 해시 사용
        boolean[] dp = new boolean[s.length() + 1]; 
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	System.out.println("start i: "+i);
            for (int j = 0; j < i; j++) {
            	System.out.println("j: "+j+" i: "+i+" "+(s.substring(j, i))+"  dp["+j+"]: "+dp[j]);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                	System.out.println("-- "+s.substring(j, i));
                	dp[i] = true;
                    System.out.println("dp["+i+"] : "+dp[i]);
                    break;
                }
              	
              }
            System.out.println();
        }
        System.out.println("dp[s.length()]: "+dp[s.length()]+" "+s.length());
        return dp[s.length()];
    }

    //내 답안
    public static boolean solve_Myself(String s, String[] wordDict){
        for(int i=0; i<wordDict.length; i++){
            if(s.indexOf(wordDict[i]) < 0){
                return false;
            }
        }
        return true;
    }

}