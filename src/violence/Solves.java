/**
 * 
 */
package violence;

/**   
*    
* 项目名称：Algorithm   
* 类名称：Solves   
* 类描述：   
* 创建人：万重山   
* 创建时间：2023年3月26日 下午9:12:10   
* @version        
*/
public class Solves {
	public int[] DecimaltoBinary(int n,int m)
	 {
	  int r;//求余数
	  int consult=1;//求商
	  int j = 0;
	  int []arr=new int[m];
	  while (consult!=0)
	  {
	   consult = n / 2;
	   r = n % 2;
	   n = consult;
	   arr[j] = r;
	   j++;
	  }
	  return arr;
	 }
	 /**
	  * 将求得的一位数组子集转换为二维数组
	  * @param m
	  * @return
	  */
	 public int[][] Subset(int m)
	 {
	  Solves s=new Solves();
	  int subset[][]=new int[(int) Math.pow(2, m)][m];
	  for (int i = 0; i <Math.pow(2, m); i++)
	  {
	   for (int j =0; j<m; j++)
	   {
	    subset[i][j]=s.DecimaltoBinary(i,m)[j];
	   }
	  }
	    return subset;
	 
	 }
	 public int MaxValue(int arr[])
	 {
	   int max = arr[0];
	      for (int in = 0 ; in < arr.length; in++)
	         {
	           if( arr[in] > max)
	           {
	            max = arr[in];
	           }
	          }
	  return max;
	 
	 }
}
