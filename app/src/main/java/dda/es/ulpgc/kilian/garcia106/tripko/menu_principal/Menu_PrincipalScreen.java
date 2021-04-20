package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import dda.es.ulpgc.kilian.garcia106.tripko.R;
import dda.es.ulpgc.kilian.garcia106.tripko.app.AppMediator;

public class Menu_PrincipalScreen {

    public static void configure(Menu_PrincipalContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        AppMediator mediator = AppMediator.getInstance();

        Menu_PrincipalContract.Presenter presenter = new Menu_PrincipalPresenter(mediator);
        Menu_PrincipalContract.Model model = new Menu_PrincipalModel(data);
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}