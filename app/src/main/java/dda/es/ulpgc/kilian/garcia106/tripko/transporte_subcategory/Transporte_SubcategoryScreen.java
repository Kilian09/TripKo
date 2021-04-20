package dda.es.ulpgc.kilian.garcia106.tripko.transporte_subcategory;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Transporte_SubcategoryScreen {

    public static void configure(Transporte_SubcategoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Transporte_SubcategoryContract.Presenter presenter = new Transporte_SubcategoryPresenter(mediator);
        Transporte_SubcategoryContract.Model model = new Transporte_SubcategoryModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}