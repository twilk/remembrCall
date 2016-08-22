package com.jess.wilu.remembrCall;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.content.CursorLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContactLoader {

    private final Context context;
    final HashMap<String, ArrayList<Call>> callsMap = new HashMap<>();
    Map<String, Contact> contactsMap = new HashMap<>();

    public ContactLoader(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> loadContactsAndCalls() {
        getCallDetails(context);
        Log.i("LogDetails12", "aftercalldetails");

        String[] projectionFields = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,
        };
        ArrayList<Contact> listContacts = new ArrayList<>();
        CursorLoader cursorLoader = new CursorLoader(context,
                ContactsContract.Contacts.CONTENT_URI,
                projectionFields,
                null,
                null,
                null
        );

        Cursor contactsCursor = cursorLoader.loadInBackground();

        contactsMap = new HashMap<>(contactsCursor.getCount());
        Log.i("LogDetails12", "aftercursorloader");


        if (contactsCursor.moveToFirst()) {

            int idIndex = contactsCursor.getColumnIndex(ContactsContract.Contacts._ID);
            int nameIndex = contactsCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            int hasPhoneNumberIndex = contactsCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);

            do {

                    int hasPhoneNumber = contactsCursor.getInt(hasPhoneNumberIndex);
                    if(hasPhoneNumber == 1){

                    String contactId = contactsCursor.getString(idIndex);
                    String contactName = contactsCursor.getString(nameIndex);
                    Contact contact = new Contact(contactId, contactName);
                    contactsMap.put(contactId, contact);
                    listContacts.add(contact);

                    }

            } while (contactsCursor.moveToNext());
        }

        contactsCursor.close();

        setContactCalls(contactsMap, callsMap);
        Log.i("LogDetails12", "afterSetContactCalls");
        getContactNumbers(contactsMap);
        Log.i("LogDetails12", "afterMatchContactNumbers");
        return listContacts;
    }

    public void getContactNumbers(Map<String, Contact> contactsMap) {

        final String[] numberProjection = new String[]{
                Phone.NUMBER,
                Phone.CONTACT_ID,
        };

        Cursor phone = new CursorLoader(context,
                Phone.CONTENT_URI,
                numberProjection,
                null,
                null,
                null).loadInBackground();

        if (phone.moveToFirst()) {
            final int numberColumnIndex = phone.getColumnIndex(Phone.NUMBER);
            final int idColumnIndex = phone.getColumnIndex(Phone.CONTACT_ID);

            while (!phone.isAfterLast()) {
                final String number = phone.getString(numberColumnIndex);
                final String contactId = phone.getString(idColumnIndex);

                Contact contact = contactsMap.get(contactId);
                if (contact == null) {
                    continue;
                }
                contact.addNumber(number);
                phone.moveToNext();
            }
        }

        phone.close();
    }


    public void setContactCalls(Map<String, Contact> contactsMap, Map<String, ArrayList<Call>> callsMap){

        final String[] numberProjection = new String[]{
                Phone.NUMBER,
                Phone.CONTACT_ID,
        };

        Cursor phone = new CursorLoader(context,
                Phone.CONTENT_URI,
                numberProjection,
                null,
                null,
                null).loadInBackground();

        if (phone.moveToFirst()) {
            final int contactNumberColumnIndex = phone.getColumnIndex(Phone.NUMBER);
            final int contactIdColumnIndex = phone.getColumnIndex(Phone.CONTACT_ID);

            while (!phone.isAfterLast()) {
                final String numberBeforeConversion = phone.getString(contactNumberColumnIndex);
                final String contactId = phone.getString(contactIdColumnIndex);
                String number = numberBeforeConversion.replaceAll("\\D+","");

                Contact contact = contactsMap.get(contactId);
                ArrayList<Call> calls = callsMap.get(number);

                Call recentCall = new Call();
                if(calls != null) {
                    for (Call c : calls){
                        if(Integer.parseInt(c.getDuration()) > 0){
                            if(c.getDate().compareTo(recentCall.getDate())>0){
                                recentCall = c;
                            }
                        }
                    }
                }

                if (contact == null) {
                    continue;
                }

                contact.setRecentCall(recentCall);

                Log.i("TUTAJ numer+data", number +" --> "+ contact.recentCall.getDate());
                phone.moveToNext();
            }
        }

        phone.close();

    }

    public void getCallDetails(Context context) {
        Log.i("LogDetails12", "getCallDetails");

        final String[] numberProjection = new String[]{
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.DURATION,
                CallLog.Calls.CACHED_NAME,
        };

        Cursor callDetailsCursor = new CursorLoader(context,
                CallLog.Calls.CONTENT_URI,
                numberProjection,
                null,
                null,
                null).loadInBackground();

        int number = callDetailsCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int date = callDetailsCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = callDetailsCursor.getColumnIndex(CallLog.Calls.DURATION);
        int name = callDetailsCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);


        while (callDetailsCursor.moveToNext()) {
            String phNumber = callDetailsCursor.getString(number);
            String callDate = callDetailsCursor.getString(date);
            String contactName = callDetailsCursor.getString(name);
            Date callDateTime = new Date(Long.valueOf(callDate));
            String callDuration = callDetailsCursor.getString(duration);


            if(callsMap.get(phNumber) != null)
            {
                ArrayList<Call> calls = callsMap.get(phNumber);
                calls.add(new Call(callDateTime, callDuration, contactName));
                callsMap.put(phNumber, calls);

            } else {
                ArrayList<Call> calls = new ArrayList<>();
                calls.add(new Call(callDateTime, callDuration, contactName));
                callsMap.put(phNumber, calls);
            }

        }
        callDetailsCursor.close();

    }
}
