import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list=new ArrayList<>();
        int first=arr[0];
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==first){
                continue;
            }else{
                list.add(arr[i]);
                first=arr[i];
            }
        }
        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        return answer;
    }
}