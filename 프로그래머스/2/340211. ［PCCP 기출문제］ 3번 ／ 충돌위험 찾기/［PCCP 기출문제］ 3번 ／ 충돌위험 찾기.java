import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] robot=new int[routes.length][2];
        int[] pointer=new int[robot.length];
        //시작할때 겹치는지 확인하기
        int[] temp=new int[101];
        for(int i=0; i<routes.length; i++){
            temp[routes[i][0]]++;
            if(temp[routes[i][0]]==2) answer++;
        }
        for(int i=0; i<routes.length; i++) {
            robot[i][0]=points[routes[i][0]-1][0];
            robot[i][1]=points[routes[i][0]-1][1];
            pointer[i]=1;
        }
        boolean flag=true;
        while(true){
            flag=false;
            for(int i=0; i<routes.length; i++){
                if(pointer[i]<routes[0].length){
                    if(robot[i][0]!=points[routes[i][pointer[i]]-1][0]){
                        flag=true;
                        if(robot[i][0]>points[routes[i][pointer[i]]-1][0]){
                            robot[i][0]--;
                        }else{
                            robot[i][0]++;
                        }
                    }else if(robot[i][1]!=points[routes[i][pointer[i]]-1][1]){
                        flag=true;
                        if(robot[i][1]>points[routes[i][pointer[i]]-1][1]){
                            robot[i][1]--;
                        }else{
                            robot[i][1]++;
                        }
                    }else{
                        pointer[i]++;
                        i--;
                    }
                }else{
                    robot[i][0]=-1;
                }
            }
            if(!flag) break;
            //이제 충돌 확인할 차례
            int[][] board=new int[101][101];
            for(int i=0; i<robot.length; i++){
                if(robot[i][0]==-1) continue;
                if(board[robot[i][0]][robot[i][1]]==1){
                    answer++;
                }
                board[robot[i][0]][robot[i][1]]++;
            }
        }
        return answer;
    }
}