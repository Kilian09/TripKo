package dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;
import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;
import dda.es.ulpgc.kilian.garcia106.tripko.data.TripkoRepository;

public class Conversor_MonedaScreen {

    public static void configure(Conversor_MonedaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();
        RepositoryContract repository = TripkoRepository.getInstance(context.get());


        Conversor_MonedaContract.Presenter presenter = new Conversor_MonedaPresenter(mediator);
        Conversor_MonedaContract.Model model = new Conversor_MonedaModel(repository);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}