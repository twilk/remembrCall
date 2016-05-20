package com.jess.wilu.remembrCall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.pushbots.push.Pushbots;

public class MainActivity extends Activity {

	final static Handler contactHandler = new Handler();
	final static Handler h = new Handler();

	static ArrayList<Contact> listContacts;
	ListView contactsListView;
	ContactLoader contactLoader;
	ArrayList<Contact> localContacts;
	ArrayList<Contact> localStorage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clearHandlers();
		contactLoader = new ContactLoader(MainActivity.this);
		checkRestoreAndRestore();
		contactsListView = (ListView) findViewById(R.id.allContactsDisplay);
		ViewDisplay viewDisplay = new ViewDisplay(this, listContacts);
		contactsListView.setAdapter(viewDisplay);

	}

	private void checkRestoreAndRestore() {
		localContacts = contactLoader.loadContactsAndCalls();

		localStorage=restoreState();
		if(localStorage!=null){
			Log.i("restoreProcess", "startingRestoreProcess");
			for(Contact localStorageContact:localStorage){
				if(localStorageContact!=null){
					Contact tempContact = contactLoader.contactsMap.get(localStorageContact.id);
					if (tempContact!= null){
						tempContact.setProgression(localStorageContact.getProgression());
						tempContact.setChecked(localStorageContact.isChecked());
						contactLoader.contactsMap.put(localStorageContact.id, tempContact);
					}

				}
			}
		}
		listContacts=localContacts;

		Log.i("restoreProcess", "Finished");

	}

	@Override
	protected void onStart() {
		super.onStart();
		h.removeCallbacksAndMessages(null);
		contactHandler.removeCallbacksAndMessages(null);

		Button remindMeButton = (Button) findViewById(R.id.remindConfirmButton);
		remindMeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				saveState();
				restoreState();
				contactLoader.getCallDetails(getApplicationContext());
				contactLoader.setContactCalls(contactLoader.contactsMap, contactLoader.callsMap);
				new DelayPushMessagesHandler(listContacts).fetchDates(getApplicationContext());
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i("restoreProcess", "onPause");

		final int delay = 20000; //how often do we queue notifications

		contactHandler.postDelayed(new Runnable() {

			public void run() {
				contactLoader.getCallDetails(MainActivity.this);
				contactLoader.setContactCalls(contactLoader.contactsMap, contactLoader.callsMap);
				checkRestoreAndRestore();
				new DelayPushMessagesHandler(listContacts).fetchDates(getApplicationContext());
				contactHandler.postDelayed(this, delay);
			}
		}, delay);

		if(!Pushbots.sharedInstance().isInitialized())
		{
			Pushbots.sharedInstance().init(this);
		}

	}


	@Override
	protected void onRestart() {
		super.onRestart();
		clearHandlers();
		Log.i("restoreProcess", "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("restoreProcess", "onResume");
		clearHandlers();
		checkRestoreAndRestore();
		contactsListView = (ListView) findViewById(R.id.allContactsDisplay);
		ViewDisplay viewDisplay = new ViewDisplay(this, listContacts);
		contactsListView.setAdapter(viewDisplay);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		contactLoader.getCallDetails(MainActivity.this);
		contactLoader.setContactCalls(contactLoader.contactsMap, contactLoader.callsMap);
		checkRestoreAndRestore();
		new DelayPushMessagesHandler(listContacts).fetchDates(getApplicationContext());
		Log.i("restoreProcess", "onDestroy");



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void clearHandlers(){
		h.removeCallbacksAndMessages(null);
		contactHandler.removeCallbacksAndMessages(null);
	}


	public void saveState(){
		FileOutputStream fOut;
		try {
			fOut = openFileOutput("contactData",MODE_PRIVATE);
			String str = "";
			for(Contact c: listContacts){
				if(c!=null){
					str+=c.id + "{" + c.getName() + "{";
					if ( c.numbers!=null && c.numbers.size()>0){
						str+= c.numbers.get(0).number+"{";
					} else {
						str+=" {";
					}
					str+=c.getProgression()+"{"+c.isChecked()+"{;"+"\n";
				}
			}
			fOut.write(str.getBytes());
			fOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Contact> restoreState(){
		ArrayList<Contact> localStorageContacts = new ArrayList<>();

		FileInputStream fileInputStream;
		try {
			fileInputStream = openFileInput("contactData");
			int c;
			String temp="";

			while( (c = fileInputStream.read()) != -1){

				String id = Character.toString((char)c);
				c = fileInputStream.read();
				while(!Character.toString((char)c).contains("{")){
					id += Character.toString((char)c);
					c = fileInputStream.read();
				}
				c = fileInputStream.read();
				String name = "";
				while(!Character.toString((char)c).contains("{")){
					name += Character.toString((char)c);
					c = fileInputStream.read();
				}
				c = fileInputStream.read();
				String number = "";
				while(!Character.toString((char)c).contains("{")){
					number += Character.toString((char)c);
					c = fileInputStream.read();
				}
				c = fileInputStream.read();
				String progress = "";
				while(!Character.toString((char)c).contains("{")){
					progress += Character.toString((char)c);
					c = fileInputStream.read();
				}
				c = fileInputStream.read();
				String checked = "";
				while(!Character.toString((char)c).contains("{")){
					checked += Character.toString((char)c);
					c = fileInputStream.read();
				}
				fileInputStream.read();
				fileInputStream.read();

				Log.i("fileContaining", "id:" + id + " name:"+name+" number:"+number +" progress:"+progress + " checked:"+ checked);

				Contact newContact = new Contact(id, name);
				newContact.addNumber(number);
				newContact.setChecked(Boolean.parseBoolean(checked));
				newContact.setProgression(Integer.parseInt(progress));
				localStorageContacts.add(newContact);
			}

			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return localStorageContacts;
	}

}
