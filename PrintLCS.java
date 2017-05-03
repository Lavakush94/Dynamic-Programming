import java.util.Scanner;
class PrintLCS
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(longestCommonSubsequence(s1,s2)); 
	}
	public static String longestCommonSubsequence(String s1,String s2)
	{
		String lcs = "";
		int l = s1.length();
		int m = s2.length();
		int[][] temp = new int[l + 1][m + 1];
		int i = 0,j = 0;
		for(i = 1;i <= l;i++)
		{
			for(j = 1;j <= m;j++)
			{
				if(s1.charAt(i - 1) == s2.charAt(j - 1))
					temp[i][j] = temp[i - 1][j - 1] + 1;
				else 
					temp[i][j] = Math.max(temp[i][j - 1],temp[i - 1][j]);
			}
		}
		//print value of --temp[l][m]-- for length of longest common subsequence//
		i = l;j = m;
		while(i > 0 && j > 0)
		{
			if(s1.charAt(i - 1) == s2.charAt(j - 1))
			{
				lcs += s2.charAt(j - 1);
				i--;
				j--;
			}
			else if(temp[i - 1][j] > temp[i][j - 1])
				i--;
			else
				j--;
		}
		return reverse(lcs);
	}
	public static String reverse(String str)
	{
		int x = str.length();
		int i;
		String rev = "";
		for(i = x - 1;i >= 0;i--)
			rev += str.charAt(i);
		return rev;
	}
}
