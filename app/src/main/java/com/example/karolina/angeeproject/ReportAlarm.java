package com.example.karolina.angeeproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ReportAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_alarm);
    }
    public void checkBoxClicked(View view)
    {
        boolean isChecked=((CheckBox)view).isChecked();
        TextView confirmationQuestion=(TextView)findViewById(R.id.confirmationQuestion);
        TextView falseAlarmButtonText=(TextView)findViewById(R.id.falseAlarmButton);
        if(isChecked)
        {
            confirmationQuestion.setText("Do you want to report false alarm? Please, confirm");
            falseAlarmButtonText.setText("CONFIRM");
        }
        else
        {
            confirmationQuestion.setText("");
            falseAlarmButtonText.setText("EXIT");
        }
    }
    public void buttonClicked(View view)
    {
        TextView falseAlarmButtonText=(TextView)findViewById(R.id.falseAlarmButton);
        if(falseAlarmButtonText.getText()=="CONFIRM")
        {
            /*send signal to Python*/
        }

        Intent goToMain=new Intent (this, MainActivity.class);
        startActivity(goToMain);


    }

}
