package Java;

import java.util.Arrays;

public class Q2_02_greedy_mathmin {
    public static void main(String[] args){
        //{박스 갯수, 박스 크기}
        //int[][] boxTypes = { {1,3}, {2,2}, {3,1} };
        int[][] boxTypes = {{5,10}, {2,5}, {4,7}, {3,9}};
        int truckSize = 10;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); //sorting
		System.out.println(solve(boxTypes, truckSize));
    }
    public static int solve(int[][] boxTypes, int truckSize){
        int sum = 0;

        for(int[] val : boxTypes){
            int boxCnt = Math.min(truckSize, val[0]);
            
            truckSize -= boxCnt;
            sum += boxCnt * val[1];

            if(truckSize < 1) break;
        }
        return sum;
    }
}