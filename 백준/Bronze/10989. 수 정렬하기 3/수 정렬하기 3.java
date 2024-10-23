import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int A= Integer.parseInt(br.readLine());
        int[] temp=new int[A];
        for(int i=0; i<A; i++) temp[i]= Integer.parseInt(br.readLine());
        Arrays.sort(temp);
        for(int i=0; i<A; i++) bw.write(temp[i]+"\n");

        bw.flush();
        bw.close();
    }
}