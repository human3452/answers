class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long tmp=((long)a+(long)b)*(Math.abs(b-a)+1)/2;
        return tmp;
    }
}