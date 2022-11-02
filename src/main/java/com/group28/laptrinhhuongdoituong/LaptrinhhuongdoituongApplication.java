package com.group28.laptrinhhuongdoituong;

import com.group28.laptrinhhuongdoituong.commons.I18n;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaptrinhhuongdoituongApplication {

	public static void main(String[] args) throws Exception {
		I18n.load();
		SpringApplication.run(LaptrinhhuongdoituongApplication.class, args);
	}

}
