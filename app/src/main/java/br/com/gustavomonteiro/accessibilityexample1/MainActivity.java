package br.com.gustavomonteiro.accessibilityexample1;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switchStatus);
        switchCompat.setChecked(AccessibilityServiceManager.getInstance().getServiceStatus());
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()) {
                    AccessibilityServiceManager.getInstance().setServiceStatus(true);
                } else {
                    AccessibilityServiceManager.getInstance().setServiceStatus(false);
                }
            }
        });

        Button button = (Button) findViewById(R.id.buttonToSettings);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
            }
        });
    }
}
