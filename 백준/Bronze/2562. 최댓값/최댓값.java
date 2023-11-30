import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int max=0;
        int pointer=0;
        for(int i=1; i<=9; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int temp=Integer.parseInt(st.nextToken());
            if(max< temp){
                max=temp;
                pointer=i;
            }
        }
        System.out.println(max);
        System.out.println(pointer);
    }
}
