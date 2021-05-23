package dda.es.ulpgc.kilian.garcia106.tripko.database;

public class PlatoItem {
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
