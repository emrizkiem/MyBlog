package dev.emrizkiem.myblog.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dev.emrizkiem.myblog.data.model.Post;

@Database(entities = {Post.class}, version = 1, exportSchema = false)
public abstract class MyBlogDatabase extends RoomDatabase {

    public abstract MyBlogDao myBlogDao();

    private static MyBlogDatabase database;

    public static MyBlogDatabase getDatabase(final Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), MyBlogDatabase.class, "blog_database")
                    .build();
        }
        return database;
    }

}
