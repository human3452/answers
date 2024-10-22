import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num=i;
            int temp=i;
            while(temp>10){
                num+=temp%10;
                temp/=10;
            }
            num+=temp;
            if(N==num){
                System.out.print(i);
                System.exit(0);
            }
        }
        System.out.print(0);
    }
}