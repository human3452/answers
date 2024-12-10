class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start=1;
        int end=100000;
        long time=0;
        while(start<=end){
            int proficit=(start+end)/2;
            time=times[0];
            for(int i=1; i<diffs.length; i++){
                if(proficit<diffs[i]){
                    time+=(times[i]+times[i-1])*(diffs[i]-proficit)+times[i];
                }else{
                    time+=times[i];
                }
            }
            if(time<limit){
                end=proficit-1;
            }else if(time>limit){
                start=proficit+1;
            }else{
                return proficit;
            }
        }
        return start;
    }
}