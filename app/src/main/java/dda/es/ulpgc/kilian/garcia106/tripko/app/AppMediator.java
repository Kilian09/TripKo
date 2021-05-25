package dda.es.ulpgc.kilian.garcia106.tripko.app;

import dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento.Category_EntretenimientoState;
import dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos.Category_Sitios_TuristicosState;
import dda.es.ulpgc.kilian.garcia106.tripko.ciudades_principales.Ciudades_PrincipalesState;
import dda.es.ulpgc.kilian.garcia106.tripko.clima.ClimaState;
import dda.es.ulpgc.kilian.garcia106.tripko.contactos_list.Contactos_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda.Conversor_MonedaState;
import dda.es.ulpgc.kilian.garcia106.tripko.cultura.CulturaState;
import dda.es.ulpgc.kilian.garcia106.tripko.data.CategoryEntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.EntretenimientoItem;
import dda.es.ulpgc.kilian.garcia106.tripko.data.GastronomiaItem;
import dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_detail.Entretenimiento_DetailState;
import dda.es.ulpgc.kilian.garcia106.tripko.entretenimiento_list.Entretenimiento_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.gastronomia.Gastronomia_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma.IdiomaState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_alfabeto.Idioma_AlfabetoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_coreano.Idioma_CoreanoState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_category.Idioma_Expresiones_CategoryState;
import dda.es.ulpgc.kilian.garcia106.tripko.idioma_expresiones_detail_list.Idioma_Expresiones_Detail_ListState;
import dda.es.ulpgc.kilian.garcia106.tripko.menu_principal.Menu_PrincipalState;
import dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_detail.Sitios_Turisticos_DetailState;
import dda.es.ulpgc.kilian.garcia106.tripko.sitios_turisticos_list.Sitios_Turisticos_ListState;
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

    private Gastronomia_ListState gastronomia_listState = new Gastronomia_ListState();

    private Transporte_CategoryState transporte_categoryState = new Transporte_CategoryState();
    private Transporte_SubcategoryState transporte_subcategoryState = new Transporte_SubcategoryState();
    private Transporte_Detail_ListState transporte_detail_listState = new Transporte_Detail_ListState();

    private GastronomiaItem gastronomia;

    private Sobre_CoreaState sobre_coreaState;

    private ClimaState climaState=new ClimaState();

    private CulturaState culturaState=new CulturaState();

    private Ciudades_PrincipalesState ciudades_principalesState=new Ciudades_PrincipalesState();

    private Category_EntretenimientoState category_entretenimientoState= new Category_EntretenimientoState();
    private Entretenimiento_ListState entretenimiento_listState=new Entretenimiento_ListState();
    private Entretenimiento_DetailState entretenimiento_detailState=new Entretenimiento_DetailState();

    private Category_Sitios_TuristicosState category_sitios_turisticosState=new Category_Sitios_TuristicosState();
    private Sitios_Turisticos_ListState sitios_turiscos_listState=new Sitios_Turisticos_ListState();
    private Sitios_Turisticos_DetailState sitios_turiscos_detailState=new Sitios_Turisticos_DetailState();

    private CategoryEntretenimientoItem categoryEntretenimientoItem;
    private EntretenimientoItem entretenimientoItem;

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

    public Gastronomia_ListState getGastronomia_listState() {
        return gastronomia_listState;
    }

    public void setGastronomia_listState(Gastronomia_ListState gastronomia_listState) {
        this.gastronomia_listState = gastronomia_listState;
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
        return sobre_coreaState;
    }

    public void setSobre_CoreaState(Sobre_CoreaState sobreCoreaState) {
        this.sobre_coreaState = sobreCoreaState;
    }

    public ClimaState getClimaState() { return  climaState; }

    public CulturaState getCulturaState() { return culturaState; }

    public Ciudades_PrincipalesState getCiudades_PrincipalesState() { return ciudades_principalesState;
    }

    public Category_EntretenimientoState getCategory_EntretenimientoState() {
        return category_entretenimientoState;
    }

    public void setCategory_EntretenimientoState(Category_EntretenimientoState category_entretenimientoState) {
        this.category_entretenimientoState= category_entretenimientoState;
    }

    public CategoryEntretenimientoItem getCategoryEntretenimientoItem() {
        return categoryEntretenimientoItem;
    }

    public void setCategoryEntretenimientoItem(CategoryEntretenimientoItem categoryEntretenimientoItem) {
        this.categoryEntretenimientoItem = categoryEntretenimientoItem;
    }

    public EntretenimientoItem getEntretenimientoItem() {
        return entretenimientoItem;
    }

    public void setEntretenimientoItem(EntretenimientoItem entretenimientoItem) {
        this.entretenimientoItem = entretenimientoItem;
    }

    public void setEntretenimiento_ListState(Entretenimiento_ListState entretenimiento_listState) {
    }

    public Entretenimiento_ListState getEntretenimiento_ListState() { return entretenimiento_listState;
    }

    public Entretenimiento_DetailState getEntretenimiento_DetailState() { return entretenimiento_detailState;
    }

    public GastronomiaItem getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(GastronomiaItem gastronomia) {
        this.gastronomia = gastronomia;
    }

    public void setCategory_Sitios_TuristicosState(Category_Sitios_TuristicosState category_sitios_turisticosState) {
        this.category_sitios_turisticosState=category_sitios_turisticosState;
    }

    public Sitios_Turisticos_ListState getSitios_Turisticos_ListState() { return sitios_turiscos_listState;
    }

    public void setSitios_Turisticos_ListState(Sitios_Turisticos_ListState sitios_turiscos_listState) {
        this.sitios_turiscos_listState=sitios_turiscos_listState;
    }

    public Sitios_Turisticos_DetailState getSitios_Turisticos_DetailState() { return sitios_turiscos_detailState;
    }
}
