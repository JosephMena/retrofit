package org.zer0.pocs.retrofitdemo.rest;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.retrofitdemo.data.User;
import org.zer0.pocs.retrofitdemo.service_retrofit.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
@RequestMapping("/persona")
public class UserRestController {

	@GetMapping("/saludo")
	public String saludar() {
		OkHttpClient.Builder httpCliente= new OkHttpClient.Builder();
		Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.github.com/")
								.addConverterFactory(GsonConverterFactory.create())
								.client(httpCliente.build()).build();
		
		UserService serviceUser=retrofit.create(UserService.class);
		
		Call<User> callSync=serviceUser.getUser("jmena");
		
		Response<User> response;
		try {
			response = callSync.execute();
			User user = response.body();
			System.out.println("user:"+user.getUrl());
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
		return "hola";
	}
	
}
