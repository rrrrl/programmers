package kakaoPre2017;

import java.util.Scanner;
import java.util.Stack;

public class ColoringBook2 {
	public static boolean[][] visited;
	
	public static int[] solution(int m, int n, int[][] picture) {
	      
	    visited = new boolean[m][n];
	    
	    int[] answer = bfs(m, n, picture);
	    return answer;
	}
	
	public static int[] bfs(int m, int n, int[][] arr) {
		int[] answer = new int[2];
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				int cnt = 0;
				if(arr[i][j] != 0 && !visited[i][j]) {
					stackAdd(st1, st2, i, j);
					answer[0]++;
					cnt++;
				}
				
				
				while(!st1.isEmpty()) {
					int x = st1.pop();
					int y = st2.pop();
					
					// 상
					if(x-1 >= 0 && !visited[x-1][y] && arr[x-1][y] == arr[x][y]) {
						stackAdd(st1, st2, x-1, y);
						cnt++;
					}
					
					// 하
					if(x+1 < arr.length && !visited[x+1][y] && arr[x+1][y] == arr[x][y]) {
						stackAdd(st1, st2, x+1, y);
						cnt++;
					}
					
					// 좌
					if(y-1 >= 0 && !visited[x][y-1] && arr[x][y-1] == arr[x][y]) {
						stackAdd(st1, st2, x, y-1);
						cnt++;
					}
					
					// 우
					if(y+1 < arr[0].length && !visited[x][y+1] && arr[x][y+1] == arr[x][y]) {
						stackAdd(st1, st2, x, y+1);
						cnt++;
					}
				}
				if(cnt > answer[1]) {
					answer[1] = cnt;
				}
			}
		}
		
		return answer;
	}
	
	public static void stackAdd(Stack<Integer> st1, Stack<Integer> st2, int m, int n) {
		st1.add(m);
		st2.add(n);
		visited[m][n] = true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] answer = solution(m, n, arr);
		System.out.println(answer[0] + " " + answer[1]);
		}
	}
}
