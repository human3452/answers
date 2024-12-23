import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        // map=어디로 가는가?
        // map2=들어가는 간선수!
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        HashMap<Integer, Integer> map2=new HashMap<>();
        int[] answer=new int[4];
        for(int i=0; i<edges.length; i++){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }
            if(!map2.containsKey(edges[i][1])){
                map2.put(edges[i][1], 0);
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map2.put(edges[i][1], map2.get(edges[i][1])+1);
        }
        int Head=-1;
        for(int a:map.keySet()){
            if(!map2.containsKey(a) && map.get(a).size()>=2){
                Head=a;
                break;
            }
        }
        answer[0]=Head;
        outer:for(int start:map.get(Head)){
            int point=start;
            if(!map.containsKey(point)){
                answer[2]++;
                continue outer;
            }
            if(map.get(point).size()==2){
                answer[3]++;
                continue outer;
            }
            point=map.get(point).get(0);
            while(true){
                if(!map.containsKey(point)){
                answer[2]++;
                continue outer;
                }
                if(map.get(point).size()==2){
                    answer[3]++;
                    continue outer;
                }
                if(start==point){
                    answer[1]++;
                    continue outer;
                }
                point=map.get(point).get(0);
            }
        }
        return answer;
    }
}