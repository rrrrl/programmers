/*
 * refer : https://wwiiiii.tistory.com/entry/%EC%B9%B4%EC%B9%B4%EC%98%A4-Code-Festival-%EB%B3%B8%EC%84%A0-16%EB%B2%88-%ED%92%80%EC%9D%B4
 */
package kakao2017;

public class LittleFriends2 {
	static char[][] arr;
	static int[][] coord;
	static char[] alpha;
	public static String solution(int m, int n, String[] board) {
	    String answer = "";
	    
	    int ch = 'Z'-'A'+1;
	    
	    coord = new int[ch][4];
	    alpha = new char[ch];
	    
	    arr = new char[m][n];
	    
	    for(int i=0 ; i<m ; i++) {
	    	for(int j=0 ; j<n ; j++) {
	    		arr[i][j] = board[i].charAt(j);
	    		if(arr[i][j] >= 'A' && arr[i][j] <= 'Z') {
	    			char tmp = arr[i][j];
	    			if(alpha[tmp-'A'] == '\0') {
	    				alpha[tmp-'A'] = tmp;
	    				coord[tmp-'A'][0] = i;
	    				coord[tmp-'A'][1] = j;
	    			} else {
	    				coord[tmp-'A'][2] = i;
	    				coord[tmp-'A'][3] = j;
	    			}
	    		}
	    	}
	    }
	    
	    boolean result = true;
	    
	    while(result) {
	    	result = false;
		    for(int i='A' ; i<='Z' ; i++) {
		    	if(alpha[i-'A'] != '\0') {
		    		result = find(i);
		    		if(result) {
		    			arr[coord[i-'A'][0]][coord[i-'A'][1]] = '.';
		    			arr[coord[i-'A'][2]][coord[i-'A'][3]] = '.';
		    			alpha[i-'A'] = '\0';
		    			answer += (char) i;
		    			break;
		    		}
		    	}
		    }
	    }
	    
	    for(int i=0 ; i<m ; i++) {
	    	for(int j=0 ; j<n ; j++) {
	    		if(arr[i][j] != '.' && arr[i][j] != '*')
	    			return "IMPOSSIBLE";
	    	}
	    }
	    
	    return answer;
	}
	
	public static boolean find(int idx) {
		int x = coord[idx-'A'][0];
		int y = coord[idx-'A'][1];
		int nx = coord[idx-'A'][2];
		int ny = coord[idx-'A'][3];
		int a = x, b = y;
		
		boolean flag = true;
	    while(flag && a != nx){
	        if(a > nx) a--;
	        else if(a < nx) a++;
	        if(a != nx || b != ny){
	            if(arr[a][b] != '.') flag = false;
	        }
	    }
	    while(flag && b != ny){
	        if(b > ny) b--;
	        else if(b < ny) b++;
	        if(a != nx || b != ny){
	            if(arr[a][b] != '.') flag = false;
	        }
	    }
	    if(flag) return true;
	    flag = true; a = x; b = y;
	    while(flag && b != ny){
	        if(b > ny) b--;
	        else if(b < ny) b++;
	        if(a != nx || b != ny){
	            if(arr[a][b] != '.') flag = false;
	        }
	    }
	    while(flag && a != nx){
	        if(a > nx) a--;
	        else if(a < nx) a++;
	        if(a != nx || b != ny){
	            if(arr[a][b] != '.') flag = false;
	        }
	    }
	    if(flag) return true;
	    return false;

	}
	
	public static void main(String[] args) {
		int m = 2;
		int n = 4;
		//tring[] board = {"DBA", "C*A", "CDB"};
		String[] board = {"NRYN", "ARYA"};
		//String[] board = {".ZI.", "M.**", "MZU.", ".IU."};
		//String[] board = {"AB", "BA"};
		
		String ans = solution(m, n, board);
		System.out.println(ans);
	}
}
