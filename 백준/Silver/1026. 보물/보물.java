import java.util.*;

class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        PriorityQueue<Integer> pq2=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int N= sc.nextInt();
        int answer=0;
        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }
        for(int i=0; i<N; i++){
            pq2.add(sc.nextInt());
        }
        for(int i=0; i<N; i++){
            answer+=pq.poll()*pq2.poll();
        }
        System.out.println(answer);
    }
}