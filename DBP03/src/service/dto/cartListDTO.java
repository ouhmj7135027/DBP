package service.dto;

import java.util.ArrayList;

public class cartListDTO {
	private ArrayList<Integer> codeList = new ArrayList<Integer>(); //상품ID
	private ArrayList<String> titleList = new ArrayList<String>(); //상품 이름
	private ArrayList<Integer> priceList = new ArrayList<Integer>(); //가격
	private ArrayList<Integer> numberList = new ArrayList<Integer>(); //수량
	private ArrayList<String> imgList = new ArrayList<String>(); //이미지
	
	public cartListDTO() {
		
	}
	
	public void setCode(int index, int code) {
		this.codeList.add(index, code);
	}
	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}
	public void setPrice(int index, Integer price) {
		this.priceList.add(index, price);
	}
	public void setNumber(int index, Integer number) {
		this.numberList.add(index, number);
	}
	public void setImg(int index, String img) {
		this.imgList.add(index, img);
	}
	
	public Integer[] getCode() {
		return codeList.toArray(new Integer[codeList.size()]);
	}
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	public Integer[] getPrice() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	public Integer[] getNumber() {
		return numberList.toArray(new Integer[numberList.size()]);
	}
	public String[] getImg() {
		return imgList.toArray(new String[imgList.size()]);
	}
	
	//상품 총 합
	public int getTotalAmount() {
		int total = 0;
		for (int cnt = 0; cnt < codeList.size(); cnt++)
			total += priceList.get(cnt) * numberList.get(cnt);
		return total;
	}
	
	//장바구니 항목 수
	public int getSize() {
		return codeList.size();
	}
	
}
