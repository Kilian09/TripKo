package dda.es.ulpgc.kilian.garcia106.tripko.app;

import dda.es.ulpgc.kilian.garcia106.tripko.contactos_list.Contactos_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma.IdiomaState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto.Idioma_AlfabetoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano.Idioma_CoreanoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category.Idioma_Expresiones_CategoryState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list.Idioma_Expresiones_Detail_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalState;

public class AppMediator {

    private static AppMediator INSTANCE;

    private Menu_PrincipalState menuPrincipalState = new Menu_PrincipalState();

    private IdiomaState idiomaState = new IdiomaState();
    private Idioma_AlfabetoState idioma_alfabetoState = new Idioma_AlfabetoState();
    private Idioma_CoreanoState idioma_coreanoState = new Idioma_CoreanoState();
    private Idioma_Expresiones_CategoryState expresiones_categoryState = new Idioma_Expresiones_CategoryState();
    private Idioma_Expresiones_Detail_ListState expresiones_detail_listState = new Idioma_Expresiones_Detail_ListState();

    private Contactos_ListState contactos_listState = new Contactos_ListState();

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

    public Idioma_AlfabetoState getIdioma_AlfabetoState() {
        return idioma_alfabetoState;
    }

    public void setIdioma_AlfabetoState(Idioma_AlfabetoState idioma_alfabetoState) {
        this.idioma_alfabetoState = idioma_alfabetoState;
    }

    public Idioma_CoreanoState getIdioma_CoreanoState() {
        return idioma_coreanoState;
    }

    public void setIdioma_CoreanoState(Idioma_CoreanoState idioma_coreanoState) {
        this.idioma_coreanoState = idioma_coreanoState;
    }

    public Idioma_Expresiones_CategoryState getIdioma_Expresiones_CategoryState() {
        return expresiones_categoryState;
    }

    public void setIdioma_Expresiones_CategoryState(Idioma_Expresiones_CategoryState expresiones_categoryState) {
        this.expresiones_categoryState = expresiones_categoryState;
    }

    public Idioma_Expresiones_Detail_ListState getIdioma_Expresiones_Detail_ListState() {
        return expresiones_detail_listState;
    }

    public void setIdioma_Expresiones_Detail_ListState(Idioma_Expresiones_Detail_ListState expresiones_detail_listState) {
        this.expresiones_detail_listState = expresiones_detail_listState;
    }

    public Contactos_ListState getContactos_ListState() {
        return contactos_listState;
    }

    public void setContactos_ListState(Contactos_ListState contactos_listState) {
        this.contactos_listState = contactos_listState;
    }
}
