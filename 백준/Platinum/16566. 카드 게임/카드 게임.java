import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        p=new int[M+1];
        for(int i=1; i<=M; i++) p[i]=i;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        st=new StringTokenizer(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<M; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        //카드 찾기
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int card= Integer.parseInt(st.nextToken());
            int start=0;
            int end=list.size()-1;
            if (card < list.get(0)) {
                bw.write(list.get(find(0))+"\n");
                union(0, find(0)+1);
            }else {
                while (start < end) {
                    int middle = (start + end) / 2;
                    if (list.get(middle) <= card) {
                        start = middle + 1;
                    } else {
                        end = middle;
                    }
                }
                bw.write(list.get(find(start))+"\n");
                union(start, find(start)+1);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int A){
        if(p[A]==A) return A;
        else{
            p[A]=find(p[A]);
            return find(p[A]);
        }
    }
    //A<B
    static void union(int A, int B){
        p[find(A)]=find(B);
    }
}
