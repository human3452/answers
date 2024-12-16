import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int pointer=0;
        while(pointer<targets.length){
            if(pq.isEmpty() || targets[pointer][0]<pq.peek()){
                pq.add(targets[pointer][1]);
                pointer++;
            }else{
                answer++;
                pq.clear();
            }
        }
        pq.clear();
        answer++;
        return answer;
    }
}