package dda.es.ulpgc.kilian.garcia106.tripko.data;

import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryEntretenimientoItem {

    public int id;

    public String title;

    @SerializedName("entretenimientos")
    public List<EntretenimientoItem> items;

    public String toString() {
        return title;
    }
}
