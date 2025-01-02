class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long pr=count*(count+1)/2;
        pr*=price;
        answer=Math.max(0, pr-(long)money);
        return answer;
    }
}