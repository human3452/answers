import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] point=new int[1000001];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int max=-1;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            max=Math.max(max, end);
            for(int j=start; j<end; j++){
                point[j]++;
            }
        }
        int start=0;
        int end=1;
        int sum=point[0];
        while(true){
            if(sum<K){
                if(end==max+1) {
                    System.out.println(0+" "+0);
                    break;
                }
                end++;
                sum+=point[end-1];
            }else if(sum>K){
                if(start>end) {
                    System.out.println(0+" "+0);
                    break;
                }
                sum-=point[start];
                start++;
            }else{
                System.out.println(start+" "+end);
                break;
            }
        }
    }
}