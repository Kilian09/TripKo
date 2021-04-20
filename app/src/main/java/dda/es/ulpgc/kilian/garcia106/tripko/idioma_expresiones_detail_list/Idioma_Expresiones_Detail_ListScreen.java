package dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Idioma_Expresiones_Detail_ListScreen {

    public static void configure(Idioma_Expresiones_Detail_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Idioma_Expresiones_Detail_ListContract.Presenter presenter = new Idioma_Expresiones_Detail_ListPresenter(mediator);
        Idioma_Expresiones_Detail_ListContract.Model model = new Idioma_Expresiones_Detail_ListModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}