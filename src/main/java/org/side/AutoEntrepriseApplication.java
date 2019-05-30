package org.side;

import org.side.dao.CiviliteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutoEntrepriseApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(AutoEntrepriseApplication.class, args);

		final CiviliteRepository civiliteDao = ctx.getBean(CiviliteRepository.class);
		// civiliteDao.save(new Civilite("test", "test", "test",
		// LocalDate.of(2018, Month.AUGUST, 01)));
		// System.out.println("t'as vu!");
	}

}
