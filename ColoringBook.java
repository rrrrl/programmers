package kakaoPre2017;

import java.util.Scanner;

public class ColoringBook {
	public static int cnt = 0;
	public static int cnt2 = 0;
	public static int max = Integer.MIN_VALUE;
	public static int[][] arr2;
	
	public static void solution2(int m, int n, int[][] picture, int num) {
		if(picture[m][n] != num) {
			return;
		}
		
		cnt2++;
		arr2[m][n] = 1;
		
		// 상
		if(m-1 >= 0 && arr2[m-1][n]==0 && picture[m-1][n] == num) {
			solution2(m-1, n, picture, num);
		}
		
		// 하
		if(m+1 < picture.length && arr2[m+1][n]==0 && picture[m+1][n] == num) {
			solution2(m+1, n, picture, num);
		}
		
		// 좌
		if(n-1 >= 0 && arr2[m][n-1]==0 && picture[m][n-1] == num) {
			solution2(m, n-1, picture, num);
		}
		
		// 우
		if(n+1 < picture[0].length && arr2[m][n+1]==0 && picture[m][n+1] == num) {
			solution2(m, n+1, picture, num);
		}
		
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
	      
	      cnt = 0;
	      cnt2 = 0;
	      max = Integer.MIN_VALUE;
	      arr2 = new int[m][n];
	      
	      int[] answer = new int[2];
	      
	      for(int i=0 ; i<m ; i++) {
	    	  for(int j=0 ; j<n ; j++) {
	    		  if(arr2[i][j] == 0 && picture[i][j] != 0) {
	    			  cnt2 = 0;
	    			  cnt++;
	    			  solution2(i, j, picture, picture[i][j]);
	    			  if(cnt2 > max) {
	    				  max = cnt2;
	    			  }
	    		  }
	    	  }
	      }
	      answer[0] = cnt;
	      answer[1] = max;
	      
	      return answer;
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
