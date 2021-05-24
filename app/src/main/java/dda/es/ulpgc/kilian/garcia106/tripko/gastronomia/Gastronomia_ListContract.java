package dda.es.ulpgc.kilian.garcia106.tripko.gastronomia;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public interface Gastronomia_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayGastronomiaListData(Gastronomia_ListViewModel viewModel);

        void navigateToMenuScreen();

    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();

        void navigateToMenuScreen();

        void selectGastronomiaListData(GastronomiaItem item);

        void fetchGastronomiaListData();
    }

    interface Model {

        void fetchGastronomiaListData(
                RepositoryContract.GetGastronomiaListCallback callback);
    }

}
