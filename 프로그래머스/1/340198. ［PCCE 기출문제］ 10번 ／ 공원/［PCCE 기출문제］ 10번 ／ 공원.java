import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int min=-1;
        Arrays.sort(mats);
        for(int i=0; i<park.length; i++){
            outer:for(int j=0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    for(int k=min+1; k<mats.length; k++){
                        for(int i2=i; i2<i+mats[k]; i2++){
                            for(int j2=j; j2<j+mats[k]; j2++){
                                if(i2>=park.length || j2>=park[0].length || !park[i2][j2].equals("-1")){
                                    continue outer;
                                }
                            }
                        }
                        min=k;
                    }
                    
                }
            }
        }
        if(min==-1) return min;
        return mats[min];
    }
}