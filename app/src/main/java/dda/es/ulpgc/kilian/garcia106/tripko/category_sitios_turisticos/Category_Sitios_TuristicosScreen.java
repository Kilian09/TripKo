package dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Category_Sitios_TuristicosScreen {

    public static void configure(Category_Sitios_TuristicosContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Category_Sitios_TuristicosContract.Presenter presenter = new Category_Sitios_TuristicosPresenter(mediator);
        Category_Sitios_TuristicosContract.Model model = new Category_Sitios_TuristicosModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
