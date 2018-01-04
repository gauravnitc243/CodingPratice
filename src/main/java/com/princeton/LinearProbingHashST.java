package com.princeton;

public class LinearProbingHashST<Key,Value> {
	private int m = 30000;
	private Key[] keys =(Key[]) new Object[m];
	private Value[] values = (Value[]) new Object[m];
	
	public void put(Key key,Value value)
	{
		if(key == null)
			return;
		int i;
		for(i = hashCode(key); keys[i] !=null; i = (i+1)%m)
			if(keys[i].equals(key))
				break;
		keys[i] = key;
		values[i] = value;
	}
	
	public Value get(Key key)
	{
		for(int i = hashCode(key) ; keys[i]!=null;i = (i+1)%m)
			if(keys[i].equals(key))
				return values[i];
		return null; 
	}
	
	
	public int hashCode(Key key)
	{
		return (key.hashCode() & 0x7fffffff)%m;
	}

	public static void main(String[] args) {
		LinearProbingHashST<String,String> map  = new LinearProbingHashST<String,String>();
		map.put("jitender", "choudhary");
		System.out.println(map.get("man"));
		System.out.println(map.get("Jitu"));System.out.println(map.get("jitender"));

	}

}
