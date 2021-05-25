package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import java.lang.ref.WeakReference;
import java.util.List;

import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Category_EntretenimientoPresenter implements Category_EntretenimientoContract.Presenter {

    public static String TAG = Category_EntretenimientoPresenter.class.getSimpleName();

    private WeakReference<Category_EntretenimientoContract.View> view;
    private Category_EntretenimientoState state;
    private Category_EntretenimientoContract.Model model;
    private AppMediator mediator;

    public Category_EntretenimientoPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategory_EntretenimientoState();
    }

    @Override
    public void fetchCategoryListData() {

        model.fetchCategoryEntretenimientoListData(new RepositoryContract.GetCategoryEntretenimientoListCallback() {

            @Override
            public void setCategoryEntretenimientoList(List<CategoryEntretenimientoItem> categoriesEntretenimiento) {
                state.categories = categoriesEntretenimiento;
                view.get().displayCategoryListData(state);
            }
        });
    }

    @Override
    public void navigateToMenuScreen() {
        view.get().navigateToMenuScreen();
    }

    @Override
    public void navigateToEntretenimientoScreen() {
        view.get().navigateToEntretenimientoScreen();
    }

    @Override
    public void selectCategoryEntretenimientoListData(CategoryEntretenimientoItem item) {
        passDataToEntretenimientoScreen(item);
        navigateToEntretenimientoScreen();
    }

    private void passDataToEntretenimientoScreen(CategoryEntretenimientoItem categoryEntretenimientoItem) {
        mediator.setCategoryEntretenimientoItem(categoryEntretenimientoItem);
    }


    @Override
    public void injectView(WeakReference<Category_EntretenimientoContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(Category_EntretenimientoContract.Model model) {
        this.model = model;
    }

}
