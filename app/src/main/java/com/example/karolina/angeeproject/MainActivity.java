package com.example.karolina.angeeproject;

import android.os.AsyncTask;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder headNotVisibleNotification;
    public static final int headNotVisibleId=1;
    NotificationCompat.Builder cryingNotification;
    private static final int cryingId=2;

   //public CommunicateWithPython interCommunication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //interCommunication=new CommunicateWithPython();
        //interCommunication.execute();

    }

    public void onSettingsClick(View view)
    {
        Intent goToSettings=new Intent(this,SettingsScreen.class);
        startActivity(goToSettings);
    }
    public void goToAngeeWeb(View view)
    {
        Intent goToWeb=new Intent(this,WebpageAngee.class);
        startActivity(goToWeb);
    }
    public void startHeadNotVisibleNotification(View view)
    {
        /*headNotVisibleNotification.setVibrate();*/
        headNotVisibleNotification=new NotificationCompat.Builder(this);
        //headNotVisibleNotification.setAutoCancel(true);
       /* Uri sound=Uri.parse("android.resource://")*/
        /*headNotVisibleNotification.setSound();*/
        headNotVisibleNotification.setSmallIcon(R.drawable.photo);
        headNotVisibleNotification.setContentTitle("DANGER!");
        headNotVisibleNotification.setContentText("HEAD NOT VISIBLE");

        Intent reportAlarm=new Intent(this,ReportAlarm.class);
        PendingIntent reportAlarmPendingIntent=PendingIntent.getActivity(this,0,reportAlarm,PendingIntent.FLAG_UPDATE_CURRENT);
        headNotVisibleNotification.setContentIntent(reportAlarmPendingIntent);

        NotificationManager headNotVisibleNM=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        headNotVisibleNM.notify(headNotVisibleId,headNotVisibleNotification.build());
    }
    public void startHeadNotVisibleNotification()
    {
        headNotVisibleNotification=new NotificationCompat.Builder(this);
        headNotVisibleNotification.setAutoCancel(true);
        headNotVisibleNotification.setSmallIcon(R.drawable.photo);
        headNotVisibleNotification.setContentTitle("DANGER!");
        headNotVisibleNotification.setContentText("HEAD NOT VISIBLE");

        Intent reportAlarm=new Intent(this,ReportAlarm.class);
        PendingIntent reportAlarmPendingIntent=PendingIntent.getActivity(this,0,reportAlarm,PendingIntent.FLAG_UPDATE_CURRENT);
        headNotVisibleNotification.setContentIntent(reportAlarmPendingIntent);

        NotificationManager headNotVisibleNM=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        headNotVisibleNM.notify(headNotVisibleId,headNotVisibleNotification.build());
    }
    public void startCryingNotification()
    {
        cryingNotification=new NotificationCompat.Builder(this);
        cryingNotification.setAutoCancel(true);
        cryingNotification.setSmallIcon(R.drawable.photo);
        cryingNotification.setContentTitle("CRYING!");
        cryingNotification.setContentText("BABY IS CRYING");

        Intent reportAlarm=new Intent(this,ReportAlarm.class);
        PendingIntent reportAlarmPendingIntent=PendingIntent.getActivity(this,0,reportAlarm,PendingIntent.FLAG_UPDATE_CURRENT);
        cryingNotification.setContentIntent(reportAlarmPendingIntent);

        NotificationManager cryingNM=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        cryingNM.notify(cryingId,cryingNotification.build());
    }

    public class CommunicateWithPython extends AsyncTask <Void, Void, Void>{

        public  String serverIP = "192.168.1.3";//rasberry Pi IP?
        public  int serverPort = 8074;//???
        Socket s;
        public DataInputStream dis=null;
        public int message;


        @Override
        protected Void doInBackground(Void... params) {

            try {
              s = new Socket(serverIP, serverPort);
            } catch (Exception e) {
                Log.i("AsyncTank", "doInBackgoung: Cannot create Socket");
            }
            if (s.isConnected()) {
                try {
                    dis = (DataInputStream) s.getInputStream();
                    if(dis!=null)
                    {
                       message = dis.readInt();
                       if(message==1)startHeadNotVisibleNotification();
                       if(message==2)startCryingNotification();
                       dis=null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            try {
                if (s.isConnected()){

                    dis.close();
                    s.close();
                }
            } catch (Exception e) {
                Log.i("onPostExecute", "socket not closed");
            }
        }
    }


}
