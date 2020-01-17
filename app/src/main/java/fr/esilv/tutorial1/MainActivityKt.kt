package fr.esilv.tutorial1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.next
import kotlinx.android.synthetic.main.activity_main.nextWithResult
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivityKt : AppCompatActivity() {
	companion object {
		private const val NEXT_REQUEST_CODE = 0
		private const val IS_SHOWN = "IS_SHOWN"
	}

	private var isShown = false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		button.setOnClickListener {
			isShown = !isShown
			textView.visibility = if (isShown) View.VISIBLE else View.INVISIBLE
			button.setText(if (isShown) R.string.hide else R.string.show)
		}

		next.setOnClickListener {
			val intent = Intent(this, NextActivityKt::class.java)
			intent.putExtra(IS_SHOWN, isShown)
			startActivity(intent)
		}

		nextWithResult.setOnClickListener {
			val intent = Intent(this, NextActivityKt::class.java)
			intent.putExtra(IS_SHOWN, isShown)
			startActivityForResult(intent, NEXT_REQUEST_CODE)
		}
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		if (requestCode == NEXT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
			isShown = data?.getBooleanExtra(IS_SHOWN, false) ?: false
			textView.visibility = if (isShown) View.VISIBLE else View.INVISIBLE
			button.setText(if (isShown) R.string.hide else R.string.show)
		} else {
			super.onActivityResult(requestCode, resultCode, data)
		}
	}
}