package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class RestauranteItem {

    public int id;

    public String title;
    public String content;
    public String picture;


    public int gastronomiaId;


    @Override
    public String toString() {
        return title;
    }
}
