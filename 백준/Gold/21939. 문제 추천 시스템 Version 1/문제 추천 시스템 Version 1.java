import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class problem{
        int number, difficulty;
        problem(int number, int difficulty){
            this.difficulty=difficulty;
            this.number=number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<problem> maxheap=new PriorityQueue<>(new Comparator<problem>() {
            @Override
            public int compare(problem o1, problem o2) {
                if(o1.difficulty==o2.difficulty){
                    return o2.number-o1.number;
                }else return o2.difficulty-o1.difficulty;
            }
        });
        PriorityQueue<problem> minheap=new PriorityQueue<>(new Comparator<problem>() {
            @Override
            public int compare(problem o1, problem o2) {
                if(o1.difficulty==o2.difficulty){
                    return o1.number-o2.number;
                }else return o1.difficulty-o2.difficulty;
            }
        });
        Map<Integer, Integer> map=new HashMap<>();
        int N= Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int number=Integer.parseInt(st.nextToken());
            int difficulty=Integer.parseInt(st.nextToken());
            minheap.add(new problem(number, difficulty));
            maxheap.add(new problem(number, difficulty));
            map.put(number, difficulty);
        }
        st=new StringTokenizer(br.readLine());
        int C=Integer.parseInt(st.nextToken());
        for(int i=0; i<C; i++){
            st=new StringTokenizer(br.readLine());
            switch (st.nextToken().charAt(0)){
                case 'a':
                    int number=Integer.parseInt(st.nextToken());
                    int difficulty=Integer.parseInt(st.nextToken());
                    minheap.add(new problem(number, difficulty));
                    maxheap.add(new problem(number, difficulty));
                    map.put(number, difficulty);
                    break;
                case 's':
                    int num=Integer.parseInt(st.nextToken());
                    map.put(num, -1);
                    break;
                case 'r':
                    if(Integer.parseInt(st.nextToken())==-1){
                        while(true){
                            problem p=minheap.poll();
                            if(map.get(p.number)!=p.difficulty) continue;
                            System.out.println(p.number);
                            minheap.add(p);
                            break;
                        }
                    }else{
                        while (true) {
                            problem p = maxheap.poll();
                            if(map.get(p.number)!=p.difficulty) continue;
                            System.out.println(p.number);
                            maxheap.add(p);
                            break;
                        }
                    }
                    break;
            }
        }
    }

}
