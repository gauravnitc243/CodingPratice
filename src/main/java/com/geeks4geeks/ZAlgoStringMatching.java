package com.geeks4geeks;

public class ZAlgoStringMatching {

	public static void main(String[] args) {
		//search("jitender", "der");
		String source = "ababaa";
		int[] Z = new int[source.length()];
		constructZArray(source, Z);
		int sum = 0;
		for(int i : Z)
			sum +=i;
		System.out.println(sum+source.length());
	}

	public static void search(String text, String pattern) {
		String concat = pattern + "$" + text;
		int l = concat.length();
		int[] Z = new int[l];
		constructZArray(concat, Z);
		for (int i = 0; i < l; ++i) {
			if (Z[i] == pattern.length())
				System.out.println(i - pattern.length() - 1);
		}
	}

	public static  void constructZArray(String source, int[] zArray) {
		int k;
		int left = 0;
		int right = 0;
		for (int i = 1; i < source.length(); ++i) 
		{
			if (i > right) 
			{
				left = right = i;
				while (right < source.length() && (source.charAt(right - left) == source.charAt(right)))
				{
					right++;
				}
				zArray[i] = right - left;
				right--;
			} 
			else
			{
				k = i - left;
				if (zArray[k] < right - i + 1)
				{
					zArray[i] = zArray[k];
				}
				else 
				{
					left = i;
					while (right < source.length() && (source.charAt(right - left) == source.charAt(right)))
					{
						right++;
					}
					zArray[i] = right - left;
					right--;
				}
			}
		}
	}

}
