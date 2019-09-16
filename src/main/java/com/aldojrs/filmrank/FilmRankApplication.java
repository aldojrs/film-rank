package com.aldojrs.filmrank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FilmRankApplication {

	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(FilmRankApplication.class);
		builder.headless(false);
		builder.run(args);
		
		// Activar para ver cliente de base de datos HSQLDB en memoria.
		// org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:filmrankdb", "--noexit", "--user", "sa", "--password", "sa" });
	}

}

