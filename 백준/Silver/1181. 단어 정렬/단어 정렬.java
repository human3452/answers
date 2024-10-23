import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A= Integer.parseInt(br.readLine());
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)!=o2.charAt(i)) return o1.charAt(i)-o2.charAt(i);
                    }
                    return 0;
                }else return o1.length()-o2.length();
            }
        });
        for(int i=0; i<A; i++){
            pq.add(br.readLine());
        }
        String first=pq.poll();
        System.out.println(first);
        while(!pq.isEmpty()){
            String temp=pq.poll();
            if(temp.equals(first)) continue;
            System.out.println(temp);
            first=temp;
        }
    }
}