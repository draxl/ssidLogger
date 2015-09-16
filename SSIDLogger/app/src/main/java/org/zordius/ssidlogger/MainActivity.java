package org.zordius.ssidlogger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread() {
			@Override
			public void run() {
				syncStatus();
				bindDone();
			}
		}.start();
	}

	public void bindDone() {
		// handle set logfile
		((EditText) findViewById(R.id.editFilename))
				.setOnEditorActionListener(new EditText.OnEditorActionListener() {
					public boolean onEditorAction(TextView v, int actionId,
												  KeyEvent event) {
						if (actionId == EditorInfo.IME_ACTION_DONE) {
							if (!WifiReceiver.setLogFile(v.getContext(),
									((EditText) v).getText().toString())) {
								syncStatus();
							}
						}
						return false;
					}
				});

		// handle comment
		((EditText) findViewById(R.id.editComment))
				.setOnEditorActionListener(new EditText.OnEditorActionListener() {
					public boolean onEditorAction(TextView v, int actionId,
												  KeyEvent event) {
						if (actionId == EditorInfo.IME_ACTION_SEND) {
							doComment();
							return true;
						}
						return false;
					}
				});
	}

	public void syncStatus() {
		((ToggleButton) findViewById(R.id.logSwitch)).setChecked(WifiReceiver
				.isEnabled(this));
		((EditText) findViewById(R.id.editFilename))
				.setText(WifiReceiver.getLogFileName(this),
						TextView.BufferType.EDITABLE);

		((TextView) findViewById(R.id.textLFree))
				.setText(WifiReceiver.getFreeSize() + "MB");
	}

	public void onClickLog(View v) {
		((ToggleButton) findViewById(R.id.activeSwitch)).setEnabled(!((ToggleButton) v).isChecked());
		WifiReceiver.toggleScan(this, ((ToggleButton) v).isChecked());
	}

	public void onClickActive(View v) {
		WifiReceiver.activeScan = !WifiReceiver.activeScan;
	}

	public void onClickScan(View v) {
		WifiReceiver.doScan(this);
	}

	public void doComment() {
		EditText cmt = (EditText) findViewById(R.id.editComment);
		WifiReceiver.writeLog(this, "COMMENT " + cmt.getText().toString());
		cmt.setText("", TextView.BufferType.EDITABLE);
	}
}
