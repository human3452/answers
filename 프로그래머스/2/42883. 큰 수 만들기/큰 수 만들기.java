import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb=new StringBuilder();
        int pointer=0;
        for(int i=0; i<number.length()-k; i++){
            int temp=0;
            int p=number.length()-k;
            for(int j=pointer; j<=number.length()-(p-i); j++){
                if(number.charAt(j)-'0'>temp){
                    temp=Math.max(temp, number.charAt(j)-'0');
                    pointer=j+1;
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}