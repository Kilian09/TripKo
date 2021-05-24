package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.PlatoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RestauranteItem;

@Database(entities = {GastronomiaItem.class, PlatoItem.class, RestauranteItem.class}, version = 1)
public abstract class TripkoDatabase extends RoomDatabase {

    public abstract GastronomiaDao gastronomiaDao();
    public abstract PlatoDao platoDao();
    public abstract RestauranteDao restauranteDao();
}
