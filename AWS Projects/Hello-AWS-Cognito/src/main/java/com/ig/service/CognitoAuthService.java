package com.ig.service;
import java.util.Map;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.*;

@Service
public class CognitoAuthService {

    public static final String clientId = "6sl2qmr4jkpbmo49tf4ul8r832";
	public static final String clientSecret = "1tdo4v5bg84s8494icuo6og1rdv3qtkpig766uit72g0h37161rt";
	public static final String userPoolId = "ap-south-1_Walp8wg0E";
			
			
	private final CognitoIdentityProviderClient cognitoClient =
            CognitoIdentityProviderClient.builder()
                    .region(Region.AP_SOUTH_1)
                    .build();

	 public void createUser(
			 String email,
             String temporaryPassword,
             String permanentPassword,
             String groupName) 
	 {
		 		// Create User Request
		 		AdminCreateUserRequest createRequest =
		 		AdminCreateUserRequest.builder()
		 		.userPoolId(userPoolId)
		 		.username(email)
		 		.temporaryPassword(temporaryPassword)
		 		.messageAction(MessageActionType.SUPPRESS)
		 		.userAttributes( 
		 						AttributeType.builder()
		 								.name("email")
		 								.value(email)
		 								.build(),
	
				                  AttributeType.builder()
				                          .name("email_verified")
				                          .value("true")
				                          .build()
		 								)
		 		.build();
		 		cognitoClient.adminCreateUser(createRequest);
	
				// Add to Group
				AdminAddUserToGroupRequest groupRequest =
				  AdminAddUserToGroupRequest.builder()
				          .userPoolId(userPoolId)
				          .username(email)
				          .groupName(groupName)
				          .build();
	
				cognitoClient.adminAddUserToGroup(groupRequest);
	
				// Set Permanent Password
				AdminSetUserPasswordRequest passwordRequest =
				  AdminSetUserPasswordRequest.builder()
				          .userPoolId(userPoolId)
				          .username(email)
				          .password(permanentPassword)
				          .permanent(true)
				          .build();
	
				cognitoClient.adminSetUserPassword(passwordRequest);
	}
	 
    public AuthenticationResultType login(
    									  String username,
                                          String password,
                                          String clientId,
                                          String secretHash) 
    {

        InitiateAuthRequest request = InitiateAuthRequest.builder()
                .clientId(clientId)
                .authFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .authParameters(Map.of(
                        "USERNAME", username,
                        "PASSWORD", password,
                        "SECRET_HASH", secretHash
                ))
                .build();

        InitiateAuthResponse response = cognitoClient.initiateAuth(request);
        return response.authenticationResult();
    }
}