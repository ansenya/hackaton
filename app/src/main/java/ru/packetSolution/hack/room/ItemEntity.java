package ru.packetSolution.hack.room;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ItemEntity {
    @PrimaryKey(autoGenerate = true)
    long id;
    int drawablePic; //временно
    String pathForImage;
    String tags;
    String text;
    String money;
    String geo;
    String path;

    public int getDrawablePic() {
        return drawablePic;
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    @Ignore
    public ItemEntity(int drawablePic, String text) {
        this.drawablePic = drawablePic;
        this.text = text;
    }


    public ItemEntity(String path, String text) {
        this.path = path;
        this.text = text;
    }
}
