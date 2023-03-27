/**
 * 
 */
package violence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


/**   
*    
* 项目名称：Algorithm   
* 类名称：AllArrays   
* 类描述：解决全排列问题   
* 创建人：万重山   
* 创建时间：2023年3月26日 下午4:51:24   
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
	        res.add(A.charAt(0) + "");//初始化,包含第一个字符
	        for (int i = 1; i < n; i++) {//新的字符插入到前面生成集合的每个元素里面
	            ArrayList<String> res_new = new ArrayList<>();
	            char c = A.charAt(i);
	            for (String str : res) {//访问上一趟集合中的每个字符串
	                //插入到每个位置,形成一个新串
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
