class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0]=x;
        long temp=x;
        for(int i=1; i<n; i++){
            temp+=x;
            answer[i]=temp;
        }
        return answer;
    }
}