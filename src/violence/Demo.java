/**
 * 
 */
package violence;

/**   
*    
* 项目名称：Algorithm   
* 类名称：Demo   
* 类描述：   
* 创建人：万重山   
* 创建时间：2023年3月26日 下午9:12:50   
* @version        
*/
import java.util.Scanner;
public class Demo {
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  int m;//物品的数量
  int capacity;//背包的容量
  int wb=0;//初始化背包的质量
  int vb=0;//初始化背包的价值
  Solves s=new Solves();
     Scanner sc=new Scanner(System.in);
     System.out.print("请输入物品的数量：");
     m=sc.nextInt();
     System.out.print("请输入背包的容量：");
     capacity=sc.nextInt();
     int weight[]=new int[m];//用来记录每个物品的重量
     int value[]=new int[m];//用来记录每个物品的价值
     for(int i=0;i<m;i++)
     {
      System.out.print("请输入物品"+i+"的重量：");
      weight[i]=sc.nextInt();
      System.out.print("请输入物品"+i+"的价值：");
      value[i]=sc.nextInt();
     }
     int MaxValue[]=new int[(int)Math.pow(2, m)];
     System.out.println("各个方案如下：");
     for (int i = 0; i <Math.pow(2, m); i++)
  {
   for (int j =0; j<m; j++)
   {
       if(s.Subset(m)[i][j]==1)
       {
        wb+=weight[j]*s.Subset(m)[i][j];
        vb+=value[j];
        System.out.print("物品:"+j+"");
       }
   }
 
   
   if(wb<=capacity)
   {
    MaxValue[i]=vb;
      System.out.println("------"+"方案"+i+":总价值为："+vb+" "+"总重量为："+wb);
   }
   else
   {
     System.out.println("------"+"方案"+i+":超出背包容量！");
   }
   
   wb=0;
   vb=0;
  }
    System.out.println("背包可装入的最大价值为："+s.MaxValue(MaxValue));
 }
}