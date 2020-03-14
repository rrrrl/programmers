/*
 * refer : https://stack07142.tistory.com/289
 */
package kakaoPre2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Camping2 {
	public static int solution(int n, int[][] data) {
	    int answer = 0;
	    
	    ArrayList<Integer> xList = new ArrayList<Integer>();
	    ArrayList<Integer> yList = new ArrayList<Integer>();
	    
	    for(int i=0 ; i<n ; i++) {
	    	xList.add(data[i][0]);
	    	yList.add(data[i][1]);
	    }
	    
	    ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<>(xList));
	    ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<>(yList));
	    
	    Collections.sort(uniqueXList);
	    Collections.sort(uniqueYList);
	    
	    int[][] s = new int[n][n];
	    
	    for(int i=0 ; i<n ; i++) {
	    	int x = uniqueXList.indexOf(data[i][0]);
	    	int y = uniqueYList.indexOf(data[i][1]);
	    	
	    	data[i][0] = x;
	    	data[i][1] = y;
	    	
	    	s[x][y] = 1;
	    }
	    
	    for(int i=0 ; i<n ; i++) {
	    	for(int j=0 ; j<n ; j++) {
	    		s[i][j] += (i-1>=0 ? s[i-1][j] : 0) + (j-1>=0 ? s[i][j-1] : 0) - ((i-1>=0 && j-1>=0) ? s[i-1][j-1] : 0);
	    	}
	    }
	    
	    for(int i=0 ; i<n ; i++) {
	    	for(int j=i+1 ; j<n ; j++) {
	    		
	    		if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
	    		
    			int min_x = Math.min(data[i][0], data[j][0]);
    			int max_x = Math.max(data[i][0], data[j][0]);
    			int min_y = Math.min(data[i][1], data[j][1]);
    			int max_y = Math.max(data[i][1], data[j][1]);
    			
    			int cnt = 0;
    			if(min_x+1 > max_x-1 || min_y+1 > max_y-1) {
    				cnt = 0;
    			} else {
    				cnt = s[max_x-1][max_y-1] - s[min_x][max_y-1] - s[max_x-1][min_y] + s[min_x][min_y];
    			}
    			if(cnt == 0) answer++;
    		
	    	}
	    }
	    
	    return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i=0 ; i<n ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int answer = solution(n, arr);
		System.out.println(answer);
	}
}
