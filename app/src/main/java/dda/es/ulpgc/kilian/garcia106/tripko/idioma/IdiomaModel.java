package dda.es.ulpgc.kilian.garcia106.tripko.idioma;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class IdiomaModel implements IdiomaContract.Model {

    public static String TAG = IdiomaModel.class.getSimpleName();

    private RepositoryContract repository;

    public IdiomaModel(RepositoryContract repository) {
        this.repository = repository;
    }
}