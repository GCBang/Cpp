package Java;

import java.util.Arrays;

public class Q1_04_2DArray {
    public static void main(String[] args){
        int n = 9;
        int[][] tmp = solve(n);
        //int[][] tmp = solve_Myself(n);
        for(int i = 0; i < tmp.length; i++){
            System.out.println(Arrays.toString(tmp[i]));
        }
    }
    public static int[][] solve(int n){
        // 1
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; 
        
        //2
        while (rowStart <= rowEnd && colStart <= colEnd) {
        	//right
        	for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; 
            }
            rowStart ++;
            
            //down
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++;
            }
            colEnd --;
            
            //left
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; 
            }
            rowEnd --;
            //up
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++;
            }
            colStart ++;
        }        
        return matrix;
    }

    //내 답지
    public static int[][] solve_Myself(int n){
        int[][] res = new int[n][n];
        if(n==0) return res;

        int exp=1, i=0, j=0, loop=0;

        int[] vr = {0, 1};
        int[] vl = {0, -1};
        int[] vu = {-1, 0};
        int[] vd = {1, 0};        
        int[] vector = vr.clone();

        while(exp <= (n*n)){
            res[i][j] = exp++;            
            if( i == loop && j == n-loop-1){ //우상단 도착
                vector = vd.clone(); //아래로 이동
            }else if(i == n-loop-1 && j == n-loop-1){ //우하단 도착
                vector = vl.clone(); //왼쪽으로 이동
            }else if(i == n-loop-1 && j == loop ){ //좌하단 도착
                vector = vu.clone(); //위로 이동
            }else if(i == loop+1 && j == loop){
                vector = vr.clone(); //오른쪽으로 이동
                loop++;
            }
            i += vector[0];
            j += vector[1];
        }

        return res;
    }    
}