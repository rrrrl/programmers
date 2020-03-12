package kakaoPre2017;

import java.util.Scanner;

public class Pedestrian {
	static int MOD = 20170805;
	static int _m, _n;
	static int[][] chk;
	
	public static int solution(int m, int n, int[][] cityMap) {
	    int answer = 0;
	    
	    _m = m;
	    _n = n;
	    
	    chk = new int[m][n];
	    
	    answer = dfs(0, 0, cityMap, -1);
	    
	    answer %= MOD;
	    
	    return answer;
	}

	public static int dfs(int x, int y, int[][] arr, int dir) {
		int answer = 0;
		
		if(arr[x][y] == 1) {
			chk[x][y] = 1;
			return 0;
		}
		if(x == _m-1 && y == _n-1) {
			return 1;
		}
		
		// 오른쪽
		if(y+1 < _n && (arr[x][y]==0 || arr[x][y]==2 && dir==1)) {
			chk[x][y] = 1;
			answer += dfs(x, y+1, arr, 1);
		}
		
		// 아래
		if(x+1 < _m && (arr[x][y]==0 || arr[x][y]==2 && dir==2)) {
			answer += dfs(x+1, y, arr, 2);
		}

		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = solution(m, n, arr);
		System.out.println(answer);
	}
}
