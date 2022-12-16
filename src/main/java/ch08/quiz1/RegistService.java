package ch08.quiz1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class RegistService {
	Map<String, Regist> regist= new HashMap<>();
	//Map 쉽게 찾을 수 있는 배열 <String = "101", Product = P>
	
	//regist 안에 각각 "101" R 값들을 넣어줌
	public RegistService() {
		Regist R = new Regist("101", "김지우", "서울시", "silver", "010-1111-1111");
		regist.put("101", R);
		
		R = new Regist("102", "홍길동", "인천시", "gold", "010-2222-2222");
		regist.put("102", R);
		
		R = new Regist("103", "율곡", "김포시", "vip", "010-3333-3333");
		regist.put("103", R);
		
	}
	
	// 모든 상품 데이터를 가져오는 메소드(select * from)
	public List<Regist> findAll() {
		return new ArrayList<>(regist.values());
	}
	
	// id로 원하는 상품을 가져오는 메소드(select * from where id = "102")
		public Regist find(String id) {
			return regist.get(id);
		}
	
	
}
