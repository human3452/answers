class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i=0; i<numbers.length; i++){
            answer[i]++;
            long temp=numbers[i]^answer[i];
            answer[i]+=(temp >> 2);
        }
        return answer;
    }
}