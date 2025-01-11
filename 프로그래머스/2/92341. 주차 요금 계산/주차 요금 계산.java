import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> map=new HashMap<>();
        HashMap<Integer, Integer> price=new HashMap<>();
        int counter=0;
        for(int i=0; i<records.length; i++){
            int carNo=Integer.parseInt(records[i].substring(6,10));
            if(map.containsKey(carNo)){
                int time=minute(records[i])-map.get(carNo);
                if(price.containsKey(carNo)){
                    price.put(carNo, price.get(carNo)+time);
                }else{
                    price.put(carNo, time);
                }
                map.remove(carNo);
            }else{
                map.put(carNo, minute(records[i]));
            }
        }
        
        for(int carNo:map.keySet()){
            int time=1439-map.get(carNo);
            if(price.containsKey(carNo)){
                price.put(carNo, price.get(carNo)+time);
            }else{
                price.put(carNo, time);
            }
        }
        int[][] asd=new int[price.size()][2];
        for(int a:price.keySet()){
            int time=price.get(a);
            int cost=fees[1];
            if(time>fees[0]){
                time-=fees[0];
                cost+=fees[3]*(time/fees[2]);
                if(time%fees[2]!=0) cost+=fees[3];
            }
            asd[counter][0]=a;
            asd[counter][1]=cost;
            counter++;
        }
        Arrays.sort(asd, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        int[] answer=new int[price.size()];
        for(int i=0; i<answer.length; i++) answer[i]=asd[i][1];
        return answer;
    }
    public int minute(String temp){
        return Integer.parseInt(temp.substring(0,2))*60+Integer.parseInt(temp.substring(3,5));
    }
}