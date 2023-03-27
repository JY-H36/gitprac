
package violence;

import java.util.HashSet;
import java.util.Iterator;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�Package0_1   
* �������� ���0/1�������⣬����n����Ʒ����������ֵ����һ������Wmax�ı�����Ҫ���ñ���װ����Ʒ��ֵ���  
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��26�� ����10:15:13   
* @version        
*/
public class Package0_1 {
	class Obj{
		public int id;
		public int weight;
		public int value;
		public Obj(int id,int weight,int value) {
			this.id=id;
			this.weight=weight;
			this.value=value;
		}
	}
	public Obj[] objs=new Obj[4];
	public void initObjs(Obj[] objs) {
		objs[0]=new Obj(1,5,4);
		objs[1]=new Obj(2,3,4);
		objs[2]=new Obj(3,2,3);
		objs[3]=new Obj(4,1,1);
	}
	
	public HashSet<HashSet<Integer>> allSet=new HashSet<HashSet<Integer>>();
	public HashSet<Integer> best=new HashSet<Integer>();
	public int maxWeight=6;
	public int maxValue=0;
	
	public void initSet() {
		HashSet<Integer> hs=new HashSet<Integer>();//�����ռ�
		hs.add(-1);
		allSet.add(hs);//������{1}�����ܼ���
	}
	
	public void insertNum(int n) {
		Iterator<HashSet<Integer>> it=allSet.iterator();
		while(it.hasNext()) {
			HashSet<Integer> hs=it.next();
			hs.add(n);
			allSet.add(hs);
		}
	}
	
	public void getBestSitu(int n) {
		for(int i=0;i<n;i++) {
			insertNum(i);
		}
		Iterator<HashSet<Integer>> it1=allSet.iterator();
		while(it1.hasNext()) {
			int weights=0;
			int values=0;
			HashSet<Integer> hs=it1.next();
			Iterator<Integer> it2=hs.iterator();
			while(it2.hasNext()) {
				int id=it2.next();
				if(id!=-1) {
					System.out.print(objs[id].id+" ");
					weights+=objs[id].weight;
					values+=objs[id].value;
				}
			}
			if(values>maxValue) {
				maxValue=values;
				best=hs;
			}
			System.out.print(weights+"/t/t");
			System.out.print(values+"/t/t");
			if(weights>maxWeight) {
				System.out.print("��");
			}else {
				System.out.print("��");
			}
			
		}
	}
	public static void main(String[] args) {
		Package0_1 demo=new Package0_1();
		demo.initObjs(demo.objs);
		demo.initSet();
		System.out.printf("ѡ����Ʒ     ������      �ܼ�ֵ     �ܷ�װ��");
		demo.getBestSitu(4);
	}
}
