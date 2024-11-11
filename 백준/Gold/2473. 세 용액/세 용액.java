import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;
    static long max= Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        outer:for(int i=0; i<N-2; i++){
            int start=i+1;
            int end=N-1;
            while(start<end){
                long ax= (long)list.get(i) + (long)list.get(end) + (long)list.get(start);
                if(Math.abs(ax)<max){
                    answer= new int[]{list.get(i), list.get(start), list.get(end)};
                    max=Math.abs(ax);
                }
                if(ax>0){
                    end--;
                }else if(ax<0){
                    start++;
                }else{
                    break outer;
                }
            }
        }
        bw.write(answer[0]+" ");
        bw.write(answer[1]+" ");
        bw.write(answer[2]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
