package com.example.karolina.angeeproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ReportAlarm extends AppCompatActivity {


    //public SendToPython sendToPythonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_alarm);
       // sendToPythonObject=new SendToPython();
       // sendToPythonObject.execute();
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

            //sendToPythonObject.writeToStream(3);
        }

        Intent goToMain=new Intent (this, MainActivity.class);
        startActivity(goToMain);


    }
    public class SendToPython extends AsyncTask<Void, Void, Void> {

        public  String serverIP = "";//rasberry Pi IP?
        public  int serverPort = 8074;//???
        Socket s;
        public DataOutputStream dos=null;

        @Override
        protected Void doInBackground(Void... params) {

            try {
                s = new Socket(serverIP, serverPort);
            } catch (Exception e) {
                Log.i("AsyncTank", "doInBackgoung: Cannot create Socket");
            }
            if (s.isConnected()) {
                try {
                    dos = (DataOutputStream) s.getOutputStream();
                    }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
        public void writeToStream(int sendMessage) {
            try {
                if (s.isConnected()){

                    dos.writeInt(sendMessage);
                    dos.close();
                    s.close();
                                    }
            } catch (Exception e) {
                Log.i("AsynkTask", "writeToStream : Writing failed");
            }
        }


    }


}
