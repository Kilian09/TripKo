package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import java.lang.ref.WeakReference;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;
import dda.es.ulpgc.kilian.garcia106.tripko.data.TripkoRepository;

public class Entretenimiento_ListPresenter implements Entretenimiento_ListContract.Presenter {

    public static String TAG = Entretenimiento_ListPresenter.class.getSimpleName();

    private WeakReference<Entretenimiento_ListContract.View> view;
    private Entretenimiento_ListState state;
    private Entretenimiento_ListContract.Model model;
    private AppMediator mediator;

    public Entretenimiento_ListPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getEntretenimiento_ListState();
    }

    @Override
    public void fetchEntretenimientoListData() {
        // Log.e(TAG, "fetchEntretenimientoListData()");

        // set passed state
        CategoryEntretenimientoItem category = getDataFromCategoryEntretenimientoListScreen();

        if (category != null) {
            state.category = category;
        }

        // call the model
        model.fetchEntretenimientoListData(state.category,
                new RepositoryContract.GetEntretenimientoListCallback() {

                    @Override
                    public void setEntretenimientoList(List<EntretenimientoItem> entretenimientos) {
                        state.entretenimientos = entretenimientos;

                        view.get().displayProductListData(state);
                    }
                });

    }

    @Override
    public void selectEntretenimientoListData(EntretenimientoItem item) {

    }

    private CategoryEntretenimientoItem getDataFromCategoryEntretenimientoListScreen() {
        return mediator.getCategoryEntretenimientoItem();
    }

     private void passStateToNextScreen(Entretenimiento_ListState entretenimiento_listState) {
        mediator.setEntretenimiento_ListState(entretenimiento_listState);
    }

    @Override
    public void injectView(WeakReference<Entretenimiento_ListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Entretenimiento_ListContract.Model model) {
        this.model = model;
    }



}
