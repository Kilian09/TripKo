package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sitios_Turisticos_ListScreen {

    public static void configure(Sitios_Turisticos_ListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Sitios_Turisticos_ListContract.Presenter presenter = new Sitios_Turisticos_ListPresenter(mediator);
        Sitios_Turisticos_ListContract.Model model = new Sitios_Turisticos_ListModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
