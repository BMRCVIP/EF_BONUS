package com.example.efbonus.service;
import com.example.efbonus.entities.Books;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BookService {
    @GET("books")
    Call<List<Books>> getListContact();
    @POST("books")
    Call<Void> create(@Body Books poke);
    @PUT("books/{id}")
    Call<Books> update(@Body Books poke, @Path("id")int id);
    @DELETE("books/{id}")
    Call<Books> delete (@Path("id")int id);
}
