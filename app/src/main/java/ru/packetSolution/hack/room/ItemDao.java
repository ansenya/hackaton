package ru.packetSolution.hack.room;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract interface ItemDao {

    @Query("SELECT * FROM ItemEntity")
    List<ItemEntity> getAll();

    @Query("SELECT * FROM ItemEntity WHERE id=:id")
    List<ItemEntity> getById(long id);

    @Insert
    void save(ItemEntity item);

    @Query("DELETE FROM ItemEntity WHERE id = :id")
    void deleteByUserId(long id);

    @Query("DELETE FROM ItemEntity")
    void clearData();
}
