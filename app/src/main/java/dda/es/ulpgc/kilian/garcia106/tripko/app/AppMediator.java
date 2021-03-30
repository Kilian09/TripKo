package dda.es.ulpgc.kilian.garcia106.tripko.app;

public class AppMediator {

    private static AppMediator INSTANCE;

    private AppMediatorState mAppMediatorState;

    private AppMediator() {
        mAppMediatorState = new AppMediatorState();
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

    public AppMediatorState getAppMediatorState() {
        return mAppMediatorState;
    }

    public NextToAppMediatorState getNextAppMediatorScreenState() {
        return null;
    }

    public void setNextAppMediatorScreenState(AppMediatorToNextState state) {

    }

    public void setPreviousAppMediatorScreenState(AppMediatorToPreviousState state) {

    }

    public PreviousToAppMediatorState getPreviousAppMediatorScreenState() {
        return null;
    }
}
