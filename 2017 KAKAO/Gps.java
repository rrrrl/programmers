package kakao2017;

public class Gps {
	static int _n;
	static int _m;
	static int[][] _edge_list;
	static int _k;
	static int[] _gps_log;
	static int[] arr;
	static int min;
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
	    int answer = 0;
	    
	    _n = n;
	    _m = m;
	    _edge_list = edge_list;
	    _k = k;
	    _gps_log = gps_log;
	    arr = new int[k];
	    arr[0] = gps_log[0];
	    min = Integer.MAX_VALUE;
	    
	    dfs(gps_log[0], 1);
	    
	    if(min == Integer.MAX_VALUE) {
	    	return -1;
	    } else {
	    	answer = min;
	    }
	    
	    return answer;
	}
	
	public static void dfs(int node, int cnt) {
		if(cnt == _k) {
			if(node == _gps_log[_k-1]) {
				int diff = 0;
				for(int i=0 ; i<_k ; i++) {
					if(_gps_log[i] != arr[i]) {
						diff++;
					}
				}
				if(diff < min)
					min = diff;
				return;
			} else {
				return;
			}
		}
		
		int diff = 0;
		for(int i=0 ; i<cnt ; i++) {
			if(_gps_log[i] != arr[i]) {
				diff++;
			}
		}
		if(diff > min) {
			return;
		}
		
		for(int i=0 ; i<_m ; i++) {
			if(_edge_list[i][0] == node) {
				arr[cnt] = _edge_list[i][1];
				dfs(_edge_list[i][1], cnt+1);
				arr[cnt] = 0;
			} else if(_edge_list[i][1] == node) {
				arr[cnt] = _edge_list[i][0];
				dfs(_edge_list[i][0], cnt+1);
				arr[cnt] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,6},{5,6},{5,7},{6,7}};
		int k = 2;
		//int[] gps_log = {1,2,3,3,6,7};
		int[] gps_log = {1,7};
		
		int answer = solution(n, m, edge_list, k, gps_log);
		System.out.println(answer);
	}
}
