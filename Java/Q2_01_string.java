package Java;

public class Q2_01_string {    
    public static void main(String[] args){
        //String s = "GGLG";
        //String s = "GG";
        String s = "GLR";
        
		System.out.println(solve(s));        
		System.out.println(solve2(s));
        System.out.println(solve_myself(s));
    }

	public static boolean solve(String comm) {
		if (comm.length() == 0)
			return false;
		int x = 0;
		int y = 0;
		String dir = "N";

		for (char ch : comm.toCharArray()) {
			if (ch == 'G') {
				if (dir.equals("N"))
					y += 1;
				else if (dir.equals("S"))
					y -= 1;
				else if (dir.equals("E"))
					x += 1;
				else if (dir.equals("W"))
					x -= 1;
			} else if (ch == 'L') {
				if (dir.equals("N"))
					dir = "W";
				else if (dir.equals("W"))
					dir = "S";
				else if (dir.equals("S"))
					dir = "E";
				else
					dir = "N";
			} else if (ch == 'R') {
				if (dir.equals("N"))
					dir = "E";
				else if (dir.equals("E"))
					dir = "S";
				else if (dir.equals("S"))
					dir = "W";
				else
					dir = "N";
			}
		}
		if (x == 0 && y == 0)
			return true;
		if (dir.equals("N"))
			return false;
		return true;
	}

	public static boolean solve2(String command) {
		// N = 0, E = 1, S = 2, W = 3
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int x = 0, y = 0;
		// direction
		int dir = 0;

		for (char i : command.toCharArray()) {
			if (i == 'G') {
				x += dirs[dir][0];
				y += dirs[dir][1];
			} else if (i == 'L') {
				dir = (dir + 3) % 4;
			} else if (i == 'R') {
				dir = (dir + 1) % 4;
			}
		}
		if (x == 0 && y == 0) {
			return true;
		}
		if (dir == 0) {
			return false;
		}
		return true;
	}

    
    //내 답안
    public static boolean solve_myself(String s){
        if(s.length() == 0) return false;

        int lx=0, ly=0; //초기값 설정
        int dx=1, dy=0; //기본 방향 설정

        for(int i=0; i<s.length(); i++){
            if( s.charAt(i) == 'G' ){ //직진할 경우, 설정된 방향으로 이동
                lx += dx;
                ly += dy;
            }else if( s.charAt(i) == 'L' ){ //왼쪽으로 돌 경우
                if(dy == 0){
                    dy = dx;
                    dx = 0;
                }else{
                    dx = dy*-1;
                    dy = 0;
                }
            }else if( s.charAt(i) == 'R' ){ //오른쪽으로 돌 경우
                if(dy == 0){
                    dy = dx*-1;
                    dx = 0;
                }else{
                    dx = dy;
                    dy = 0;
                }
            }
        }
        //마지막에 설정된 방향에 맞게 한 칸 더 이동 (동일선상이어도 방향 변할경우 > 원 가능)
        lx += dx;
        ly += dy;

        //초기값과 비교하여 동일선상에 있는 경우 > 원 불가능
        if( lx == 0 || ly == 0 ) return false;
        
        return true;
    }
}