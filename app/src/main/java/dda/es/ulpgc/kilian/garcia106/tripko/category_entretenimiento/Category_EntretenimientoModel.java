package dda.es.ulpgc.kilian.garcia106.tripko.category_entretenimiento;

public class Category_EntretenimientoModel implements Category_EntretenimientoContract.Model {

    public static String TAG = Category_EntretenimientoModel.class.getSimpleName();

    private String data;

    public Category_EntretenimientoModel(String data) {
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