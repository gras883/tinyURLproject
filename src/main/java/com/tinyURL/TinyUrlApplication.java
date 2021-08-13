package com.tinyURL;

import com.tinyURL.Service.Codec;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TinyUrlApplication {

	public static void main(String[] args) {

		SpringApplication.run(TinyUrlApplication.class, args);
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TinyUrlApplication.class);

		//Codec converter = context.getBean("codec", Codec.class );

		//String encoded = converter.setsortUrl("https://www.scaler.com/academy/" +
				//"mentee-dashboard/classroom/lld-v-a04ae7cf-b36c-4002-b40b-3a52c1a38161/?status=active#lecture");

		//System.out.println(encoded);
		//context.close();
	}

}
