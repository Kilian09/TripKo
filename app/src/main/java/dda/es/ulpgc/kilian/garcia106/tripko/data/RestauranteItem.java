package dda.es.ulpgc.kilian.garcia106.tripko.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(
        tableName = "restaurantes",
        foreignKeys = @ForeignKey(
                entity = GastronomiaItem.class,
                parentColumns = "id",
                childColumns = "gastronomia_id",
                onDelete = CASCADE
        )
)
public class RestauranteItem {

    @PrimaryKey
    public int id;

    public String title;
    public String content;
    public String picture;

    @ColumnInfo(name = "gastronomia_id")
    public int gastronomiaId;


    @Override
    public String toString() {
        return title;
    }
}
