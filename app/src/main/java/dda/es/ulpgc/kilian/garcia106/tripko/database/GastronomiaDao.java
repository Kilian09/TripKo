package dda.es.ulpgc.kilian.garcia106.tripko.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;

@Dao
public interface GastronomiaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGastronomia(GastronomiaItem category);

    @Update
    void updateGastronomia(GastronomiaItem category);

    @Delete
    void deleteGastronomia(GastronomiaItem category);

    @Query("SELECT * FROM gastronomias")
    List<GastronomiaItem> loadGastronomias();

    @Query("SELECT * FROM gastronomias WHERE id = :id LIMIT 1")
    GastronomiaItem loadGastronomia(int id);
}
