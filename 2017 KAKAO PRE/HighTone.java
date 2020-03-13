/*
 * [reference] https://artineer.tistory.com/121
 * 
 */

package kakaoPre2017;

import java.util.Scanner;

public class HighTone {
	static int maxThree;
	static int count;
	public static int solution(int n) {
		maxThree = (int)(Math.log10(n)/Math.log10(3));
		count = 0;
		
	    int answer = 0;
	    
	    solve(n-2, 0, 2);
	    
	    answer = count;
	    
	    return answer;
	}
	
	public static void solve(int n, int cntStar, int cntPlus) {
		if(n < 0) return;
		if(n == 1 && (cntStar*2) == cntPlus) {
			count++;
			return;
		}
		
		if(maxThree*2 < cntPlus) return;
		
		if(n%3 == 0) {
			if((cntStar+1)*2 <= cntPlus)
				solve(n/3, cntStar+1, cntPlus);
			solve(n-3, cntStar, cntPlus+3);
		} else if(n%3 == 1) {
			solve(n-1, cntStar, cntPlus+1);
		} else if(n%3 == 2) {
			solve(n-2, cntStar, cntPlus+2);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int answer = solution(num);
		
		System.out.println(answer);
	}
}
