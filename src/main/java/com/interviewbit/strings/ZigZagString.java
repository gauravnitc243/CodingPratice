package com.interviewbit.strings;

import java.util.ArrayList;

public class ZigZagString
{

	public static void main(String[] args)
	{
		String res = convert("DY3i5aAcCdhlS4aIgGO74qzYGCV4OXS03C63C6KuteroA95bHlDBNQyOzbbYO63EkFmJ54XRSNpxutRpctq5skpcvgv7ZMJ8WzADA9pd4qEqmxz21Rr7HhbKWV2CMPAa5KNZDwzXcCDilqBKZV15fjS30m0pa6soaJNfZdbqhMLfOMR7Hdcu8aKbBd825VXqGVH2Ax9qs09cjpe2f3HsJR6cPMcOXDAYLqkIM02ZfaUApIK2593RkI5X9spU5cxaCfjM14eMte2lKlAIbDuCD5aVeLGirPGMn3TQ71LlPKINxiSpkrDnPmJbCIjCYarHhBdL1shIxSpgautjpAvAWkCgxFqrwSO6wQlwUfuYDlX3aT8C6jQYxUxHEuQfEyWsJueCiU4LkeTUcvrbleRudfeaiEchgvorUH2oS1M1UXn1QnSxUVNmGyxr0OCoijH2p1oYIsjUpMU3fIYtWUR1jXjxCamMVnQ3RH4zNJiKsSGJ9P3GpLfH6O3l9OIdPTNe08e89MYbR79GvXWWe04MZTXvmcso1Qt6ehMOMtEllsJljRPYsWweIiilojRESbKJmpSMYKwEfQNuAw7DTwrqkbwKRjdAB8tsur5RDNIC3G1rALu3gxhrBMpmBfEIQC7JLrDodo0lkVpHnMdMUy4kukPLj2jU96qdu8kdzio1E8gKTpE0UJD2JzhFyUPnGOdCi14d2ef3UOlmI5ix9hdTHlFA4fzuoNMHpr3b9Jw64LIdyhazG", 5);
		String actualResult ="DCgG3tHzkScvW41W5cZ0ahHBGsfPLf59CtbenPkChxpxwD6EJkliUUU0ppWCRsp90RemelsomfTRu3gBLkUjuEUyiU94p4GYcdIGYC0CueblObEFRNptcg8zdq2RKVaKXCKV3moJqM7dbdqVq023cMYqZa29XsafMeIDVLM3lKprbIHBISjAgF6QYlCjHusuLebeaErH1XxVrO21UMtUxa3HKSGLlOe8b7W0vc6hlsYWljJpEQDwKjsrCG3xmfJrlVMyL2d8180JFUC13OxhAfHr6Lz3AhaOzVS6Kr5Dyb3mXpRqpvJApEzrb2ANzDB1S0sNbLRcK8XH99eH6cAk2UK35pxje2AuaGGTLISDJjrdhptvCqOluX8QxQWe4TrReco2MnSNxCHojUYRjmQ4iG3f3INeY9W4XstMEJPwiRKSwN7rwdt5I1uhpE7D0pd4PjqkogEDhPd4flidFzM3wIaial47q4X36o9BQY6J4xt5k7MD9qx7hCPZwiq5jp6fdfMua2V2xcpsRODI0AIRIUcM4llC5iPQ1NinmCaLsguAkrSwf3TYUfyCUUvufhvo11nmyojYs3I1XMnzJJPHOdT8MGXMToQOtlReiEbMKuwqbA8RNrLrMICooHMkkU6diKp2znOdem5TluNbJdh5S4OCANO5usZAmHMDlfaZO85AjJXMpk51KDr7xPY1aWwUaxEicdgSQGiIfjVN96P9vZ1MjISYAkBDABQdnu9zTJG2IHo9y";
		System.out.println(res);
		System.out.println(actualResult);
		System.out.println(res.equals(actualResult));

	}
	
	public static String convert(String a, int b)
	{
	    if (b <= 1)
	        return a;
	    ArrayList<StringBuilder> tempRows = new ArrayList<>();
	    int n = a.length();
	    StringBuilder s;
	    for (int i = 0; i < b; i++)
	        tempRows.add(new StringBuilder());
        int row = 0;
        int add = 1;
        for (int i = 0; i < n; i++) {
            s = tempRows.get(row);
            s.append(a.charAt(i));
            row += add;
            if (row == b - 1)
                add = -1;
            else if (row == 0)
                add = 1;
        }
	    StringBuilder res = new StringBuilder();
	    for (StringBuilder ss : tempRows)
	        res.append(ss);
	    return res.toString();
	    
	}
}
