package pm02.cameraWebSeller;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CameraWebSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CameraWebSellerApplication.class, args);
	}
	@Bean
	public ApplicationRunner dataLoader(TestDataSeeder testDataSeeder) {
		return args -> {
			// Call the method to insert test data
			testDataSeeder.insertTestData();
		};
	}
}
