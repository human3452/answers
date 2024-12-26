import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                return number(o1[0])-number(o2[0]);
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<book_time.length; i++){
            int temp=number(book_time[i][0]);
            if(pq.isEmpty() || pq.peek()>temp){
                pq.add(number(book_time[i][1])+10);
                answer=Math.max(pq.size(), answer);
            }else{
                while(!pq.isEmpty() && pq.peek()<=temp){
                    pq.poll();
                }
                pq.add(number(book_time[i][1])+10);
            }
        }
        return answer;
    }
    public int number(String a){
        return Integer.parseInt(a.substring(0, 2))*60+Integer.parseInt(a.substring(3, 5));
    }
}