package com.example.efbonus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.efbonus.entities.Books;
import com.example.efbonus.service.BookService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearBooksActivity extends AppCompatActivity {

    EditText autorbook,titulobook;
    Button volverbook,crearbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_books);

        volverbook=findViewById(R.id.btVolver);
        crearbook=findViewById(R.id.btCrearBooks);
        autorbook=findViewById(R.id.etAutor);
        titulobook=findViewById(R.id.etTitulo);

        volverbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearBooksActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        crearbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Books books=new Books();
                books.autor=autorbook.getText().toString();
                books.titulo=titulobook.getText().toString();
                postRetrofit(books);
            }
        });
    }
    public void postRetrofit(Books books){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635a088aff3d7bddb9adab04.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BookService service = retrofit.create(BookService.class);
        service.create(books).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast toast = Toast.makeText(CrearBooksActivity.this, "Libro ingresado", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast toast = Toast.makeText(CrearBooksActivity.this, "Error al ingresar libro", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}