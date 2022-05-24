package com.shop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptTest {
	private String data = "1234";
	private String indata = "MTIzNA==";
	private String encoding;
	private byte[] decoding;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void Cryptest1() {
		encoding = Base64.getEncoder().encodeToString(data.getBytes());
		String StrDecode = new String(decoding);
		System.out.println("암호화된 데이터 : "+encoding);
		fail("암호화 테스트가 실패되었습니다.");
	}

}
