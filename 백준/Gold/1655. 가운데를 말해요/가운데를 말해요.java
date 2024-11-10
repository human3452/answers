import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lower=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        PriorityQueue<Integer> higher=new PriorityQueue<>();
        int middle= Integer.parseInt(br.readLine());
        bw.write(middle+"\n");
        for(int i=1; i<N; i++){
            int temp= Integer.parseInt(br.readLine());
            if(temp>=middle){
                higher.add(temp);
            }else{
                lower.add(temp);
            }
            if(higher.size()-lower.size()==2){
                lower.add(middle);
                middle=higher.poll();
            }
            if(lower.size()-higher.size()==1){
                higher.add(middle);
                middle=lower.poll();
            }
            bw.write(middle+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
