import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long x= Integer.parseInt(st.nextToken());
        long y= Integer.parseInt(st.nextToken());
        long straight= Integer.parseInt(st.nextToken());
        long diagonal= Integer.parseInt(st.nextToken());
        long answer=0;
        if(diagonal>=straight*2){
            answer=straight*(x+y);
        }else if(diagonal<straight){
            if(y>x){
                long temp=x;
                x=y;
                y=temp;
            }
            if((x+y)%2==0){
                answer=x*diagonal;
            }else{
                answer=(x-1)*diagonal+straight;
            }
        } else{
            if(y>x){
                long temp=x;
                x=y;
                y=temp;
            }
            long temp=x-y;
            answer=temp*straight+(x-temp)*diagonal;
        }
        System.out.println(answer);
    }
}
