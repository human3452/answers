import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans, new Comparator<String[]>(){
           public int compare(String[] o1, String[] o2){
               return minute(o1[1])-minute(o2[1]);
           }
        });
        for(int i=0; i<plans.length; i++) plans[i][1]=Integer.toString(minute(plans[i][1]));
        int pointer=0;
        int cnt=0;
        Stack<int[]> stack=new Stack<>();
        int currentTime=Integer.parseInt(plans[pointer][1]);
        while(pointer<plans.length-1){
            int availTime=Integer.parseInt(plans[pointer+1][1])-currentTime;
            if(availTime>Integer.parseInt(plans[pointer][2])){
                answer[cnt++]=plans[pointer][0];
                currentTime+=Integer.parseInt(plans[pointer][2]);
                while(!stack.isEmpty()){
                    if(currentTime+stack.peek()[1]<=Integer.parseInt(plans[pointer+1][1])){
                        currentTime+=stack.peek()[1];
                        answer[cnt++]=plans[stack.pop()[0]][0];
                    }else{
                        int[] temp=stack.pop();
                        temp[1]=currentTime+temp[1]-Integer.parseInt(plans[pointer+1][1]);
                        stack.add(temp);
                        break;
                    }
                }
                currentTime=Integer.parseInt(plans[pointer+1][1]);
                pointer++;
            }else if(availTime == Integer.parseInt(plans[pointer][2])){
                answer[cnt++]=plans[pointer][0];
                currentTime=Integer.parseInt(plans[pointer+1][1]);
                pointer++;
            }else{
                currentTime=Integer.parseInt(plans[pointer+1][1]);
                stack.add(new int[] {pointer, Integer.parseInt(plans[pointer][2])-availTime});
                pointer++;
            }
        }
        answer[cnt++]=plans[plans.length-1][0];
        while(!stack.isEmpty()) answer[cnt++]=plans[stack.pop()[0]][0];
        return answer;
    }
    public int minute(String time){
        return Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3,5));
    }
}