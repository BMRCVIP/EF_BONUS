package com.example.efbonus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.efbonus.adapter.booksAdapter;
import com.example.efbonus.database.DataBaseBook;
import com.example.efbonus.entities.Books;

import java.util.List;

public class ListarBookActivity extends AppCompatActivity {
    RecyclerView listaBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_book);
        listaBooks=findViewById(R.id.listaLibros);
        DataBaseBook dbook = DataBaseBook.getInstance(ListarBookActivity.this);
        List<Books> datos = dbook.booksDao().getAll();

        listaBooks=findViewById(R.id.listaLibros);
        listaBooks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listaBooks.setAdapter(new booksAdapter(datos));
        Log.i("MAIN_APP", "Si entra");
    }
}