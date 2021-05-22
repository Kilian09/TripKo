package dda.es.ulpgc.kilian.garcia106.tripko.data;

import android.content.Context;

public class TripkoRepository implements RepositoryContract {

    private static TripkoRepository INSTANCE;

    private Context context;

    public static RepositoryContract getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new TripkoRepository(context);
        }

        return INSTANCE;
    }

    private TripkoRepository(Context context) {
        this.context = context;



    }

}
