package com.example.webcrawler;

import com.example.webcrawler.urlentity.UrlEntityDAO;
import com.example.webcrawler.urlentity.UrlEntity;
import com.example.webcrawler.webcrawler.WebCrawlerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

@SpringBootApplication
public class WebCrawlerApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(WebCrawlerService theWebCrawlerService) {
		return runner -> {
		};
	}

	private void createUrl(UrlEntityDAO theUrlEntityDAO) throws URISyntaxException, MalformedURLException {

		//create UrlEntity object
		URL theURL = new URI("https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/42311220#questions").toURL();
		UrlEntity theUrlEntity = new UrlEntity(theURL);
		System.out.println("UrlEntity created...");

		//save UrlEntity object
		System.out.println("Saving the UrlEntity...");
		theUrlEntityDAO.save(theUrlEntity);

		//display id of saved object
		System.out.println("Saved UrlEntity. Generated id: " + theUrlEntity.getId());
	}

	private void readURL(UrlEntityDAO theUrlEntityDAO) {
		UrlEntity theUrlEntity = theUrlEntityDAO.findById(1);
		System.out.println("Printing UrlEntity: " + theUrlEntity.toString());
	}

	private void queryByDomain(String domain, WebCrawlerService theWebCrawlerService) {
		ArrayList<UrlEntity> urlEntities = new ArrayList<>();
		urlEntities = (ArrayList<UrlEntity>) theWebCrawlerService.queryUrlEntitiesByDomain(domain);
		System.out.println("UrlEntities w/ domain = " + domain + ": ");
		for (UrlEntity urlEntity: urlEntities) {
			System.out.println(urlEntity.toString());
		}
	}

}
