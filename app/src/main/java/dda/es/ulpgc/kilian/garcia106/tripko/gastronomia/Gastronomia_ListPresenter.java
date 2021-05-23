package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Gastronomia_ListPresenter implements Gastronomia_ListContract.Presenter {

    public static String TAG = Gastronomia_ListPresenter.class.getSimpleName();

    private WeakReference<Gastronomia_ListContract.View> view;
    private Gastronomia_ListState state;
    private Gastronomia_ListContract.Model model;
    private AppMediator mediator;

    public Gastronomia_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getGastronomia_listState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new Gastronomia_ListState();
        }

        // call the model and update the state
        state.data = model.getStoredData();


    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");


        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }

    @Override
    public void injectView(WeakReference<Gastronomia_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Gastronomia_ListContract.Model model) {
        this.model = model;
    }

}
