package dda.es.ulpgc.kilian.garcia106.tripko.data;

import java.util.List;

public interface RepositoryContract {

    interface FetchCategoryEntretenimientoDataCallback {
        void onCategoryEntretenimientoDataFetched(boolean error);
    }

    interface GetEntretenimientoListCallback {
        void setEntretenimientoList(List<EntretenimientoItem> entretenimientos);
    }

    interface GetEntretenimientoCallback {
        void setEntretenimiento(EntretenimientoItem entretenimiento);
    }

    interface GetCategoryEntretenimientoListCallback {
        void setCategoryEntretenimientoList(List<CategoryEntretenimientoItem> categoriesEntretenimiento);
    }

    interface GetCategoryEntretenimientoCallback {
        void setCategoryEntretenimiento(CategoryEntretenimientoItem category);
    }


    void loadCategoryEntretenimiento(RepositoryContract.FetchCategoryEntretenimientoDataCallback callback);

    void getEntretenimientoList(
            CategoryEntretenimientoItem categoryEntretenimiento,RepositoryContract.GetEntretenimientoListCallback callback);

    void getEntretenimientoList(
            int categoryEntretenimientoId, RepositoryContract.GetEntretenimientoListCallback callback);

    void getEntretenimiento(int id, RepositoryContract.GetEntretenimientoCallback callback);
    void getCategoryEntretenimiento(int id, RepositoryContract.GetCategoryEntretenimientoCallback callback);
    void getCategoryEntretenimientoList(RepositoryContract.GetCategoryEntretenimientoListCallback callback);

    //------------------------------------------------------------------------------------------------------//


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
