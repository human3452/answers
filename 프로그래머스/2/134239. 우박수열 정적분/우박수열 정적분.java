import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> list=new ArrayList<>();
        int pointer=0;
        while(k!=1){
            int tmp=k;
            if(k%2==0){
                k/=2;
            }else{
               k=k*3+1; 
            }
            double area=((double)k+(double)tmp)/2.0;
            if(list.isEmpty()) list.add(area);
            else list.add(list.get(list.size()-1)+area);
        }
        for(int i=0; i<ranges.length; i++){
            int to=list.size()+ranges[i][1];
            if(to==0){
                if(ranges[i][0]!=0) answer[i]=-1;
                else answer[i]=0;
                continue;
            }
            if(to<ranges[i][0]) answer[i]=-1;
            else {
                if(ranges[i][0]==0){
                    answer[i]=list.get(to-1);
                }else answer[i]=list.get(to-1)-list.get(ranges[i][0]-1);
            }
        }
        
        return answer;
    }
}