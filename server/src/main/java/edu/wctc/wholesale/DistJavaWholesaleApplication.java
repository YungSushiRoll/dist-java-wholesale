package edu.wctc.wholesale;

import edu.wctc.wholesale.dto.WholesaleDTO;
import edu.wctc.wholesale.entity.WholesaleOrder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.print.attribute.standard.Destination;

@SpringBootApplication
public class DistJavaWholesaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistJavaWholesaleApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:63342");
			}
		};
	}

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper mm = new ModelMapper();
		mm.getConfiguration()
				.setAmbiguityIgnored(true)
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		mm.typeMap(WholesaleOrder.class, WholesaleDTO.class).addMappings(mapper -> {
			mapper.map(WholesaleOrder::getPurchaseDate,
					WholesaleDTO::setDate);
			mapper.map(WholesaleOrder::getShippedDate,
					WholesaleDTO::setShipped);
//			mapper.map(src -> src.getProduct().getCost(), WholesaleDTO::setTotal);

		});

		return mm;
	}

}
