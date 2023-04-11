package ru.packetSolution.hack.room;

import androidx.room.Entity;
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

    public int getDrawablePic() {
        return drawablePic;
    }

    public String getText() {
        return text;
    }

    public ItemEntity(int drawablePic, String text) {
        this.drawablePic = drawablePic;
        this.text = text;
    }
}
