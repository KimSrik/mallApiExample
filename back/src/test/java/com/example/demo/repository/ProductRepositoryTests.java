package com.example.demo.repository;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import com.example.demo.domain.Product;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {
	
	@Autowired
	ProductRepository productRepository;
	
	/*
	@Test
	public void testInsert() {
		for(int i=0; i<10; i++) {
			Product product = Product.builder()
					.pname("상품" + i)
					.price(100*i)
					.pdesc("상품설명 " + i)
					.build();
			
			product.addImageString(UUID.randomUUID().toString() + "_" + "IMAGE1.jpg");
			product.addImageString(UUID.randomUUID().toString() + "_" + "IMAGE2.jpg");
			
			productRepository.save(product);
			
			log.info("------------------------");
			
		}
	}
	*/
	
	/*
	// 쿼리문 두번 실행 
	// Transactional은 두개이상의 테이블에 접근할 때 사용
	@Transactional
	@Test
	public void testRead() {
		Long pno = 1L;
		
		Optional<Product> result = productRepository.findById(pno);
		
		Product product = result.orElseThrow();
		
		log.info(product);
		log.info(product.getImageList());
	}
	*/
	
	/*
	// Left Outer Join을 활용해
	// Query문을 한번만 실행하는 케이스
	@Test
	public void testRead() {
		Long pno = 1L;
		
		Optional<Product> result = productRepository.selectOne(pno);
		
		Product product = result.orElseThrow();
		
		log.info(product);
		log.info(product.getImageList());
	}
	*/
	
	/*
	@Commit
	@Transactional
	@Test
	public void testDelete() {
		Long pno = 2L;
		
		productRepository.updateToDelete(pno, true);
	}
	// Modifying와 Query 어노테이션 두개가 실행되기 때문에 Transactional 어노테이션을 붙여야 함.
	*/
	
	/*
	@Test
	public void testUpdate() {
		Long pno = 10L;
		
		Product product = productRepository.selectOne(pno).get();
		
		product.changeName("10번 상품");
		product.changeDesc("10번 상품 설명입니다.");
		product.changePrice(10000);
		
		product.clearList();
		
		product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE1.jpg");
		product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE2.jpg");
		product.addImageString(UUID.randomUUID().toString() + "_" + "NEWIMAGE3.jpg");
		
		productRepository.save(product);
	}
	*/
	
	@Test
	public void testList() {
		Pageable pageable = PageRequest.of(0,  10, Sort.by("pno").descending());
		
		Page<Object[]> result = productRepository.selectList(pageable);
		
		result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
	}
}
