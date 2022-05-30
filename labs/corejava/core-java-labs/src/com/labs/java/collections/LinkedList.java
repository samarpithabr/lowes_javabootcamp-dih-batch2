package com.labs.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> aryInter=new LinkedList<Integer>();
		aryInter.add(32);
		aryInter.add(322);
		aryInter.add(54);
		/*
		 * for (Integer integer : aryInter) { System.out.println(integer); }
		 */
		System.out.println("iterator");
		Iterator< Integer> iterator1=aryInter.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		ArrayList arryList=new ArrayList<>();
		arryList.add("sam");
		arryList.add("sharu");
		arryList.add("siri");
		for (Object a : arryList) {
			System.out.println(a);
		}
		
		arryList.set(2, "siri sharath");
		System.out.println("after update");
		for (Object a : arryList) {
			System.out.println(a);
		}
		arryList.remove(1);
		
		System.out.println("after removal");
		for (Object a : arryList) {
			System.out.println(a);
		}
		ListIterator<Integer> iter=aryInter.iterator();
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.previous());
		System.out.println(iter.previous());
		if(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		
	}

}
