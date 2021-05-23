package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

public class GastronomiaItem {

    public int id;

    public String title;


    public List<RestauranteItem> itemsRestaurante;
    public List<PlatoItem> itemsPlato;

    @Override
    public String toString() {
        return title;
    }
}
