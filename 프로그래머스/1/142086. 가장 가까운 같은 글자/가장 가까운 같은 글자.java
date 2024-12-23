class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] temp=new int[26];
        for(int i=0; i<26; i++) temp[i]=-1;
        for(int i=0; i<s.length(); i++){
            if(temp[s.charAt(i)-'a']==-1){
                answer[i]=-1;
            }else{
                answer[i]=i-temp[s.charAt(i)-'a'];
            }
            temp[s.charAt(i)-'a']=i;
        }
        return answer;
    }
}