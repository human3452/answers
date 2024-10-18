import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        String Text=br.readLine();
        int first=1;
        int last=1;
        int red=0;
        int blue=0;
        int[] longest=new int[2];
        boolean flag=true;
        char f=Text.charAt(0);
        char l=Text.charAt(N-1);
        if(Text.charAt(0)=='B') blue++;
        else red++;
        for(int i=1; i<N; i++){
            if(Text.charAt(i)==Text.charAt(i-1) && flag){
                first++;
            }else{
                flag=false;
            }
            if(Text.charAt(i)=='B') blue++;
            else red++;
        }
        if(first==N){
            System.out.print(0);
            System.exit(0);
        }
        for(int i=N-1; i>=0; i--){
            if(Text.charAt(i)==Text.charAt(i-1)){
                last++;
            }else break;
        }
        int answer=0;
        if(f=='B'){
            if(l=='B'){
                answer=Math.min(red, blue-last);
                answer=Math.min(answer, blue-first);
            }else{
                answer=Math.min(blue-first, red-last);
            }
        }else{
            if(l=='B'){
                answer=Math.min(red-first, blue-last);
            }else{
                answer=Math.min(blue, red-last);
                answer=Math.min(answer, red-first);
            }
        }
        System.out.print(answer);
    }
}