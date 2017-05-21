import java.util.Scanner;
public class LPSubstring
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] arg)
	{
		String s = sc.next();
		System.out.println(longestPallinsromicSubstring(s));

	}
	public static int longestPallinsromicSubstring(String s)
	{
		int len = s.length();
		int start = 0,maxlen  = 1; 
		boolean[][] b = new boolean[len][len];
		for(int i = 0;i < len;i++)
			b[i][i] = true;
		for(int i = 0;i < len - 1;i++)
		{
			if(s.charAt(i) == s.charAt(i + 1))
			{
				b[i][i + 1] = true;
				start = i;
				maxlen = 2;
 			}
		}
		for(int k = 3;k < len;k++)
		{
			for(int i = 0;i < (len - k + 1);i++)
			{
				int j = i + k -1;
				if(b[i + 1][j - 1] && s.charAt(i) == s.charAt(j))
				{
					b[i][j] = true;
					if(k > maxlen)
					{
						start = i;
						maxlen = k;
					}
				}
			}
		}
		printLPS(s,start,start + maxlen - 1);
		return maxlen;
	}
	public static void printLPS(String s,int low,int high)
	{
		for(int i = low;i <= high;i++)
			System.out.print(s.charAt(i));
		System.out.println();
	}

}