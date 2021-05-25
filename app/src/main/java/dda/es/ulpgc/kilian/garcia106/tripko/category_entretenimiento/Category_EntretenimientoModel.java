package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Category_EntretenimientoModel implements Category_EntretenimientoContract.Model {

    public static String TAG = Category_EntretenimientoModel.class.getSimpleName();

    private RepositoryContract repository;

    public Category_EntretenimientoModel(RepositoryContract repository) {
        this.repository = repository;
    }

    @Override
    public void fetchCategoryEntretenimientoListData(
            final RepositoryContract.GetCategoryEntretenimientoListCallback callback) {

        repository.loadCategoryEntretenimiento(new RepositoryContract.FetchCategoryEntretenimientoDataCallback(){
            @Override
            public void onCategoryEntretenimientoDataFetched(boolean error){
                if(!error){
                    repository.getCategoryEntretenimientoList(callback);
                }
            }
        });

    }
}