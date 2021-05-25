package dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Idioma_CoreanoModel implements Idioma_CoreanoContract.Model {

    public static String TAG = Idioma_CoreanoModel.class.getSimpleName();


    private RepositoryContract repository;

    public Idioma_CoreanoModel(RepositoryContract repository) {
        this.repository = repository;
    }
}