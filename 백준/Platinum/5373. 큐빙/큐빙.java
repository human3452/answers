import java.util.Scanner;

public class Main {
	static char[][] Up= {{'w', 'w', 'w'},{'w', 'w', 'w'},{'w', 'w', 'w'}};
	static char[][] Down={{'y', 'y', 'y'},{'y', 'y', 'y'},{'y', 'y', 'y'}};
	static char[][] Left={{'g', 'g', 'g'},{'g', 'g', 'g'},{'g', 'g', 'g'}};
	static char[][] Right={{'b', 'b', 'b'},{'b', 'b', 'b'},{'b', 'b', 'b'}};
	static char[][] Front={{'r', 'r', 'r'},{'r', 'r', 'r'},{'r', 'r', 'r'}};
	static char[][] Back={{'o', 'o', 'o'},{'o', 'o', 'o'},{'o', 'o', 'o'}};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int tc=0; tc<N; tc++) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					Up[i][j]='w';
					Down[i][j]='y';
					Left[i][j]='g';
					Right[i][j]='b';
					Front[i][j]='r';
					Back[i][j]='o';
				}
			}
			int dummy=sc.nextInt();
			for(int sf=1; sf<=dummy; sf++) {
			String input=sc.next();
			char a=input.charAt(0);
			char b=input.charAt(1);
			switch(a) {
			case 'U':
				if(b=='-') {
					Up=spina(Up, 1);
					spinb(1);
				}else {
					Up=spina(Up, 2);
					spinb(2);
				}
				break;
			case 'D':
				if(b=='-') {
					Down=spina(Down, 1);
					spinb(3);
				}else {
					Down=spina(Down, 2);
					spinb(4);
				}
				break;
			case 'L':
				if(b=='-') {
					Left=spina(Left, 1);
					spinb(5);
				}else {
					Left=spina(Left, 2);
					spinb(6);
				}
				break;
			case 'R':
				if(b=='-') {
					Right=spina(Right, 1);
					spinb(7);
				}else {
					Right=spina(Right, 2);
					spinb(8);
				}
				break;
			case 'F':
				if(b=='-') {
					Front=spina(Front, 1);
					spinb(9);
				}else {
					Front=spina(Front, 2);
					spinb(10);
				}
				break;
			case 'B':
				if(b=='-') {
					Back=spina(Back, 1);
					spinb(11);
				}else {
					Back=spina(Back, 2);
					spinb(12);
				}
				break;
			}
			}
		
		//출력부
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(Up[i][j]);
			}
			System.out.println();
		}
		}
	}
	static char[][] spina(char[][] a, int b) {
		char alpha=a[0][0];
		char beta=a[0][1];
		if(b==2) {
			a[0][0]=a[2][0];
			a[0][1]=a[1][0];
			a[2][0]=a[2][2];
			a[1][0]=a[2][1];
			a[2][2]=a[0][2];
			a[2][1]=a[1][2];
			a[0][2]=alpha;
			a[1][2]=beta;
		}else {
			a[0][0]=a[0][2];
			a[0][1]=a[1][2];
			a[0][2]=a[2][2];
			a[1][2]=a[2][1];
			a[2][2]=a[2][0];
			a[2][1]=a[1][0];
			a[2][0]=alpha;
			a[1][0]=beta;
		}
		return a;
	}
	static void spinb(int a){
		switch(a) {
		case 1:
			char[] temp=Left[0].clone();
			Left[0]=Back[0].clone();
			Back[0]=Right[0].clone();
			Right[0]=Front[0].clone();
			Front[0]=temp.clone();
			break;
		case 2:
			temp=Left[0].clone();
			Left[0]=Front[0].clone();
			Front[0]=Right[0].clone();
			Right[0]=Back[0].clone();
			Back[0]=temp.clone();
			break;
		case 3:
			temp=Left[2].clone();
			Left[2]=Front[2].clone();
			Front[2]=Right[2].clone();
			Right[2]=Back[2].clone();
			Back[2]=temp.clone();
			break;
		case 4:
			temp=Left[2].clone();
			Left[2]=Back[2].clone();
			Back[2]=Right[2].clone();
			Right[2]=Front[2].clone();
			Front[2]=temp.clone();
			break;
		case 5:
			temp=new char[3];
			for(int i=0; i<3; i++) {
				temp[i]=Up[i][0];
			}
			for(int i=0; i<3; i++) {
				Up[i][0]=Front[i][0];
			}
			for(int i=0; i<3; i++) {
				Front[i][0]=Down[i][0];
			}
			for(int i=0; i<3; i++) {
				Down[i][0]=Back[2-i][2];
			}
			for(int i=0; i<3; i++) {
				Back[2-i][2]=temp[i];
			}
			break;
		case 6:
			temp=new char[3];
			for(int i=0; i<3; i++) {
				temp[i]=Up[i][0];
			}
			for(int i=0; i<3; i++) {
				Up[i][0]=Back[2-i][2];
			}
			for(int i=0; i<3; i++) {
				Back[2-i][2]=Down[i][0];
			}
			for(int i=0; i<3; i++) {
				Down[i][0]=Front[i][0];
			}
			for(int i=0; i<3; i++) {
				Front[i][0]=temp[i];
			}
			break;
		case 7:
			temp=new char[3];
			for(int i=0; i<3; i++) {
				temp[i]=Up[i][2];
			}
			for(int i=0; i<3; i++) {
				Up[i][2]=Back[2-i][0];
			}
			for(int i=0; i<3; i++) {
				Back[2-i][0]=Down[i][2];
			}
			for(int i=0; i<3; i++) {
				Down[i][2]=Front[i][2];
			}
			for(int i=0; i<3; i++) {
				Front[i][2]=temp[i];
			}
			break;
		case 8:
			temp=new char[3];
			for(int i=0; i<3; i++) {
				temp[i]=Up[i][2];
			}
			for(int i=0; i<3; i++) {
				Up[i][2]=Front[i][2];
			}
			for(int i=0; i<3; i++) {
				Front[i][2]=Down[i][2];
			}
			for(int i=0; i<3; i++) {
				Down[i][2]=Back[2-i][0];
			}
			for(int i=0; i<3; i++) {
				Back[2-i][0]=temp[i];
			}
			break;
		case 9:
			temp=Up[2].clone();
			for(int i=0; i<3; i++) {
				Up[2][i]=Right[i][0];
			}
			for(int i=0; i<3; i++) {
				Right[i][0]=Down[0][2-i];
			}
			for(int i=0; i<3; i++) {
				Down[0][i]=Left[i][2];
			}
			for(int i=0; i<3; i++) {
				Left[2-i][2]=temp[i];
			}
			break;
		case 10:
			temp=Up[2].clone();
			for(int i=0; i<3; i++) {
				Up[2][i]=Left[2-i][2];
			}
			for(int i=0; i<3; i++) {
				Left[i][2]=Down[0][i];
			}
			for(int i=0; i<3; i++) {
				Down[0][2-i]=Right[i][0];
			}
			for(int i=0; i<3; i++) {
				Right[i][0]=temp[i];
			}
			break;
		case 11:
			temp=Up[0].clone();
			for(int i=0; i<3; i++) {
				Up[0][i]=Left[2-i][0];
			}
			for(int i=0; i<3; i++) {
				Left[i][0]=Down[2][i];
			}
			for(int i=0; i<3; i++) {
				Down[2][2-i]=Right[i][2];
			}
			for(int i=0; i<3; i++) {
				Right[i][2]=temp[i];
			}
			break;
		case 12:
			temp=Up[0].clone();
			for(int i=0; i<3; i++) {
				Up[0][i]=Right[i][2];
			}
			for(int i=0; i<3; i++) {
				Right[i][2]=Down[2][2-i];
			}
			for(int i=0; i<3; i++) {
				Down[2][i]=Left[i][0];
			}
			for(int i=0; i<3; i++) {
				Left[2-i][0]=temp[i];
			}
			break;
		}
	}
}