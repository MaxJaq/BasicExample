package fr.esilv.tutorial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
	
	private boolean isShown;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		Intent intent = getIntent();
		isShown = intent.getBooleanExtra("IS_SHOWN", false);
		final TextView textView = findViewById(R.id.textView);
		textView.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
		final Button button = findViewById(R.id.button);
		button.setText(isShown ? R.string.hide : R.string.show);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				isShown = !isShown;
				textView.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
				button.setText(isShown ? R.string.hide : R.string.show);
				Intent intent = new Intent();
				intent.putExtra("IS_SHOWN", isShown);
				setResult(Activity.RESULT_OK, intent);
			}
		});
	}
}
