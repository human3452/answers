class Solution {
    public int[] solution(int[] sequence, int k) {
        int start=0, end=0;
        int result[]={0, sequence.length-1};
        long sum=sequence[0];
        while(end<sequence.length-1){
            if(k<sum){
                sum-=sequence[start];
                start++;
            }else if(k>sum){
                end++;
                sum+=sequence[end];
            }else{
                if(end-start<result[1]-result[0]){
                    result[1]=end;
                    result[0]=start;
                }
                end++;
                sum+=sequence[end];
            }
        }
        while(sum>k){
            sum-=sequence[start];
            start++;
        }
        if(sum==k){
            if(end-start<result[1]-result[0]){
                result[1]=end;
                result[0]=start;
            }
        }
        return result;
    }
}