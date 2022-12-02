package com.example.efbonus.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.efbonus.entities.Books;

import java.util.List;

@Dao
public interface BooksDao {

    @Query("SELECT * FROM books")
    List<Books> getAll();
    @Query("SELECT * FROM books where id = :abc")
    Books find(int abc);
    @Insert
    void create(Books bks);
    @Update
    void update(Books bks);
    @Query("DELETE FROM books")
    void delete();



}
