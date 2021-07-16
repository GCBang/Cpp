package Java;
import java.util.*;

public class Q1_06_bfs_PriorityQueue {
    public static void main(String[] args){
        Q1_06_bfs_PriorityQueue a = new Q1_06_bfs_PriorityQueue();
        int[][] grid = { {2,4,1}, {3,8,1}, {4,5,1}};
        System.out.println(a.solve(grid));
    }
    //1. 전역변수로 가로,세로,방향 선언
    int m, n;
    int[][] dirs = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    public int solve(int[][] grid){
        //1. ds
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; //방문
 
        //minHeap(최소힙)으로 선언
        Queue<int[]> PriorityQ = new PriorityQueue<>((a,b)->a[2]-b[2]); //2번째 원소를 기준으로 오름차순
        PriorityQ.add(new int[] {0,0,grid[0][0]});
        visited[0][0] = true;
        
        //2. for while
        while(!PriorityQ.isEmpty()){
            int[] cur = PriorityQ.poll(); //큐에서 값을 뺀다.(커서)
            for(int[] dir : dirs){
                int x= cur[0]+dir[0];
                int y= cur[1]+dir[1];
                //범위 밖 체크, 방문 여부 체크
                if(x>=0 && y>=0 && x<m && y<n && !visited[x][y]){
                    int[] next = new int[] {x, y, cur[2]+grid[x][y]}; // [x좌표, y좌표, 누적합계]
                    if(next[0] == m-1 && next[1] == n-1){ //마지막에 도착하면
                        return next[2];
                    }
                    visited[x][y] = true;
                    //print(next);
                    //print_bool(visited);
                    PriorityQ.add(next);
                }
            }
        }
        return grid[0][0];
    }
    
	
	void print(int[] grid) {
		for (int i = 0; i < grid.length; i++) {
			System.out.println("grid["+i+"] "+grid[i]+" ");
		}
		System.out.println("");
	}
	
	void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
//			System.out.print("grid["+i+"] "+grid[i].length+"\t");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public void print_bool(boolean[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n ; j++) {
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
	}
}