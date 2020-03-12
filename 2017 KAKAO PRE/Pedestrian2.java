package kakaoPre2017;

import java.util.Scanner;

public class Pedestrian2 {
	static int MOD = 20170805;
	static int _m, _n;
	static int[][] r;
	static int[][] b;
	
	public static int solution(int m, int n, int[][] cityMap) {
	    int answer = 0;
	    
	    _m = m;
	    _n = n;
	    
	    r = new int[m+1][n+1];
	    b = new int[m+1][n+1];
	    
	    r[1][1] = 1;
	    b[1][1] = 1;
	    
	    for(int i=1 ; i<=m ; i++) {
	    	for(int j=1 ; j<=n ; j++) {
	    		if(i==1 && j==1)
	    			continue;
	    		if(cityMap[i-1][j-1] == 0) {
	    			r[i][j] = (r[i][j-1]%MOD) + (b[i-1][j]%MOD);
	    			b[i][j] = (r[i][j-1]%MOD) + (b[i-1][j]%MOD);
	    		} else if(cityMap[i-1][j-1] == 2) {
	    			r[i][j] = r[i][j-1]%MOD;
	    			b[i][j] = b[i-1][j]%MOD;
	    		}
	    	}
	    }
	    
	    answer = r[m][n]%MOD;
	    
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
