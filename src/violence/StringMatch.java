/**
 * 
 */
package violence;

/**   
*    
* 项目名称：Algorithm   
* 类名称：StringMatch   
* 类描述：分别用BF,BM,KMP实现字符匹配   
* 创建人：万重山   
* 创建时间：2023年3月26日 上午11:46:04   
* @version        
*/
public class StringMatch {
	
	/*
	 * BF算法：利用两个指针i，j分别遍历主串和模式串，i从起点开始，j从0开始
	 * 匹配时两个指针同时后移，不匹配，i指针回溯到起点后一位，j重置为0
	 * 直到j已经遍历完模式串，出现位置位置为i，return i
	 * 或者i遍历到超出指定长度，说明没有找到模式串，返回-1
	 */
	public int BF(String main,String mode,int start) {
		if(main!=null&&mode!=null&&mode.length()>0&&main.length()>=mode.length()) {
			int i=start,j=0;
			while(i<main.length()&&j<mode.length()){
					if(main.charAt(i)==mode.charAt(j)) {
						i++;
						j++;
					}else {
						i=++start;
						j=0;
					}
			}
			if(j==mode.length()) {
				int index=i-mode.length();
				//System.out.println("BF:"+mode+"在"+main+"第一次出现位置:"+index);
				return index;
			}
			return -1;
		}
		
		return -1;
	}
	
	/*
	 * KMP算法的关键就是求模式串每个字符的next数组
	 * 即如果主串和模式串不匹配的话，模式串应该回溯到什么位置
	 * 基本思想：next[n]值为n前的最长重复前后缀子串长度+1
	 * next[0]&next[1]已知，使用它们求后面的next值，为了方便，将next[0]置为-1
	 * 从next[2]开始，如果str[1]==str[next[1]]即str[n-1]==str[next[n-1]]
	 * next[2]=next[1]+1即next[n]==next[n-1]+1
	 * 若k==0，则说明已经没有重复的前后缀子串,next[n]=0
	 * 若k!=0，说明还有重复的前后缀子串，继续寻找最长的重复前后缀子串
	 * 
	 * 最最关键的一步要注意理解:将k置换为next[k]!!!
	 * 
	 * 继续比较str[n-1]和str[k]
	 */
	public int[] getNext(String mode) {
		int[] next=new int[mode.length()];
		next[0]=-1;
		next[1]=0;
		int j=1;//str[1]
		int k=0;//str[next[1]]
		//利用j和k两个指针来求next[2]到next[mode.len]
		while(j<mode.length()-1) {
			if(mode.charAt(j)==mode.charAt(k)) {
				next[j+1]=next[j]+1;
				j++;
				k++;
			}else if(k==0) {//匹配失败
				next[j+1]=0;
				j++;
			}else {
				k=next[k];
			}
		}
		return next;
	}
	
	/*
	 * 利用i，j两个指针遍历主串和模式串，但是遇到不匹配的情况下
	 * i指针不动，j指针只回溯到next[j]也就是next[j]前面已经匹配好了
	 * 减少了回溯，时间复杂度O(m+n)
	 */
	public int KMP(String main,String mode,int start) {
		if(main!=null&&mode!=null&&mode.length()>0&&main.length()>=mode.length()) {
			
			int[] next=getNext(mode);
			int i=start;
			int j=0;
			while(i<main.length()&&j<mode.length()){
				if(j==-1||main.charAt(i)==mode.charAt(j)) {
					i++;
					j++;
				}else {
					j=next[j];
				}
			}
			if(j==mode.length()) {
				int index=i-mode.length();
				//System.out.println("BF:"+mode+"在"+main+"第一次出现位置:"+index);
				return index;
			}
			return -1;
		}
		
		return -1;
	}
	public static void main(String[] args) {
		StringMatch demo=new StringMatch();
		String main="abaabab";
		String mode="aab";
		//int index=demo.BF(main, mode, 0);
		int index=demo.KMP(main, mode, 0);
		System.out.println(mode+"在"+main+"第一次出现位置:"+index);
	}
}
