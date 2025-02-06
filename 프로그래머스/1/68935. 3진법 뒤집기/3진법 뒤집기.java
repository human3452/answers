import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb=new StringBuilder();
        while(n>=3){
            sb.append(n%3);
            n/=3;
        }
        sb.append(n);
        String temp=sb.toString();
        int pow=(int)Math.pow(3, temp.length()-1);
        for(int i=0; i<temp.length(); i++){
            answer+=pow*(temp.charAt(i)-'0');
            pow/=3;
        }
        return answer;
    }
}