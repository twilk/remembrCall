package com.jess.wilu.remembrCall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDisplay extends ArrayAdapter<Contact>{


	public ViewDisplay(Context context, ArrayList<Contact> contacts) {
		super(context, 0, contacts);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item
		Contact contact = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			view = inflater.inflate(R.layout.single_contact, parent, false);
		}
		// Populate the data into the template view using the data object
		TextView name = (TextView) view.findViewById(R.id.tvName);
		TextView phone = (TextView) view.findViewById(R.id.tvPhone);
		SeekBar contactSeekBar = (SeekBar) view.findViewById(R.id.contactSeekBar);
		TextView seekBarProgress = (TextView) view.findViewById(R.id.seekBarProgress);
		CheckBox checkBox = (CheckBox) view.findViewById(R.id.remindCheckBox);

		contact.setSeekBar(contactSeekBar);
		contact.setProgressValue(seekBarProgress);
		contact.setCheckBox(checkBox);
		contact.initializeContact();
		contactSeekBar.setProgress(contact.getProgression());
		seekBarProgress.setText(""+contact.getProgression());
		checkBox.setChecked(contact.isChecked());



		name.setText(contact.name);
		phone.setText("");

		if (contact.numbers.size() > 0 && contact.numbers.get(0) != null) {
			phone.setText(contact.numbers.get(0).number);
		}

		return view;
	}
}
