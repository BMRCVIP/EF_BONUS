package com.example.efbonus.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Books")
public class Books {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name ="titulo")
    public String titulo;
    @ColumnInfo(name ="autor")
    public String autor;

}
