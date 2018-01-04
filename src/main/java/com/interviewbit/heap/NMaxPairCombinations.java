package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class NMaxPairCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Pair{
		int i;
		int j;
	}
	 public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		 return new ArrayList<Integer> ();
		 /*
		 	Queue q = new LinkedList<>();
			priority_queue<pair<int, Pair > hp;
			set<Pair> S;
			int n = A.size();
			Collections.sort(A);
			Collections.sort(B);
			hp.push(make_pair(A.get(n-1+B.get(n-1), make_pair(n-1, n-1)));
			S.insert(make_pair(n-1, n-1));

			ArrayList<Integer> ans;
			int k=n;
			while(k--){
				pair<int, pair<int, int> > top = hp.top();
				hp.pop();
				ans.push_back(top.first);
				int L = top.second.first;
				int R = top.second.second;
				
				if( R>0 && L>=0  && S.find(make_pair(L,R-1)) == S.end() ){
					hp.push(make_pair(A[L]+B[R-1], make_pair(L,R-1)));
					S.insert(make_pair(L,R-1));
				}
				if( R>=0  && L>0 && S.find(make_pair(L-1, R))==S.end()){
					hp.push(make_pair(A[L-1]+B[R], make_pair(L-1,R)));
					S.insert(make_pair(L-1, R));
				}
			}
			return ans;
	 */}

}
