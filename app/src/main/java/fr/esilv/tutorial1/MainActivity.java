package fr.esilv.tutorial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	private static final int NEXT_REQUEST_CODE = 0;
	private boolean isShown = true;
	private TextView textView;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = findViewById(R.id.textView);
		button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				isShown = !isShown;
				textView.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
				button.setText(isShown ? R.string.hide : R.string.show);
			}
		});
		
		Button next = findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NextActivity.class);
				intent.putExtra("IS_SHOWN", isShown);
				startActivity(intent);
			}
		});
		
		Button nextWithResult = findViewById(R.id.nextWithResult);
		nextWithResult.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NextActivity.class);
				intent.putExtra("IS_SHOWN", isShown);
				startActivityForResult(intent, NEXT_REQUEST_CODE);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == NEXT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
			isShown = data.getBooleanExtra("IS_SHOWN", false);
			textView.setVisibility(isShown ? View.VISIBLE : View.INVISIBLE);
			button.setText(isShown ? R.string.hide : R.string.show);
		} else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
}
