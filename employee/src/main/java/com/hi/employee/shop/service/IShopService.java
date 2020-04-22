package com.hi.employee.shop.service;

import java.util.List;

import com.hi.employee.shop.ShopVO;

public interface IShopService {
	void shopInsert(ShopVO shop);
	List<ShopVO> shopSelectAll();
	
	ShopVO shopSearch(ShopVO shop);
	int shopPw(String pw);
}
