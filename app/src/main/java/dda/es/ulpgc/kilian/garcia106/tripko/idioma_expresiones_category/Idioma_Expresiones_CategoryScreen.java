package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_Expresiones_CategoryScreen {

    public static void configure(Idioma_Expresiones_CategoryContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Idioma_Expresiones_CategoryContract.Presenter presenter = new Idioma_Expresiones_CategoryPresenter(mediator);
        Idioma_Expresiones_CategoryContract.Model model = new Idioma_Expresiones_CategoryModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}