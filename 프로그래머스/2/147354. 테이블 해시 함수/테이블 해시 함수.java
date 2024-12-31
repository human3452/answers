import java.util.*;
class Solution {
    static int cole;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        cole=col-1;
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[cole]==o2[cole]){
                    return o2[0]-o1[0];
                }else{
                    return o1[cole]-o2[cole];
                }
            }
        });
        for(int i=0; i<data[0].length; i++){
            answer+=data[row_begin-1][i]%(row_begin);
        }
        for(int i=row_begin; i<row_end; i++){
            int temp=0;
            for(int j=0; j<data[0].length; j++){
                temp+=data[i][j]%(i+1);
            }
            answer=answer^temp;
        }
        return answer;
    }
}