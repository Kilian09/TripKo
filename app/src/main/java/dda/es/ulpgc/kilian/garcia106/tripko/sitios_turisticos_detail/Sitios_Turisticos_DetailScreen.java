package dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_detail;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Sitios_Turisticos_DetailScreen {

    public static void configure(Sitios_Turisticos_DetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Sitios_Turisticos_DetailContract.Presenter presenter = new Sitios_Turisticos_DetailPresenter(mediator);
        Sitios_Turisticos_DetailContract.Model model = new Sitios_Turisticos_DetailModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
