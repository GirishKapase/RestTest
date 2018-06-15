package com.rest.test;

import java.io.IOException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestServiceTest {

	public static void main(String[] args) throws IOException {
		String restServiceUrl = "http://localhost:8080/RestTest/rest/dataRead";
		try {

			Client client = Client.create();

			WebResource webResource = client.resource(restServiceUrl);

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
