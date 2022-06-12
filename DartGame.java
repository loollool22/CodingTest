import java.util.StringTokenizer;

public class DartGame {

	public static void main(String[] args) {
        
		Solution sol = new Solution();
		
		System.out.println(sol.solution("1D2S#10S"));
		sol.solution("1S*2T*3S");
	}

}

class Solution {
    public int solution(String dartResult) {
		
        int[] result = new int[3];
        
        
        // 숫자 토큰화
        StringTokenizer st = new StringTokenizer(dartResult, "SDT*#");
        String[] scoreStr = new String[st.countTokens()];
        int[] scoreInt = new int[st.countTokens()];
        
        int i = 0;
        
        while(st.hasMoreTokens()) {
        	scoreStr[i] = st.nextToken();
        	scoreInt[i] = Integer.parseInt(scoreStr[i]);
        	i++;
        }
        
//      for (i = 0; i < scoreStr.length; i++) {
//    		System.out.println(scoreStr[i]);
//   	}
        
        // 제곱수 토큰화
        StringTokenizer st2 = new StringTokenizer(dartResult, "0123456789");
        String[] squareNumber = new String[st2.countTokens()];
        
        i = 0;
        
        while(st2.hasMoreTokens()) {
        	squareNumber[i] = st2.nextToken();
        	i++;
        }
        
//      for (i = 0; i < squareNumber.length; i++) {
//      	System.out.println(squareNumber[i]);
//      }
        
        // 각 턴별 게임 점수
        for (i = 0; i < result.length; i++) {
        	
        	if (squareNumber[i].equals("S")) {	
            	result[i] = scoreInt[i];
            	
            } else if (squareNumber[i].equals("S#")){
            	result[i] = -(scoreInt[i]);
            	
            } else if (squareNumber[i].equals("S*")){
            	result[i] = scoreInt[i] * 2;
            	
            	if (i != 0){
            		result[i-1] *= 2;
            	}
            	
            } else if (squareNumber[i].equals("D")){
//            	result[i] = (int)Math.pow(scoreInt[i], 2);	// 제곱수 메서드는 double타입이 리턴됨.
            	result[i] = scoreInt[i] * scoreInt[i];
       
            } else if (squareNumber[i].equals("D#")){
               	result[i] = -(scoreInt[i] * scoreInt[i]);
               	
            } else if (squareNumber[i].equals("D*")){
            	result[i] = (scoreInt[i] * scoreInt[i]) * 2;
            	
            	if (i != 0){
            		result[i-1] *= 2;
            	}
 
            } else if (squareNumber[i].equals("T")){
            	result[i] = scoreInt[i] * scoreInt[i] * scoreInt[i];

            } else if (squareNumber[i].equals("T#")){
               	result[i] = -(scoreInt[i] * scoreInt[i] * scoreInt[i]);

            } else if (squareNumber[i].equals("T*")){
            	result[i] = (scoreInt[i] * scoreInt[i] * scoreInt[i]) * 2;
            	
            	if (i != 0){
            		result[i-1] *= 2;
            	}

            }
        }
        
        int answer = result[0] + result[1] + result[2];
                        
        return answer;
        
        
    }
}