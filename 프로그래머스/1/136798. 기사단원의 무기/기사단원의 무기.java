class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int temp=0;
            int sqrt=(int)Math.sqrt(i);
            for(int j=1; j<=sqrt; j++){
                if(i%j==0) temp+=2;
            }
            if(sqrt*sqrt==i) temp--;
            if(temp>limit) answer+=power;
            else answer+=temp;
        }
        return answer;
    }
}