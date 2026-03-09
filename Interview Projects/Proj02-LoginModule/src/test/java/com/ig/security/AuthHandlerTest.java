package com.ig.security;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ig.response.Response;

@SpringBootTest
public class AuthHandlerTest 
{
	@Autowired
	//@MockBean
	AuthHandler authHandler;
	
	// ----------------CASE::1 [NULL]-----------------
	@Test
	public void testNullValidate()
	{
		Response response =  authHandler.validate(null);
		assertEquals(response.data(), false);
		assertEquals(response.message(), "Token is empty");
	}
	
	// ----------------CASE::2 [WRONG INPUTS]-----------------
	@Test
	public void testWrongInputValidate()
	{
		Response response =  authHandler.validate("jfdhfkdhfoid.dkjfidhfidfjdiofjdf.kdjfoidhfiodjfod");
		assertEquals(response.data(), false);
		assertEquals(response.message(), "Invalid token");
	}
	
	// ----------------CASE::3 [NULL]-----------------
	@Test
	public void testCorrectInputValidate()
	{
		String testUser= "rohit";
		String testPassword="1234";
		
		String token =  authHandler.getAuthentication("rohit", "1234").accessToken;
		Response response =  authHandler.validate(token);
		
		//assertEquals(response.data(), true);
		assertThat(response.data()).isEqualTo(true);
		assertThat(response.message()).contains(testUser);
		
		
	}
}
