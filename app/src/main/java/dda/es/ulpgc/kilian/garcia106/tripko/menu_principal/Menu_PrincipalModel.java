package dda.es.ulpgc.kilian.garcia106.tripko.menu_principal;

public class Menu_PrincipalModel implements Menu_PrincipalContract.Model {

    public static String TAG = Menu_PrincipalModel.class.getSimpleName();

    private String data;

    public Menu_PrincipalModel(String data) {
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