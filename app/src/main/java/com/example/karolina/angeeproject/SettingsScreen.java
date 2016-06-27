package com.example.karolina.angeeproject;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class SettingsScreen extends AppCompatActivity {

    private Switch musicSwitch;
    private Switch LEDSwitch;
    private TextView musicSwitchText;
    private TextView LEDSwitchText;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        musicSwitch=(Switch)findViewById(R.id.musicSwitch);
        LEDSwitch=(Switch)findViewById(R.id.LEDSwitch);
        musicSwitchText=(TextView) findViewById(R.id.musicSwitch);
        LEDSwitchText=(TextView)findViewById(R.id.LEDSwitch);


        musicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    musicSwitchText.setText("Music disabled");
                    /*send notification to python-STOP MUSIC*/
                }
                else
                {
                    musicSwitchText.setText("Music enabled");
                }
            }

        });
        LEDSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    LEDSwitchText.setText("LED lights disabled");

                }
                else
                {
                    LEDSwitchText.setText("LED lights enabled");
                }
            }

        });


    }


}
