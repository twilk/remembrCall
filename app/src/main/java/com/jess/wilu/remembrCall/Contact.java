package com.jess.wilu.remembrCall;

import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Contact {
	public String id;
	public String name;
	public ArrayList<ContactPhone> numbers;
	public SeekBar seekBar;
	public TextView progressValue;
	public Call recentCall;
	public long delay;
	public CheckBox remindCheckBox;

	private int progression = 0;
	private boolean checked = false;


	public Contact(String id, String name) {
		this.id = id;
		this.name = name;
		this.numbers = new ArrayList<ContactPhone>();
	}

	@Override
	public String toString() {
		String result = name;
		if (numbers.size() > 0) {
			ContactPhone number = numbers.get(0);
			result += " (" + number.number + " - " + number.type + ")";
		}

		return result;
	}


	public void addNumber(String number) {
		numbers.add(new ContactPhone(number));
	}

	public void setSeekBarListener(final TextView progressionBarText){
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				Log.i("taaaab", String.valueOf(i));
				progressionBarText.setText(""+i);
				setProgression(i);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {


			}
		});
	}

	public void setCheckBoxListener(){
		remindCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				setChecked(b);
			}
		});
	}

	public void setRecentCall(Call call) {
		this.recentCall = call;

	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}


	public void initializeContact(){
		this.setSeekBarListener(this.progressValue);
		this.setCheckBoxListener();
	}
	public void setSeekBar(SeekBar seekBar){
		this.seekBar = seekBar;
	}
	public void setCheckBox(CheckBox checkBox){
		this.remindCheckBox = checkBox;
	}
	public void setProgressValue(TextView progressValue ){
		this.progressValue = progressValue;
	}

	public String getName(){
		return name;
	}
}
