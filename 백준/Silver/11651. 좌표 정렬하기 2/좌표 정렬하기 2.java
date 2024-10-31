import java.io.*;
import java.util.*;

public class Main {
    static class coordinate implements Comparable<coordinate> {
        int x;
        int y;


        coordinate(int A, int B){
            x=A;
            y=B;
        }

        @Override
        public int compareTo(coordinate o) {
            if(this.y==o.y){
                return this.x-o.x;
            }else
                return this.y-o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        PriorityQueue<coordinate> pq=new PriorityQueue<>();
        for(int i=0; i<A; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while(!pq.isEmpty()){
            coordinate temp=pq.poll();
            bw.write(temp.x+" "+temp.y+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}