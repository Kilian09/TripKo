package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import android.util.Log;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Gastronomia_ListModel implements Gastronomia_ListContract.Model {

    public static String TAG = Gastronomia_ListModel.class.getSimpleName();

    private RepositoryContract repository;

    public Gastronomia_ListModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchGastronomiaListData(
            final RepositoryContract.GetGastronomiaListCallback callback) {

        Log.e(TAG, "fetchCategoryListData()");

        repository.loadGastronomia(
                true, new RepositoryContract.FetchGastronomiaDataCallback() {

                    @Override
                    public void onGastronomiaDataFetched(boolean error) {
                        if(!error) {
                            repository.getGastronomiaList(callback);
                        }
                    }
                });

    }
}