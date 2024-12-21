import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        boolean[] ski=new boolean[26];
        for(int i=0; i<skip.length(); i++){
            ski[skip.charAt(i)-'a']=true;
        }
        for(int i=0; i<s.length(); i++){
            int p=s.charAt(i)-'a';
            for(int j=0; j<index; j++){
                p++;
                if(p==26) p=0;
                if(ski[p]) j--;
            }
            sb.append((char)('a'+p));
        }
        return sb.toString();
    }
}