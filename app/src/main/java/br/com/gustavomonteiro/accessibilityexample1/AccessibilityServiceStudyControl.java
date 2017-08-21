package br.com.gustavomonteiro.accessibilityexample1;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Gustavo on 17/08/2017.
 */

public class AccessibilityServiceStudyControl extends AccessibilityService {

    private final static String URL_BAR_ID = "com.android.chrome:id/url_bar";
    private final static String URL_TWITCHTV = "twitch.tv";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        performGlobalAction(GLOBAL_ACTION_HOME);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (!AccessibilityServiceManager.getInstance().getServiceStatus())
            return;

        String url;
        AccessibilityNodeInfo source = event.getSource();
        if (source != null) {
            AccessibilityNodeInfo root = findRoot(source);
            if (root != null) {
                AccessibilityNodeInfoCompat rootCompat = new AccessibilityNodeInfoCompat(root);
                List<AccessibilityNodeInfoCompat> urlBarList = rootCompat.findAccessibilityNodeInfosByViewId(URL_BAR_ID);
                if (urlBarList.size() > 0) {
                    url = urlBarList.get(0).getText().toString();
                    if (url.contains(URL_TWITCHTV)) {
                        performGlobalAction(GLOBAL_ACTION_HOME);
                    }
                }
            }
        }
    }

    @Override
    public void onInterrupt() {

    }

    private AccessibilityNodeInfo findRoot(AccessibilityNodeInfo node) {
        try {
            AccessibilityNodeInfo parent = node.getParent();
            if (parent == null) {
                return node;
            } else {
                return findRoot(parent);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
