package dda.es.ulpgc.kilian.garcia106.tripko.transporte_subcategory;

public class Transporte_SubcategoryModel implements Transporte_SubcategoryContract.Model {

    public static String TAG = Transporte_SubcategoryModel.class.getSimpleName();

    private String data;

    public Transporte_SubcategoryModel(String data) {
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