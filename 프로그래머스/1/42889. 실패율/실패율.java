import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] peoples=new int[N+1];
        for(int i=0; i<stages.length; i++){
            peoples[stages[i]-1]++;
        }
        int[] purse=new int[N+1];
        purse[N]=peoples[N];
        for(int i=N; i>0; i--){
            purse[i-1]=purse[i]+peoples[i-1];
        }
        int[][] temp=new int[N][3];
        for(int i=0; i<N; i++){
            temp[i][0]=i;
            temp[i][1]=peoples[i];
            temp[i][2]=purse[i];
        }
        Arrays.sort(temp, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                long tsd=(long)o1[1]*(long)o2[2]-(long)o2[1]*(long)o1[2];
                if(tsd>0){
                    return -1;
                }else if(tsd==0){
                    return o1[0]-o2[0];
                }else{
                    return 1;
                }
            }
        });
        for(int i=0; i<N; i++){
            answer[i]=temp[i][0]+1;
        }
        return answer;
    }
}