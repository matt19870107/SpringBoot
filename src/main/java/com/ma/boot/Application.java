package com.ma.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ma.boot.config.AuthorSettings;

@RestController
@SpringBootApplication
public class Application {
	@Value("${book.author}")
	private String bookAutor;
	@Value("${book.name}")
	private String bookName;
	@Autowired
	AuthorSettings authorSettings;
	
	@RequestMapping("/")
	String index() {
		return "book name is:" + bookName +", book autor is:" + bookAutor;
	}
	
	@RequestMapping("/authorsettings")
	String authorSettings() {
		return "author name is:" + authorSettings.getName() + ", author age is:" + authorSettings.getAge() + ", author sex is:" + authorSettings.getSex();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		//app.setBannerMode(Banner.Mode.OFF);// turn off the banner
		app.run(args);
	}
}
