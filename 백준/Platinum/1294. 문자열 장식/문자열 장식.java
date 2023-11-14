import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word{
        int pointer;
        char[] word;
        Word(char[] b){
            word=b;
            pointer=0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        PriorityQueue<Word> pq= new PriorityQueue<>(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int p1=o1.pointer;
                int p2=o2.pointer;
                while(true){
                    if(o1.word[p1]!=o2.word[p2]) return o1.word[p1]-o2.word[p2];
                    p1++;
                    p2++;
                    if(o2.word.length==p2){
                        return -1;
                    }
                    if(o1.word.length==p1){
                        return 1;
                    }
                }
            }
        });
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new Word(st.nextToken().toCharArray()));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Word temp=pq.poll();
            sb.append(temp.word[temp.pointer]);
            temp.pointer++;
            if(temp.pointer!=temp.word.length){
                pq.add(temp);
            }
        }
        System.out.println(sb.toString());
    }
}
