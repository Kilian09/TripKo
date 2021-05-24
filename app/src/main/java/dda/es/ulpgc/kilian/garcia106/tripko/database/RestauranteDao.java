package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RestauranteItem;

@Dao
public interface RestauranteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRestaurante(RestauranteItem product);

    @Update
    void updateRestaurante(RestauranteItem product);

    @Delete
    void deleteRestaurante(RestauranteItem product);

    @Query("SELECT * FROM restaurantes")
    List<RestauranteItem> loadRastaurantes();

    @Query("SELECT * FROM restaurantes WHERE id = :id LIMIT 1")
    RestauranteItem loadRestaurante(int id);

    @Query("SELECT * FROM restaurantes WHERE gastronomia_id=:categoryId")
    List<RestauranteItem> loadRestaurantes(final int categoryId);


}
