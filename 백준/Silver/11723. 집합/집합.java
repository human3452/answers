import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int M= Integer.parseInt(br.readLine());
        boolean[] set=new boolean[21];
        for(int i=0; i<M; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "add":
                    set[Integer.parseInt(st.nextToken())]=true;
                    break;
                case "check":
                    if(set[Integer.parseInt(st.nextToken())]) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case "remove":
                    set[Integer.parseInt(st.nextToken())]=false;
                    break;
                case "toggle":
                    int sd=Integer.parseInt(st.nextToken());
                    set[sd]=!set[sd];
                    break;
                case "all":
                    for(int j=1; j<=20; j++) set[j]=true;
                    break;
                case "empty":
                    set=new boolean[21];
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}