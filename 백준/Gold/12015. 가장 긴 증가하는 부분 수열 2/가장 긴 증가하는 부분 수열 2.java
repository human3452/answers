import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        int[] array=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) array[i]= Integer.parseInt(st.nextToken());
        int[] record=new int[N];
        ArrayList<Integer> test=new ArrayList<>();
        int pointer=0;
        test.add(array[0]);
        record[0]=0;
        outer:for(int i=1; i<N; i++){
            if(array[i]<=test.get(0)){
                record[i]=0;
                test.set(0, array[i]);
            }else if(array[i]>=test.get(pointer)){
                if(array[i]==test.get(pointer)){
                    record[i]=pointer;
                }else {
                    pointer++;
                    test.add(array[i]);
                    record[i] = pointer;
                }
            }else{
                int start=0;
                int end=pointer;
                while(start<end){
                    int middle=(start+end)/2;
                    if(test.get(middle)==array[i]){
                        test.set(middle, array[i]);
                        record[i]=middle;
                        continue outer;
                    }
                    if((test.get(middle)<array[i] && test.get(middle+1)>array[i])){
                        test.set(middle+1, array[i]);
                        record[i]=middle+1;
                        continue outer;
                    }
                    if(test.get(middle)<array[i]){
                        start=middle+1;
                    }else{
                        end=middle-1;
                    }
                }
                if(test.get(start)==array[i]){
                    record[i]=start;
                }else {
                    record[i] = start + 1;
                    test.set(start + 1, array[i]);
                }
            }
        }
        bw.write(test.size()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}