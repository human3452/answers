import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static class tower implements Comparable<tower>{
        int height;
        int position;

        tower(int height, int position){
            this.height=height;
            this.position=position;
        }


        @Override
        public int compareTo(tower o) {
            return o.height-this.height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;

        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        st1=new StringTokenizer(br.readLine(), " ");
        PriorityQueue<tower> pq=new PriorityQueue<>();
        int[] laser= new int[N+1];
        for(int i=1; i<=N; i++){
            pq.add(new tower(Integer.parseInt(st1.nextToken()), i));
        }
        TreeMap<Integer, Integer> map=new TreeMap<>();
        while(!pq.isEmpty()){
            tower current=pq.poll();
            if(map.floorKey(current.position)!=null){
                laser[current.position]=map.floorKey(current.position);
            }
            map.put(current.position, 1);
        }
        for(int i=1; i<N; i++){
            System.out.print(laser[i]+" ");
        }
        System.out.print(laser[N]);
    }
}