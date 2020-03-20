package kakao2017;

public class Gps2 {
	static int[][] dp;
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
	    int answer = 0;
	    
	    dp = new int[k+1][n+1];
	    
	    for(int i=0 ; i<=k ; i++) {
	    	for(int j=0 ; j<=n ; j++) {
	    		dp[i][j] = 987654321;
	    	}
	    }
	    
	   dp[1][gps_log[0]] = 0;
	   
	   for(int i=2 ; i<=k ; i++) {
		   for(int j=1 ; j<=n ; j++) {
			   int add = (gps_log[i-1] == j ? 0 : 1);
			   dp[i][j] = Math.min(dp[i-1][j]+add, dp[i][j]);
			   for(int l=0 ; l<m ; l++) {
				   if(edge_list[l][0] == j) {
					   dp[i][j] = Math.min(dp[i-1][edge_list[l][1]]+add, dp[i][j]);
				   } else if(edge_list[l][1] == j) {
					   dp[i][j] = Math.min(dp[i-1][edge_list[l][0]]+add, dp[i][j]);
				   }
			   }
		   }
	   }
	    
	    
	    if(dp[k][gps_log[k-1]] > k) {
	    	return -1;
	    } else {
	    	answer = dp[k][gps_log[k-1]];
	    }
	    
	    return answer;
	}
	
	
	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,6},{5,6},{5,7},{6,7}};
		int k = 6;
		int[] gps_log = {1,2,3,3,6,7};
		//int[] gps_log = {1,2,4,6,5,7};
		//int[] gps_log = {1,4,1,4,1,7};
		//int[] gps_log = {0,0};
		
		int answer = solution(n, m, edge_list, k, gps_log);
		System.out.println(answer);
	}
}
