package com.icia.musicwired.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.musicwired.dao.CartDAO;
import com.icia.musicwired.dto.CartDTO;

@Service
public class CartServiceIpml implements CartService{

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private CartDAO cartdao;
	
	List<CartDTO> cartList = new ArrayList<CartDTO>();
	
//	cartListAdd : 장바구니에 상품 추가 메소드
	@Override
	public List<CartDTO> cartListAdd(CartDTO cart) {
		System.out.println("[2] 장바구니 상품 추가 S : " + cart);
		
		int result = cartdao.cartListAdd(cart);
		System.out.println("[3] 장바구니 상품 추가 S : " + result);
		
		if(result > 0) {
			
		} else {
			cartList = null;
		}
		
		return cartList;
	}

//	cartListDelete : 장바구니에 있는 상품 삭제 메소드
	@Override
	public List<CartDTO> cartListDelete(CartDTO cart) {
		System.out.println("[2] 장바구니 상품 삭제 S : " + cart);
		
		int result = cartdao.cartListDelete(cart);
		System.out.println("[3] 장바구니 상품 삭제 S : " + cart);
		
		if(result > 0) {
			List<CartDTO> Cart = cartdao.ajaxCartList(cart.getCaMid());
			cartList = Cart;
		} else {
			cartList = null;
		}
		return cartList;
	}

//	CartInCheck : 장바구니에 이미 담았는지 확인하는 메소드
	@Override
	public List<CartDTO> CartInCheck(CartDTO cart) {
		System.out.println("[2] 장바구니 확인 S : " + cart);
		
		List<CartDTO> cartCheck = cartdao.CartInCheck(cart);
		
		System.out.println("[3] 장바구니 확인 S : " + cart);
		
		if(cartCheck != null) {
			cartList = cartCheck;
		} else {
			cartList = null;
		}
		
		return cartList;
	}
	
//	ajaxCartList : 장바구니 페이지
	@Override
	public List<CartDTO> ajaxCartList(String mId) {
		System.out.println("[2] 장바구니 페이지 S : " + mId);
		
		List<CartDTO> Cart = cartdao.ajaxCartList(mId);
		
		System.out.println("[3] 장바구니 페이지 S : " + Cart);
		
		cartList = Cart;
		
		return cartList;
	}


	@Override
	public List<CartDTO> CartAddPlayList(CartDTO cart) {
		System.out.println("[2] 장바구니 상품 추가 S : " + cart);

		int result = cartdao.CartAddPlayList(cart);
		System.out.println("[3] 장바구니 상품 추가 S : " + result);

		if(result > 0) {

		} else {
			cartList = null;
		}


		return cartList;
	}

	@Override
	public List<CartDTO> CartAddCheck(CartDTO cart) {

		List<CartDTO> CartAddCheck = cartdao.CartAddCheck(cart);

		if(CartAddCheck != null) {
			cartList = CartAddCheck;
		} else {
			cartList = null;
		}

		return cartList;
	}

	@Override
	public List<CartDTO> CartAddPlayListDelete(CartDTO cart) {
		System.out.println("[2] 장바구니 상품 삭제 S : " + cart);

		int result = cartdao.CartAddPlayListDelete(cart);
		System.out.println("[3] 장바구니 상품 삭제 S : " + cart);

		if(result > 0) {
			List<CartDTO> Cart = cartdao.ajaxCartList(cart.getCaMid());
			cartList = Cart;
		} else {
			cartList = null;
		}
		return cartList;
	}


}
