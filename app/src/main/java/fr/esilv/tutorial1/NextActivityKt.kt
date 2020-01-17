package fr.esilv.tutorial1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_next.button
import kotlinx.android.synthetic.main.activity_next.textView

class NextActivityKt : AppCompatActivity() {
	companion object {
		const val IS_SHOWN = "IS_SHOWN"
	}

	private var isShown = false
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_next)
		val intent = intent
		isShown = intent.getBooleanExtra(IS_SHOWN, false)
		textView.visibility = if (isShown) View.VISIBLE else View.INVISIBLE
		button.setText(if (isShown) R.string.hide else R.string.show)
		button.setOnClickListener {
			isShown = !isShown
			textView.visibility = if (isShown) View.VISIBLE else View.INVISIBLE
			button.setText(if (isShown) R.string.hide else R.string.show)
			val intent = Intent()
			intent.putExtra(IS_SHOWN, isShown)
			setResult(Activity.RESULT_OK, intent)
		}
	}
}