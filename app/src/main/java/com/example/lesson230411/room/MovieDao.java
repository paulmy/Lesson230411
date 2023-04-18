package com.example.lesson230411.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {

        @Query("SELECT * FROM moviedata")
        List<MovieData> getAll();

        @Query("SELECT * FROM moviedata WHERE title like:search or title like :search")
        List<MovieData> getFromLike(String search);

        @Insert
        void insertAll(MovieData... productData);

        @Delete
        void delete(MovieData productData);

        //@Update
        //void update(MovieData productData);




}
