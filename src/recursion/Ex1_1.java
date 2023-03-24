package recursion;
import java.util.Random;
public class Ex1_1 {
	//初始化数组
	public static void initArr(int[] arr) {
		Random rd=new Random();
		//int x=rd.nextInt(20)+1;
		for(int i=0;i<arr.length;i++) {
			arr[i]=rd.nextInt(20)+1;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//利用传统的比较方法得到最大与最小值并返回比较次数，次数固定
	public static void getMax_Min(int[] arr) {
		int count=0;
		int max=arr[0];
		int min=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>=max) {
				max=arr[i];
			}
			count++;
			if(arr[i]<=min) {
				min=arr[i];
			}
			count++;
		}
		System.out.println("MAX :"+max);
		System.out.println("MIN :"+min);
		System.out.println("比较次数 :"+count);
		//return count;
	}
	//利用递归的比较方法   
	/*
		public static void getMax_MinByRe(int[] arr,int low,int mid,int high) {
			int count=0;
			if(mid-low<=1&&high-mid<=1) {
				arr
			}
			else {
				getMax_MinByRe(arr,low,(low+mid-1)/2,mid-1);
			}
			if(high-mid<=1)
				;
			else {
				getMax_MinByRe(arr,mid+1,(mid+1+high)/2,high);
			}
			System.out.println("比较次数 :"+count);
			//return count;
		}
		*/
	public static void main(String[] args) {
		int[] arr=new int[10];
		initArr(arr);
		getMax_Min(arr);
	}
}
