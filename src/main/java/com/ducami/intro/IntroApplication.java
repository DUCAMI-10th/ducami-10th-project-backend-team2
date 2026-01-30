package com.ducami.intro;

import com.ducami.intro.global.config.DotenvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IntroApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(IntroApplication.class);
		app.addInitializers(new DotenvConfig());
		app.run(args);
		System.out.println("Hello Ducami Intro!");
	}
}