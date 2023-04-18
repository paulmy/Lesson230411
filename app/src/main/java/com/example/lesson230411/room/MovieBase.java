package com.example.lesson230411.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {MovieData.class}, version = 1)
public abstract class MovieBase extends RoomDatabase {
    public abstract MovieDao movieDao();
}

