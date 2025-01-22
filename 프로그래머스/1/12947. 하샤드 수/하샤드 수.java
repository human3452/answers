class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int ans=0;
        int num=x;
        while(num>=10){
            ans+=num%10;
            num/=10;
        }
        ans+=num;
        return x%ans==0;
    }
}