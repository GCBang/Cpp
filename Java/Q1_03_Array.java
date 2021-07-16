package Java;

public class Q1_03_Array {
    public static void main(String[] args){
        int[] input = {30, 30, 20, 150, 100, 40};
        //System.out.println(solveWorstPerformance(input));
        System.out.println(solve(input));
    }

    /*
    for문을 두 번 돌리면 안된다.
    이중 for 문 Time Complexity (시간복잡도) : O(n^2) -> worst performance
    */
    public static int solveWorstPerformance(int[] input){
        int res = 0;
        for(int i=0; i<input.length-1; i++){
            for(int j=i+1; j<input.length; j++){
                if( (input[i] + input[j]) % 60 == 0) res++;
            }
        }
        return res;
    }
    public static int solve(int[] input){
        int res = 0;
        int n = input.length;
        int[] types = new int[60]; // 0 - 59s

        for(int i=0; i<n; i++){
            int key = input[i] % 60; //모든 원소를 0~59 안의 수로 만들어서 배열화 함
            types[key]++;
        }
        // 0초 인 경우 > 0초 끼리 쌍을 맞춰줘야 %60 == 0 이 가능하다.
        if(types[0]>0){
            res += types[0] * (types[0]-1) / 2; // n개 끼리의 쌍 : n * (n-1) / 2
        }
        // 30초 인 경우도 위와 같은 이유로 계산
        if(types[30]>0){
            res += types[30] * (types[30]-1) / 2; // n개 끼리의 쌍 : n * (n-1) / 2
        }
        
        //위 두 경우를 제외한 나머지는 i초와 60-i초가 한 쌍
        for(int i = 1; i < 30; i++){
            res += types[i] * types[60-i]; // 각각 1:1 대응이므로 서로를 곱해주면 경우의 수가 나온다.
        }
        return res;
    }

}
