import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int counter=1;
        int N= Integer.parseInt(br.readLine());
        int number=666;
        while(counter<N){
            number++;
            String temp=String.valueOf(number);
            int cnt=0;
            for(int i=0; i<temp.length(); i++){
                if(temp.charAt(i)-'0'==6){
                    cnt++;
                }else{
                    cnt=0;
                }
                if(cnt==3){
                    counter++;
                    break;
                }
            }

        }
        System.out.println(number);
        bw.flush();
        bw.close();
        br.close();
    }
}