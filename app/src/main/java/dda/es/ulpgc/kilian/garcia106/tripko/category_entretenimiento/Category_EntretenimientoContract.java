package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public interface Category_EntretenimientoContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCategoryListData(Category_EntretenimientoViewModel viewModel);

        void navigateToEntretenimientoScreen();

        void navigateToMenuScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void navigateToEntretenimientoScreen();

        void selectCategoryEntretenimientoListData(CategoryEntretenimientoItem item);

        void fetchCategoryListData();

        void navigateToMenuScreen();
    }

    interface Model {

        void fetchCategoryEntretenimientoListData(RepositoryContract.GetCategoryEntretenimientoListCallback getCategoryEntretenimientoListCallback);
    }

}