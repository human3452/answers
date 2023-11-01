import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int divider=1000000009;
    static long[] temp=new long[1000001];
    public static void main(String[] args) throws IOException {
        temp[1]=1;
        temp[2]=2;
        temp[3]=4;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            System.out.println(dyn(Integer.parseInt(st.nextToken())));
        }
    }

    private static long dyn(int i) {
        if(temp[i]==0 && i>0){
            temp[i]=((long)(dyn(i-1)%divider+dyn(i-2)%divider+dyn(i-3)%divider)%divider);
        }
        return temp[i];
    }

}