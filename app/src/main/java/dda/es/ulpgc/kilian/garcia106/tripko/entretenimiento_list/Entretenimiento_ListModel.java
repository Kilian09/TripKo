package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Entretenimiento_ListModel implements Entretenimiento_ListContract.Model {

    public static String TAG = Entretenimiento_ListModel.class.getSimpleName();

    private RepositoryContract repository;

    public Entretenimiento_ListModel(RepositoryContract repository) {
        this.repository = repository;
    }


    @Override
    public void fetchEntretenimientoListData(CategoryEntretenimientoItem category,
                                             RepositoryContract.GetEntretenimientoListCallback callback) {

        repository.getEntretenimientoList(category, callback);
    }
}