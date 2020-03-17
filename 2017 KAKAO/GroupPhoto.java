package kakao2017;

import java.util.HashMap;

public class GroupPhoto {
	static HashMap hm;
	static boolean[] visited;
	static int[] pos;
	static int answer;
	public static int solution(int n, String[] data) {
	    answer = 0;
	    
	    hm = new HashMap<Character, Integer>();
	    
	    hm.put('A', 0);
	    hm.put('C', 1);
	    hm.put('F', 2);
	    hm.put('J', 3);
	    hm.put('M', 4);
	    hm.put('N', 5);
	    hm.put('R', 6);
	    hm.put('T', 7);
	    
	    visited = new boolean[8];
	    pos = new int[8];
	    
	    dfs(0, data);
	    return answer;
	}
	
	public static void dfs(int idx, String[] data) {
		
		if(idx == 8) {
			for(int i=0 ; i<data.length ; i++) {
				int from = pos[(int)hm.get(data[i].charAt(0))];
				int to = pos[(int)hm.get(data[i].charAt(2))];
				char sign = data[i].charAt(3);
				int gap = data[i].charAt(4) - '0';
				
				if(sign == '=') {
					if(Math.abs(from-to) != gap+1)
						return;
				} else if(sign == '<') {
					if(Math.abs(from-to) >= gap+1)
						return;
				} else if(sign == '>') {
					if(Math.abs(from-to) <= gap+1)
						return;
				}
			}
			answer++;
			return;
		}
		
		for(int i=0 ; i<8 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				pos[i] = idx;
				dfs(idx+1, data);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 2;
		//String[] data = {"N~F=0", "R~T>2"};
		String[] data = {"M~C<2", "C~M>1"};
		
		int ans = solution(n, data);
		System.out.println(ans);
	}
}
