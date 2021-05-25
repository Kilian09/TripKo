package dda.es.ulpgc.kilian.garcia106.tripko.category_sitios_turisticos;

public class Category_Sitios_TuristicosModel implements Category_Sitios_TuristicosContract.Model {

    public static String TAG = Category_Sitios_TuristicosModel.class.getSimpleName();

    private String data;

    public Category_Sitios_TuristicosModel(String data) {
        this.data = data;
    }

    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}