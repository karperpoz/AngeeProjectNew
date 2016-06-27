package com.example.karolina.angeeproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder headNotVisibleNotification;
    private static final int headNotVisibleId=1;
    NotificationCompat.Builder cryingNotification;
    private static final int cryingId=2;

   /* public CommunicateWithPython interCommunication;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*interCommunication=new CommunicateWithPython();*/
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
        headNotVisibleNotification.setAutoCancel(true);
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
    public void startCryingNotification(View view)
    {
        /*headNotVisibleNotification.setSound();*/
        /*headNotVisibleNotification.setVibrate();*/
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
}
