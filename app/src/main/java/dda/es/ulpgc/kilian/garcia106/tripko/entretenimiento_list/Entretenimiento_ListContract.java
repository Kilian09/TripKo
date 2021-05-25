package dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public interface Entretenimiento_ListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayProductListData(Entretenimiento_ListViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void selectEntretenimientoListData(EntretenimientoItem item);

        void fetchEntretenimientoListData();
    }

    interface Model {

        void fetchEntretenimientoListData(CategoryEntretenimientoItem category, RepositoryContract.GetEntretenimientoListCallback getEntretenimientoListCallback);
    }

}