class Solution {
    boolean solution(String s) {
        int answer=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='p' || s.charAt(i)=='P') answer++;
            else if(s.charAt(i)=='y' || s.charAt(i)=='Y') answer--;
        }

        return answer==0;
    }
}