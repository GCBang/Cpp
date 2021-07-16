package Java;

public class Q1_07_dfs {
    public static void main(String[] args){
        Q1_07_dfs a = new Q1_07_dfs();
        int[][] grid = { {8,1,0}, {0,7,6}, {0,9,0} };
        System.out.println(a.solve(grid));
    }
    //1. 전역변수로 가로,세로,방향 선언
    int totalVal = 0;
    int m, n;
    int[][] dirs = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    public int solve(int[][] grid){
        //1. ds
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; //방문

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0){
                    dfs(grid, i, j, visited, 0);
                }
            }
        }
        return totalVal;
    }
	public void dfs(int[][] grid, int i, int j, boolean[][] visited, int val) {
        //1. 영역 체크, 방문 체크, 문제의 조건 (0인 경우 건너뜀) 체크
        if(i<0 || j<0 || i>=m || j>= n || grid[i][j] == 0 || visited[i][j]) return;

        //2. dfs
        visited[i][j] = true; //방문처리
        val += grid[i][j]; //이전 값 + 현재 값
        totalVal = Math.max(totalVal, val);
        //인접 노드에 대한 dfs함수 호출
        for(int[] dir : dirs){
            dfs(grid, i+dir[0], j+dir[1], visited, val);
        }
        visited[i][j] = false; //방문처리 해제 (이전으로 이동할 수 있다)
    }

    
	public static void boolprint(boolean[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(" [" + i + "][" + j + "] " + arr2[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void print(int[][] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(" a[" + i + "][" + j + "] " + arr2[i][j]);
			}
			System.out.println("");
		}
	}

}