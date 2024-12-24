class Solution {
    public int solution(String s) {
        int answer = 0;
        int[] temp={0, 0};
        boolean f=true;
        char temp2='0';
        for(int i=0; i<s.length(); i++){
            if(f){
                f=false;
                temp[1]++;
                temp2=s.charAt(i);
            }else{
                if(temp2==s.charAt(i)) temp[1]++;
                else temp[0]++;
                if(temp[0]==temp[1]){
                    f=true;
                    answer++;
                }
            }
        }
        if(temp[0]!=temp[1]) answer++;
        return answer;
    }
}