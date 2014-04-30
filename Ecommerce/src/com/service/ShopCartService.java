package com.service;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.*;
@Service @Transactional
public class ShopCartService {
	private static HashMap<Integer,ShopCart> items = new HashMap<Integer,ShopCart>();
	public static boolean addItem(SP sp){
		if(!items.containsKey((int)sp.getSPId())){
			ShopCart item = new ShopCart();
			item.setDrop(false);
			item.setNum(1);
			item.setSp(sp);
			items.put((int)sp.getSPId(), item);
			return true;
		}
		return false;
	}
	public static void clear(){
		items.clear();
	}
	
	public static boolean drop(int pid){
		if(items.containsKey(pid)){
			ShopCart item = items.get(pid);
			item.setDrop(true);
			items.remove(pid);
			return true;
		}
		return false;
		
	}
	
	public static List<ShopCart> getItems(){
		ArrayList<ShopCart> list = new ArrayList<ShopCart>();
		Iterator<Integer> it =  items.keySet().iterator();
		while(it.hasNext()){
			ShopCart item = items.get(it.next());
			if(!item.isDrop()){
				list.add(item);
			}
		}
		return list;
	}
	public static double getPrice(){
		double totalPrice = 0;
		Iterator<Integer> it =  items.keySet().iterator();
		while(it.hasNext()){
			ShopCart item = items.get(it.next());
			if(!item.isDrop()){
				totalPrice+=item.getSp().getProduct().getPrice()*item.getNum();
			}
		}
		return totalPrice;
	}
	public static boolean updateNum(int pid,int num){
		if(items.containsKey(pid)){
			ShopCart item = items.get(pid);
			item.setNum(num);
			return true;
		}
		return false;
	}
}
