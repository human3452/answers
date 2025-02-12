class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        outer:for(int i=0; i<schedules.length; i++){
            int convertedS=calc(schedules[i]);
            for(int j=0; j<7; j++){
                if((j+startday)%7>=1 && (j+startday)%7<=5){
                    int convertedF=calc(timelogs[i][j]);
                    if(convertedS>=1430){
                        if(convertedF<convertedS && convertedS%10>convertedF) continue outer;
                    }else{
                        if(convertedF-convertedS>10) continue outer;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    public int calc(int a){
        return (a/100)*60+(a%100);
    }
}