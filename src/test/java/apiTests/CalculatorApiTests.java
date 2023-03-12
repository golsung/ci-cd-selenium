package apiTests;

import cloud.ez2learn.seleniumproj.SeleniumProjApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = SeleniumProjApplication.class)
class CalculatorApiTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	private final String  server = System.getProperty("calculator.url");

	@LocalServerPort
	int randomServerPort;

	@Test
	void goHome() {
		String result = testRestTemplate.getForObject(server+":"+randomServerPort, String.class);
		assertTrue(result.contains("Learn CI/CD at Ez2Learn Cloud"));
	}

	@Test
	void getSum() {
		int result = testRestTemplate.getForObject(server+":" + randomServerPort + "/api/sum?a=5&b=10", Integer.class);
		assertEquals(15, result);
	}

//	@Test
//	void getSum() {
//		ResponseEntity<Integer> result = testRestTemplate.getForEntity(server+":" + randomServerPort + "/api/sum?a=5&b=10", Integer.class);
//		assertEquals(15, result.getBody());
//	}

	// @Test
	// void getDiff() {
	// 	int result = testRestTemplate.getForObject(server+":" + randomServerPort + "/diff?a=5&b=10", Integer.class);
	// 	assertEquals(-5, result);
	// }

}
