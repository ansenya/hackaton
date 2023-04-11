package ru.packetSolution.hack.room;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {ItemEntity.class}, version = 1, exportSchema = true)
public abstract class Database extends RoomDatabase {
    public abstract ItemDao itemDao();
}
