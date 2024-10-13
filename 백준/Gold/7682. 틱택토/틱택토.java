import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        while(true){
            String a=new StringTokenizer(br.readLine()).nextToken();
            boolean f1=false;
            boolean f2=false;
            if(a.equals("end")) break;
            //검증의 시간
            int Xcounter=0;
            int Ocounter=0;
            //첫번째 구역
            switch (a.charAt(0)){
                case 'O':
                    if(a.charAt(1)+a.charAt(2)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    if(a.charAt(3)+a.charAt(6)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    if(a.charAt(4)+a.charAt(8)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    break;
                case 'X':
                    if(a.charAt(1)+a.charAt(2)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    if(a.charAt(3)+a.charAt(6)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    if(a.charAt(4)+a.charAt(8)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    break;
                case '.':
                    break;
            }
            //세번째 구역
            switch (a.charAt(2)){
                case 'O':
                    if(a.charAt(4)+a.charAt(6)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    if(a.charAt(5)+a.charAt(8)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    break;
                case 'X':
                    if(a.charAt(4)+a.charAt(6)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    if(a.charAt(5)+a.charAt(8)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    break;
                case '.':
                    break;
            }
            //여덟번째 구역
            switch (a.charAt(7)){
                case 'O':
                    if(a.charAt(6)+a.charAt(8)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    if(a.charAt(1)+a.charAt(4)-'O'=='O'){
                        f1=true;
                        break;
                    }
                    break;
                case 'X':
                    if(a.charAt(6)+a.charAt(8)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    if(a.charAt(1)+a.charAt(4)-'X'=='X'){
                        f2=true;
                        break;
                    }
                    break;
                case '.':
                    break;
            }
            if(a.charAt(3)==a.charAt(4)&&a.charAt(4)==a.charAt(5)&&a.charAt(3)=='O') f1=true;
            if(a.charAt(3)==a.charAt(4)&&a.charAt(4)==a.charAt(5)&&a.charAt(3)=='X') f2=true;
            for(int i=0; i<9; i++){
                if(a.charAt(i)=='O')Ocounter++;
                if(a.charAt(i)=='X')Xcounter++;
            }
            if(f1 && f2){
                System.out.println("invalid");
                continue;
            }
            if(Xcounter-Ocounter==1) {
                if(f2){
                    System.out.println("valid");
                    continue;
                }
                if(Xcounter==5 && !f1){
                    System.out.println("valid");
                    continue;
                }
            }
            if(Xcounter-Ocounter==0 && f1) {
                System.out.println("valid");
                continue;
            }
            System.out.println("invalid");
        }
    }
}