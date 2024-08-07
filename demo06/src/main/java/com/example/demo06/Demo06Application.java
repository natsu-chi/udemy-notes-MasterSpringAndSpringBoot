package com.example.demo06;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo06.business.Business1Service;
import com.example.demo06.business.Business2Service;

@SpringBootApplication
public class Demo06Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private Business1Service business1Service;
	private Business2Service business2Service;

	public Demo06Application(Business1Service business1Service, Business2Service business2Service) {
		this.business1Service = business1Service;
		this.business2Service = business2Service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo06Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 初始化邏輯放在這裡
		// throw new UnsupportedOperationException("Unimplemented method 'run'");
		// 或加上其他邏輯
		// initData();

		logger.info("Value returned is {}", business1Service);
		logger.info("business1Service Value returned is {}", business1Service.calculateMax());
		logger.info("business2Service Value returned is {}", business2Service.calculateMin());
	}

	// private void initData() {
    //     // 插入初始數據或執行其他初始化邏輯
    //     System.out.println("插入初始數據...");
    //     // 示例：插入數據到資料庫或其他初始化工作
    // }

	
}
