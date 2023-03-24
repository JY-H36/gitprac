package divide_and_rule;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�FindMul   
* ����������һ���������У��Ե���Ϊ�����в��������������Ƕ�������Լ�û�����������  
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��23�� ����9:14:21   
* @version        
*/
public class FindMul {
	//�洢��������
	public static int[] arr=new int[] {1,1,3,4,5};
	public static int value;//����ֵ
	public static int occ=0;//�������ִ���������
	public static void disp() {
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int getMax(int a,int b,int c) {
		int max=a;
		if(b>=max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;
	}
	
	/*
	 * ����˼·�����������зֳ�3�����֣���λ������λ����ߵ������Լ���λ���ұߵ�����
	 * 1�������λ�����ֵĴ����������λ���Ĵ����Ѿ��㹻��ͬʱ���ڵ����������ߵ����г��ȣ�������λ����������
	 * 2�����λ���Ĵ���������ʱ�������������������е�����������λ���ĳ��ִ�����Ƚϣ���ʵ�Ͽ���ֻ��Ҫ�Ƚ�ĳһ�����е��������Ӿ������������
	 * ����Ϊ�⼸�ߵ��г��ִ�������
	 * ��ĳ�����������ֿ��Եݹ�ص���1 2�Ĺ���
	 */
	public static int getMul(int low,int high) {
		int mid=(low+high)/2;
		int count;
		int left=0,right=0;
		for(int i=mid;i>=low;i--) {
			left=low;
			if(arr[i]!=arr[mid]) {
				left=i;
				break;
			}
		}
		System.out.println("��:"+left);
		for(int i=mid;i<=high;i++) {
			right=high;
			if(arr[i]!=arr[mid]) {
				right=i;
				break;
			}
		}
		System.out.println("��:"+right);
		count=right-left-1;//��λ��������
		if(arr[left]==arr[mid]) {
			count++;
		}
		if(arr[right]==arr[mid]) {
			count++;
		}
		if(count>=(left-low+1)&&count>=(high-right+1)) {
			//ֻ�г��ִ�������ǰ��������������Ÿ�������
			if(count>occ) {
				occ=count;
				value=arr[mid];
			}
			return count;
		}else if(count<(left-low+1)&&count<(high-right+1)) {		//��������ͬʱС�������������еĳ���
			return getMax(getMul(low,left),count,getMul(right,high));
		}
		else if(count<(left-low+1)) {//��������С��������г���
			return getMul(low,left)>count? getMul(low,left):count;
		}else {//��������С���ұ����г���
			return getMul(right,high)>count? getMul(right,high):count;
		}
	}
	
	
	public static void main(String[] args) {
		FindMul demo=new FindMul();
		demo.disp();
		demo.getMul(0, arr.length-1);
		System.out.println("����:"+value);
		System.out.println("����:"+occ);
	}
}
