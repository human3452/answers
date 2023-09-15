import java.util.*;

class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text=sc.nextLine();
        int start=0;
        int end=0;
        boolean flag=false;
        int temp=0;
        int answer=0;
        for(int i=0; i<text.length(); i++){
            char A=text.charAt(i);
            if((A-'0')<10 && (A-'0')>=0){
                temp*=10;
                temp+=(A-'0');
            }else if(A=='-'){
                if(!flag){
                    answer+=temp;
                    temp=0;
                    flag=true;
                }else {
                    flag = true;
                    answer -= temp;
                    temp = 0;
                }
            }else{
                if(flag){
                    answer-=temp;
                    temp=0;
                }else{
                    answer+=temp;
                    temp=0;
                }
            }
        }
        if(flag){
            answer-=temp;
        }else{
            answer+=temp;
        }
        System.out.println(answer);
    }
}
