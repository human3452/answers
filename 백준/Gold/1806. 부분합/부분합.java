import java.io.*;
import java.util.*;

public class Main {
    static class node{

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] nums=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i]= Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=0;
        int sum=nums[start];
        int min=Integer.MAX_VALUE;
        while(true){
            if(sum<M){
                if(N-1==end) break;
                end++;
                sum+=nums[end];
            }else{
                sum-=nums[start];
                min=Math.min(min, end-start+1);
                start++;
            }
        }
        if(min==Integer.MAX_VALUE) min=0;
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }
}