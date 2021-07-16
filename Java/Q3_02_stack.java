package Java;

import java.util.*;

public class Q3_02_stack {
    public static void main(String[] args){
        //int[] asteroids = { 3, 10, -6 };
		//int[] asteroids = { -3,1,-1,5,1,2};
		int[] asteroids = { 3,1,-1,-2,1};
        int[] result = solve(asteroids);

        for(int i:result)
			System.out.println("i "+i);
    }
    public static int[] solve(int[] asteroids){
        Stack<Integer> s = new Stack<>();

        for(int val : asteroids){
            if(val > 0) s.push(val); //+는 전부 push
            else{ //-일때
                //+보다 -가 크면 기존꺼 빼기
                while (!s.isEmpty() && s.peek() > 0 && s.peek() + val < 0){ //이전 값들도 확인해서 조건 해당되면 모두 pop
                    s.pop();
                }
                if(s.empty() || s.peek() < 0){ //비어있으면 push
                    s.push(val);
                }else if(s.peek() + val == 0){ //같으면 둘 다 없어짐
                    s.pop();
                }else if(s.peek() + val < 0){ 
                    s.pop();
                    s.push(val);
                }
            }
        }

        int[] res = new int[s.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = s.pop();
        }

        return res;
    }
}