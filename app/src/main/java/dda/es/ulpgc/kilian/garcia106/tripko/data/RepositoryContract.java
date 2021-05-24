package dda.es.ulpgc.kilian.garcia106.tripko.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchGastronomiaDataCallback {
        void onGastronomiaDataFetched(boolean error);
    }

    interface GetGastronomiaListCallback {
        void setGastronomiaList(List<GastronomiaItem> gastronomias);
    }

    interface GetGastronomiaCallback {
        void setGastronomia(GastronomiaItem category);
    }

    void loadGastronomia(
            boolean clearFirst, TripkoRepository.FetchGastronomiaDataCallback callback);

    void getGastronomiaList(RepositoryContract.GetGastronomiaListCallback  callback);

}
