package com.example.demo.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Embeddable는 독립성이 없음.
// 테이블을 혼자 존재할 수 없음.
// 종속됨을 표시 해주어야 함
// ElementCollection <-> Embeddable
// Entity와 id가 존재하지 않음
// 실제 db에는 product_image_list 테이블이 독립적으로 만들어진 것처럼 보이지만
// 구조상 tbl_product에 종속되어 있는 구조다.

@Embeddable
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
	
	private String fileName;
	
	// 대표 이미지 ord ( 여러 이미지 중 미리보기로 보여줄 하나의 이미지)
	private int ord;
	
	public void setOrd(int ord) {
		this.ord = ord;
	}
}
