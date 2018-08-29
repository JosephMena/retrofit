package org.zer0.pocs.retrofitdemo.service_retrofit;

import java.util.List;

import org.zer0.pocs.retrofitdemo.data.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

	@GET("/users")
	public Call<List<User>> getUsers(
							@Query("per_page") int per_page,
							@Query("page") int page);
	
	@GET("/users/{username}")
	public Call<User> getUser(@Path("username") String username);
	
}
