package pe.reto.interbank.jurado;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RetoInterbankOscarJuradoApplication.class);
		//return application.sources(RetoInterbankOscarJurado2Application.class);
	}

}
