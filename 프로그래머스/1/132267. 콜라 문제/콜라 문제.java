class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            answer+=(n/a)*b;
            int c=n/a;
            n-=c*a;
            n+=c*b;
        }
        return answer;
    }
}