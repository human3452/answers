import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<M; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int answer=0;
        int pointer=0;
        int temp=Math.min(M,N);
        for(int i=1; i<=temp; i++){
            if(answer<=list.get(M-i)*i){
                answer=list.get(M-i)*i;
                pointer=list.get(M-i);
            }
        }
        System.out.println(pointer+" "+answer);
    }
}
