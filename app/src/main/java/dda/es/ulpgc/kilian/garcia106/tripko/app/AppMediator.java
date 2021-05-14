package dda.es.ulpgc.kilian.garcia106.tripko.app;

import dda.es.ulpgc.kilian.garcia106.tripko.clima.ClimaState;
import dda.es.ulpgc.kilian.garcia106.tripko.contactos_list.Contactos_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda.Conversor_MonedaState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma.IdiomaState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto.Idioma_AlfabetoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano.Idioma_CoreanoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category.Idioma_Expresiones_CategoryState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list.Idioma_Expresiones_Detail_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalState;
import dda.es.ulpgc.kilian.garcia106.tripko.sobre_corea.Sobre_CoreaState;
import dda.es.ulpgc.kilian.garcia106.tripko.transporte_category.Transporte_CategoryState;
import dda.es.ulpgc.kilian.garcia106.tripko.transporte_detail_list.Transporte_Detail_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.transporte_subcategory.Transporte_SubcategoryState;

public class AppMediator {

    private static AppMediator INSTANCE;

    private Menu_PrincipalState menuPrincipalState = new Menu_PrincipalState();

    private IdiomaState idiomaState = new IdiomaState();
    private Idioma_AlfabetoState idioma_alfabetoState = new Idioma_AlfabetoState();
    private Idioma_CoreanoState idioma_coreanoState = new Idioma_CoreanoState();
    private Idioma_Expresiones_CategoryState expresiones_categoryState = new Idioma_Expresiones_CategoryState();
    private Idioma_Expresiones_Detail_ListState expresiones_detail_listState = new Idioma_Expresiones_Detail_ListState();

    private Contactos_ListState contactos_listState = new Contactos_ListState();

    private Conversor_MonedaState conversor_monedaState = new Conversor_MonedaState();

    private Transporte_CategoryState transporte_categoryState = new Transporte_CategoryState();
    private Transporte_SubcategoryState transporte_subcategoryState = new Transporte_SubcategoryState();
    private Transporte_Detail_ListState transporte_detail_listState = new Transporte_Detail_ListState();

    private Sobre_CoreaState sobreCoreaState;

    private ClimaState climaState;

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

    public Transporte_CategoryState getTransporte_CategoryState() {
        return transporte_categoryState;
    }

    public void setTransporte_CategoryState(Transporte_CategoryState transporte_categoryState) {
        this.transporte_categoryState = transporte_categoryState;
    }

    public Transporte_SubcategoryState getTransporte_SubcategoryState() {
        return transporte_subcategoryState;
    }

    public void setTransporte_SubcategoryState(Transporte_SubcategoryState transporte_subcategoryState) {
        this.transporte_subcategoryState = transporte_subcategoryState;
    }

    public Transporte_Detail_ListState getTransporte_Detail_ListState() {
        return transporte_detail_listState;
    }

    public void setTransporte_Detail_ListState(Transporte_Detail_ListState transporte_detail_listState) {
        this.transporte_detail_listState = transporte_detail_listState;
    }

    public Conversor_MonedaState getConversor_MonedaState() {
        return conversor_monedaState;
    }

    public void setConversor_MonedaState(Conversor_MonedaState conversor_monedaState) {
        this.conversor_monedaState = conversor_monedaState;
    }

    public Sobre_CoreaState getSobre_CoreaState() {
        return sobreCoreaState;
    }

    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) {
        this.sobreCoreaState = sobreCoreaState;
    }

    public ClimaState getClimaState() { return  climaState; }
}
