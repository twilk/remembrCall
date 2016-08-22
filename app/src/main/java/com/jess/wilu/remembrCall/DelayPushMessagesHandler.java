package com.jess.wilu.remembrCall;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by traveler on 06.05.16.
 */
public class DelayPushMessagesHandler {

    ArrayList<Contact> listContacts = new ArrayList<>();
    final int dayInMilisec = 1000*60*60*24;
    final int minuteInMilisec = 60*1000;

    public  DelayPushMessagesHandler(ArrayList listContacts){
        this.listContacts = listContacts;
    }

    public void fetchDates(Context context){
        Date currentDate = new Date();
        for (Contact c: listContacts) {
            if(c!=null && c.numbers!=null &&c.numbers.size()>0) {
                Long timeBetween;

                if(c.recentCall==null){
                    c.recentCall=new Call();
                }
                timeBetween = currentDate.getTime() - c.recentCall.getDate().getTime();


                c.setDelay(timeBetween);

                if(c.isChecked()){
                    Log.i("longCall", c.name + " " + c.delay + " od ostatniej rozmowy "+ (c.getProgression()*(1000)));
                    String tittle = "Zadzwoń do " + c.getName();
                    String message = "Dzwoniłeś dawniej niż "+ c.getProgression() + " dni temu";
                    String number = "" ;
                    if (c.numbers.size() > 0 && c.numbers.get(0) != null) {
                        number = c.numbers.get(0).number;
                    }

                    if(c.getDelay() > c.getProgression()*minuteInMilisec){
                        Log.i("longCall", message);
                        new AlarmBroadcaster(context,tittle , message, number, c.id).setAlarmBroadcast(0);
                    } else {
                        Log.i("longCall", "dzwoniłeś do " + c.name + " zadzwoń za " + (c.getProgression()-(c.getDelay()/minuteInMilisec)));
                        new AlarmBroadcaster(context, tittle, message,number, c.id)
                                .setAlarmBroadcast((int) (c.getProgression()-(c.getDelay()/minuteInMilisec)));
                    }

                } else {
                    new AlarmBroadcaster(context).cancelAlarm(c.id);

                }


            }
        }

    }

    public class AlarmBroadcaster {
        private Context context;
        private PendingIntent reminderBroadcastIntent;

        public  AlarmBroadcaster(Context context){
            this.context = context;
        }
        public AlarmBroadcaster(Context context, String tittle, String message, String phoneNumber, String id) {
            this.context = context;
            Intent intent = new Intent(context, AlarmReceiver.class);
            intent.putExtra("tittle", tittle);
            intent.putExtra("message", message);
            intent.putExtra("id", id);
            intent.putExtra("phoneNumber", phoneNumber);
            reminderBroadcastIntent = PendingIntent.getBroadcast(context, Integer.parseInt(id), intent, PendingIntent.FLAG_UPDATE_CURRENT);

        }

        public void setAlarmBroadcast(int minutes){
            
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE,  minutes);
            long when = c.getTimeInMillis();
            
            AlarmManager alarmToBroadcast = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            alarmToBroadcast.set(AlarmManager.RTC_WAKEUP, when, reminderBroadcastIntent);
        }
        public void cancelAlarm(String id){
            AlarmManager alarmToCancel = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntentToCancel = PendingIntent.getBroadcast(context, Integer.parseInt(id), intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmToCancel.cancel(pendingIntentToCancel);

        }
    }



}
