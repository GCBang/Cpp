package Java;

public class Q3_03_String {
    
    public static void main(String[] args){
		int[] releaseTimes = { 9, 29, 49, 50 };
		String keysPressed = "cbcd";
		System.out.println(solve(releaseTimes, keysPressed));
	}

	public static char solve(int[] time, String key) {
        char res = key.charAt(0);
        int max = time[0];
        
        for(int i=1; i<time.length; i++){
            int diff = time[i]-time[i-1];
            if( diff > max || (diff == max && key.charAt(i) >res)){
                max = diff;
                res = key.charAt(i);
            }
        }
        return res;
    }    
}