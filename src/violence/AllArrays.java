/**
 * 
 */
package violence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�AllArrays   
* �����������ȫ��������   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��26�� ����4:51:24   
* @version        
*/
public class AllArrays {
	/*
	HashSet<int[]> hs=new HashSet<int[]>();
	public void allArrayTo(int n) {
		for(int i=1;i<=n;i++) {
			insertNum(i);
		}
	}
	
	public void insertNum(int n) {
		if(n==1) {
			int[] arr=new int[1];
			arr[0]=1;
			hs.add(arr);
		}else {
			Iterator<int[]> it=hs.iterator();
			while(it.hasNext()) {
				int[] arr=it.next();
				insertAll(arr,n);
			}
		}
		
	}
	
	public void disp(int n) {
		Iterator<int[]> it=hs.iterator();
		while(it.hasNext()) {
			int[] arr=it.next();
			if(arr.length==n) {
				System.out.println();
				for(int x:arr) {
					System.out.print(x);
				}
			}
		}
	}
	*/
	/**
	 * @param arr
	 * @param n
	 */
	/*
	private void insertAll(int[] arr, int n) {
		// TODO Auto-generated method stub
		int k=0;
		int[] newarr=new int[arr.length+1];
		for(int i=0;i<newarr.length;i++) {
			for(int j=0;j<newarr.length;j++) {
				if(j==i) {
					newarr[j]=n;
				}else
					newarr[j]=arr[k++];
			}
			k=0;
			hs.add(newarr);
		}
	}
	
	public static void main(String[] args) {
		AllArrays demo=new AllArrays();
		demo.allArrayTo(3);
		demo.disp(3);
	}*/
	 public static void main(String[] args) {
	        String aa = "123";
	        AllArrays demo = new AllArrays();
	        ArrayList<String> res = new ArrayList<>();
	        res = demo.getPermutation0(aa);
	        //test
	        for (String re : res) {
	            System.out.println(re);
	        }
	 
	    }
	 
	    public ArrayList<String> getPermutation0(String A) {
	        int n = A.length();
	        ArrayList<String> res = new ArrayList<>();
	        res.add(A.charAt(0) + "");//��ʼ��,������һ���ַ�
	        for (int i = 1; i < n; i++) {//�µ��ַ����뵽ǰ�����ɼ��ϵ�ÿ��Ԫ������
	            ArrayList<String> res_new = new ArrayList<>();
	            char c = A.charAt(i);
	            for (String str : res) {//������һ�˼����е�ÿ���ַ���
	                //���뵽ÿ��λ��,�γ�һ���´�
	                String newStr = c + str;
	                res_new.add(newStr);
	                newStr = str + c;
	                res_new.add(newStr);
	                for (int j = 1; j < str.length(); j++) {
	                    newStr = str.substring(0, j) + c + str.substring(j);
	                    res_new.add(newStr);
	                }
	            }
	            res = res_new;
	 
	        }
	        return res;
	    }

}
