package divide_and_rule;

import java.util.Random;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�FindCoin   
* ������������100��Ӳ�ң����ö��ַ��������ַ����Ҽٱң�������֪�ٱ�����Ҫ��һЩ   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��23�� ����10:13:23   
* @version        
*/
public class FindCoin {
	public static int[] arr = new int[100];
	public static int flag;//��¼�ٱ�λ��
	public static int countBin = 0;//��¼���ַ����Ҵ���
	public static int countTri = 0;//��¼���ַ����Ҵ���
	
	//��ʼ��Ӳ������
	public static void initArr() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 2;
		}
		Random rd = new Random();
		/*ע����58���ĵ��ԣ�����ʹ����������ɼٱ�
		 * int flag=rd.nextInt(100);
		 * arr[flag]=1;
		 */
		arr[58] = 1;
		System.out.println("�ٱ�λ��:" + 58);
	}

	public static void disp() {
		for (int i = 0; i < arr.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/*��ȡ��lowλ�õ�highλ��Ӳ������֮�ͣ����ܵ������֣���Ϊʵ�ʲ�������Ϊ��ƽ�����߶���Ҫ��һ��������Ӳ��
	    ������Ϊ�˷�����󻯳���һ���򵥵���ͺ�������ʵ�������ֵ���ǲ����ܵ�֪��ֻ�������Ƚ���ƽ����Ӳ�ҵ���������*/
	public static int getWeight(int low, int high) {
		int count = 0;
		for (int i = low; i <= high; i++) {
			count += arr[i];
		}
		return count;
	}

	/*
	 * ���ֲ��Ҽٱң���Ӳ�Ҷ��ȷ֣����ܶ��һ��Ӳ�ң����ȷֵ�����Ӳ�ҳ��أ��ٱ��������һ�����������ٱ�Ϊ�����Ӳ��
	 * ����ɸѡĿ��������Ҽٱҿ��Եݹ��������Ĺ��̣�ֱ���ҳ��ٱ�
	 */
	public static void binSearch(int low, int high) {

		// ��ɸѡĿ�껹ʣż����ʱ
		if ((high - low) % 2 != 0) {
			if (getWeight(low, (low + high) / 2) < getWeight((low + high) / 2 + 1, high)) {
				countBin++;
				System.out.println(low + " " + (low + high) / 2);
				binSearch(low, (low + high) / 2);
			} else {
				countBin++;
				System.out.println((low + high) / 2 + 1 + " " + high);
				binSearch((low + high) / 2 + 1, high);
			}
		} else {// ��ɸѡĿ�껹ʣ������ʱ
			if (getWeight(low, (low + high - 1) / 2) < getWeight((low + high) / 2, high - 1)) {
				countBin++;
				System.out.println(low + " " + (low + high - 1) / 2);
				binSearch(low, (low + high - 1) / 2);
			} else if (getWeight(low, (low + high - 1) / 2) > getWeight((low + high) / 2, high - 1)) {
				countBin++;
				System.out.println((low + high) / 2 + " " + (high - 1));
				binSearch((low + high) / 2, high - 1);
			} else {
				
				countBin++;
				return;
			}
		}

	}

	//���ֲ��Ҽٱң�����ȷ�˼������
	public static void triSearch(int low, int high) {
		//ֻʣ����Ӳ�ң�ֱ�ӳƳ����
		if(low==high-1) {
			countTri++;
			return ;
		}
		int d = (high - low) / 3;//���ֺ�ǰ������ȵ�Ӳ�ҵ�����
		if (getWeight(low, low + d) < getWeight(low + d + 1, low + d + 1 + d)) {
			countTri++;
			System.out.println(low + " " + (low + d));
			triSearch(low, low + d);
		} else if (getWeight(low, low + d) > getWeight(low + d + 1, low + d + 1 + d)) {
			countTri++;
			System.out.println((low + d + 1) + " " + (low + d + 1 + d));
			triSearch(low + d + 1, low + d + 1 + d);
		} else {
			countTri++;
			System.out.println((low + d + 2 + d) + " " + high);
			triSearch(low + d + 2 + d, high);
		}
	}

	public static void main(String[] args) {
		FindCoin demo = new FindCoin();
		demo.initArr();
		//demo.binSearch(0, arr.length - 1);
		//System.out.println("���ַ����Ҵ���:" + countBin);
		demo.triSearch(0, arr.length - 1);
		System.out.println("���ַ����Ҵ���:" + countTri);
	}
}
