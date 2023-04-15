package ru.packetSolution.hack.room;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import ru.packetSolution.hack.views.InputField;

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
    String description;
    int price;
    public int getDrawablePic() {
        return drawablePic;
    }

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {return price;}

    public ItemEntity(int drawablePic, String text, String description, int price) {
        this.drawablePic = drawablePic;
        this.text = text;
        this.description = description;
        this.price = price;
    }
    @Ignore
    public ItemEntity(String path, String text, String description, int price) {
        this.path = path;
        this.text = text;
        this.description = description;
        this.price = price;
    }
}
