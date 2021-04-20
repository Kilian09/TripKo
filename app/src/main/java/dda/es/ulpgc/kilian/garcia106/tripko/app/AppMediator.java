package dda.es.ulpgc.kilian.garcia106.tripko.app;

import dda.es.ulpgc.kilian.garcia106.tripko.idioma.IdiomaState;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalState;

public class AppMediator {

    private static AppMediator INSTANCE;

    private Menu_PrincipalState menuPrincipalState = new Menu_PrincipalState();
    private IdiomaState idiomaState = new IdiomaState();

    private AppMediator() {
    }

    public static void resetInstance() {
        INSTANCE = null;
    }

    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }


    public Menu_PrincipalState getMenuPrincipalState() {
        return menuPrincipalState;
    }

    public void setMenuPrincipalState (Menu_PrincipalState menuPrincipalState){
        this.menuPrincipalState = menuPrincipalState;
    }

    public IdiomaState getIdiomaState() {
        return idiomaState;
    }

    public void setIdiomaState(IdiomaState idiomaState) {
        this.idiomaState = idiomaState;
    }
}
