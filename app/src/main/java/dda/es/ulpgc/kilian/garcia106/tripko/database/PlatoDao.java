package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.data.PlatoItem;

@Dao
public interface PlatoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlato(PlatoItem product);

    @Update
    void updatePlato(PlatoItem product);

    @Delete
    void deletePlato(PlatoItem product);

    @Query("SELECT * FROM platos")
    List<PlatoItem> loadPlatos();

    @Query("SELECT * FROM platos WHERE id = :id LIMIT 1")
    PlatoItem loadPlato(int id);

    @Query("SELECT * FROM platos WHERE gastronomia_id=:categoryId")
    List<PlatoItem> loadPlatos(final int categoryId);

}
