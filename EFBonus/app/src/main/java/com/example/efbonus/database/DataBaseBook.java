package com.example.efbonus.database;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.efbonus.entities.Books;

@Database(entities = {Books.class}, version=1)
public abstract class DataBaseBook extends RoomDatabase {
    public abstract BooksDao booksDao();
    public static DataBaseBook getInstance(Context context){
        return Room.databaseBuilder(context, DataBaseBook.class, "BaseDBooks")
                .allowMainThreadQueries()
                .build();
    }

}
