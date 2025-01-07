import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        int tmp=1;
        int digit=1;
        while(true){
            if(tmp*3<n){
                digit++;
                tmp*=3;
                n-=tmp;
            }else break;
        }
        //이제 N번째 찾기(3진법)
        n--;
        while(n>=3){
            switch(n%3){
                case 0:
                    sb.append(1);
                    break;
                case 1:
                    sb.append(2);
                    break;
                case 2:
                    sb.append(4);
                    break;
            }
            n/=3;
            digit--;
        }
        switch(n){
            case 0:
                sb.append(1);
                break;
            case 1:
                sb.append(2);
                break;
            case 2:
                sb.append(4);
                break;
        }
        digit--;
        while(digit>0){
            sb.append(1);
            digit--;
        }
        return sb.reverse().toString();
    }
}