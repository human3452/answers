import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited=new boolean[cards.length];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<cards.length; i++){
            if(!visited[i]){
                visited[i]=true;
                int count=1;
                int pointer=i;
                while(cards[pointer]-1!=i){
                    count++;
                    pointer=cards[pointer]-1;
                    visited[pointer]=true;
                }
                list.add(count);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        if(list.size()==1){
            return 0;
        }
        return list.get(0)*list.get(1);
    }
}