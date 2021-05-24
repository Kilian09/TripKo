package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import java.lang.ref.WeakReference;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

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

    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");


        // update the view
        view.get().displayGastronomiaListData(state);

    }

    @Override
    public void fetchGastronomiaListData() {

        // call the model
        model.fetchGastronomiaListData(new RepositoryContract.GetGastronomiaListCallback() {

            @Override
            public void setGastronomiaList(List<GastronomiaItem> gastronomias) {
                state.gastronomias = gastronomias;

                view.get().displayGastronomiaListData(state);
            }
        });
    }

    @Override
    public void selectGastronomiaListData(GastronomiaItem item) {
        passDataToGastronomiaListScreen(item);
        view.get().navigateToMenuScreen();
    }

    private void passDataToGastronomiaListScreen(GastronomiaItem item) {
        mediator.setGastronomia(item);
    }

    @Override
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
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
