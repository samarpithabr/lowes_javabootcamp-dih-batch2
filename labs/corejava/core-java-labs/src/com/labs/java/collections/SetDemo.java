package com.labs.java.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String args[]) {
		HashSet<String> hash=new HashSet<>();
		hash.add("USA");
		hash.add("norway");
		hash.add("india");
		hash.add("india");
		hash.add("");
		hash.add(null);
		for (String item : hash) {
			System.out.println(item);
		}
		TreeSet<String> tree=new TreeSet<>();
		tree.add("zebra");
		tree.add("monkey");
		tree.add("lion");
		tree.add(null);
		for (String li : tree) {
			System.out.println(li);
		}
	}
	
	

}
