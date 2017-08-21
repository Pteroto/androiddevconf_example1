package br.com.gustavomonteiro.accessibilityexample1;

/**
 * Created by Gustavo on 20/08/2017.
 */

public class AccessibilityServiceManager {

    private static AccessibilityServiceManager instance;
    private boolean serviceStatus = false;

    private AccessibilityServiceManager() {}

    public static AccessibilityServiceManager getInstance() {
        if (instance == null) {
            instance = new AccessibilityServiceManager();
        }

        return instance;
    }

    public void setServiceStatus(boolean status) {
        serviceStatus = status;
    }

    public boolean getServiceStatus() {
        return serviceStatus;
    }
}
