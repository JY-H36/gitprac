/**
 * 
 */
package violence;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�BackPack01   
* ��������   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��26�� ����8:55:33   
* @version        
*/

import java.util.ArrayList;

public class Backpack01 {
	public static ArrayList<ArrayList<Object>> setarr(int n) {// ��ȡ���е����
		ArrayList<ArrayList<Object>> arr = new ArrayList<>();
		//ArrayList<ArrayList<Object>> arr1 = new ArrayList<>();
		ArrayList<Object> s = new ArrayList<Object>();
		arr.add(null);// ��0Ϊ�ռ��ϣ���ӿռ���
		for (int i = 1; i <= n; i++) {
			ArrayList<ArrayList<Object>> arr1 = new ArrayList<>(arr);//����ֱ�ӵȺ� ��ָ��ͬһ����ַ
			int len = arr1.size();
			for (int it = 0; it < len; it++) {
				if (arr1.get(it) == null) {
					ArrayList<Object> s1 = new ArrayList<Object>();
					s1.add(i);
					arr1.add(s1);

				} else {
					s = (ArrayList<Object>) arr1.get(it).clone();
					s.add(i);
					//System.out.println("s:" + s);
					arr1.add(s);
					//System.out.println("size:" + arr1.size());
					//System.out.println("arr1:" + arr1);
					//System.out.println("arr:" + arr);
					// System.out.println(it);
				}
			}
			//arr = arr1;
			//for(int it=0;it<len;it++) { 
				arr=(ArrayList<ArrayList<Object>>) arr1.clone(); 
			//}
		}
		return arr;
	}

	public static void Knap(int w[], int[] v, int W, ArrayList<ArrayList<Object>> arr) {
		int count = 0;
		int sumw, sumv;
		int maxi=0, maxsumw = 0, maxsumv = 0;
		int len = arr.size();
		System.out.printf("���\tѡ����Ʒ\t  ������\t�ܼ�ֵ\t�ܷ�װ��\n");
		for (int it = 0; it < len; it++) {
			System.out.printf(" %d\t", count + 1);
			sumw = 0;
			sumv = 0;
			System.out.printf("{ ");
			if(arr.get(it)==null) ;
			else {
			for (int it2 = 0; it2 < arr.get(it).size(); it2++) {
				
				if (arr.get(it).get(it2) == null)
					continue;
				int num = (int) arr.get(it).get(it2);
				System.out.printf("%d ", num);
				sumw += w[num - 1];
				sumv += v[num - 1];
			}
			}
			System.out.printf("}\t");
			System.out.print(sumw+"\t"+sumv+"\t");
			if (sumw <= W) {
				System.out.printf("��\n");
				if (sumv > maxsumv) {
					maxsumv = sumv;
					maxsumw = sumw;
					maxi = count;
				}
			} else
				System.out.printf("��\n");
			count++;
		}
		System.out.println("��ѷ���Ϊ:ѡ����Ʒ{"+arr.get(maxi)+"},������:"+maxsumw+",�ܼ�ֵ:"+maxsumv);
		
	}

	public static void main(String[] args) {
		int n = 4, W = 6;
		int[] w = { 5, 3, 2, 1 };
		int[] v = { 4, 4, 3, 1 };
		ArrayList<ArrayList<Object>> arr = setarr(n);
		Knap(w,v,W,arr);
	}
}

