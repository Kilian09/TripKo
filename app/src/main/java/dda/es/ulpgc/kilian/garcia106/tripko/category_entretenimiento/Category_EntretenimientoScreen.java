package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Category_EntretenimientoScreen {

    public static void configure(Category_EntretenimientoContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Category_EntretenimientoContract.Presenter presenter = new Category_EntretenimientoPresenter(mediator);
        Category_EntretenimientoContract.Model model = new Category_EntretenimientoModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
