package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 양방향 관계맺기가 되있는 경우
// exclude 는 순환참조, 무한루프가 발생할 수 있으므로
// imageList 가 원인일 수 있으므로 제외시켜서 ToString를 해줌.
// (양쪽 다 ToString이 있으므로 서로를 계속 호출함.)

@Entity
@Table(name = "tbl_product")
@Getter
@ToString(exclude = "imageList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	
	private String pname;
	
	private int price;
	
	private String pdesc;
	
	private boolean delFlag;

	// ElementCollection 은 지연로딩(Lazy Loading)이 기본이다.
	// 값 타입 컬렉션
	// 데이터 무결성
	@ElementCollection
	@Builder.Default
	private List<ProductImage> imageList = new ArrayList<>();
	// imageList를 값 타입으로 관리(Product를 통해서.. cascade와 흡사함)
	// pno를 외래키로 참조.
	
	//Builder.Default는 
	//Builder이 객체를 새로 만드는 어노테이션 이기 때문에
	//Default는 null 체크를 안함(null point exception 방지)
	
	public void changePrice(int price) {
		this.price = price;
	}
	
	public void changeDesc(String desc) {
		this.pdesc = desc;
	}
	
	public void changeName(String name) {
		this.pname = name;
	}
	
	public void addImage(ProductImage image) {
		image.setOrd(this.imageList.size());
		imageList.add(image);
	}
	
	public void addImageString(String fileName) {
		ProductImage productImage = ProductImage.builder()
				.fileName(fileName)
				.build();
		
		addImage(productImage);
	}
	
	public void changeDel(boolean delFlag) {
		this.delFlag = delFlag;
	}
	
	public void clearList() {
		this.imageList.clear();
	}
	
}
