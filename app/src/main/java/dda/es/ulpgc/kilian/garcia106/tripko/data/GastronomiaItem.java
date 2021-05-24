package dda.es.ulpgc.kilian.garcia106.tripko.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "gastronomias")
public class GastronomiaItem {

    @PrimaryKey
    public int id;

    public String title;

    @Ignore
    @SerializedName("restauantes")
    public List<RestauranteItem> itemsRestaurante;

    @Ignore
    @SerializedName("platos")
    public List<PlatoItem> itemsPlato;

    @Override
    public String toString() {
        return title;
    }
}
