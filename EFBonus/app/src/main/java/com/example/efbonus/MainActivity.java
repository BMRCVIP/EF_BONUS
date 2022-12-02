package com.example.efbonus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.efbonus.database.DataBaseBook;
import com.example.efbonus.entities.Books;
import com.example.efbonus.service.BookService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button crearBooks,listarBooks,sincronizarBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearBooks=findViewById(R.id.btCrearBooks);
        listarBooks=findViewById(R.id.btListarBooks);
        sincronizarBooks=findViewById(R.id.btSncBooks);
        crearBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CrearBooksActivity.class);
                startActivity(intent);
            }
        });
        listarBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListarBookActivity.class);
                startActivity(intent);
            }
        });
        sincronizarBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseBook db = DataBaseBook.getInstance(MainActivity.this);
                db.booksDao().delete();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://635a088aff3d7bddb9adab04.mockapi.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                BookService services = retrofit.create(BookService.class);
                services.getListContact().enqueue(new Callback<List<Books>>() {
                    @Override
                    public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                        List<Books> datos = response.body();
                        for(int i=0;i<datos.size();i++){
                            db.booksDao().create(datos.get(i));
                            Toast toast = Toast.makeText(MainActivity.this, "Sincronizado correctamente", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Books>> call, Throwable t) {
                    }
                });
            }
        });
    }
}