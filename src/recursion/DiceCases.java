package recursion;

import java.util.Scanner;

public class DiceCases {
	//�ݹ�ʵ��
	public static int getKindsByRe(int n) {
		if(n<0)
			return 0;
		else if(n==0||n==1)
			return 1;
		else
			return getKindsByRe(n-6)+getKindsByRe(n-5)+getKindsByRe(n-4)+getKindsByRe(n-3)+getKindsByRe(n-2)+getKindsByRe(n-1);
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ��������:");
		int n=sc.nextInt();
		//int res=getKindsByRe(n);
		int res=getKindsByRe(n);
		System.out.println("�ߵ���"+n+"����"+res+"��Ͷ������");
	}
}
