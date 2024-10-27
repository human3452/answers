import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(br.readLine());
        int twos=0;
        int fives=0;
        for(int i=1; i<=a; i++){
            int temp=i;
            while(temp%2==0){
                temp/=2;
                twos++;
            }
            while(temp%5==0){
                temp/=5;
                fives++;
            }
        }
        System.out.println(Math.min(twos, fives));
    }

}