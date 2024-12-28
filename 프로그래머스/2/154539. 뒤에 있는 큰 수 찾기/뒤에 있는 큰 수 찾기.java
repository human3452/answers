import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        pq.add(new int[]{0, numbers[0]});
        for(int i=1; i<numbers.length; i++){
            while(!pq.isEmpty() && pq.peek()[1]<numbers[i]){
                int[] temp=pq.poll();
                answer[temp[0]]=numbers[i];
            }
            pq.add(new int[]{i, numbers[i]});
        }
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            answer[temp[0]]=-1;
        }
        return answer;
    }
}