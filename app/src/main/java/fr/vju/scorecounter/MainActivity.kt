package fr.vju.scorecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    private var topCounter = 0
    private var bottomCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val insetController: WindowInsetsControllerCompat = WindowCompat.getInsetsController(window, window.decorView)
        insetController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        insetController.hide(WindowInsetsCompat.Type.statusBars())
        insetController.hide(WindowInsetsCompat.Type.systemBars())
        insetController.hide(WindowInsetsCompat.Type.navigationBars())


        val topCounter = findViewById<TextView>(R.id.TopCounter)
        val bottomCounter = findViewById<TextView>(R.id.BottomCounter)
        findViewById<Button>(R.id.TopLeftButton).setOnClickListener {
            this.topCounter = max(0, --this.topCounter)
            topCounter.text = toEnhancedString(this.topCounter);
        }
        findViewById<Button>(R.id.TopRightButton).setOnClickListener {
            topCounter.text = toEnhancedString(++this.topCounter);
        }
        findViewById<Button>(R.id.BottomLeftButton).setOnClickListener {
            this.bottomCounter = max(0, --this.bottomCounter)
            bottomCounter.text = toEnhancedString(this.bottomCounter);
        }
        findViewById<Button>(R.id.BottomRightButton).setOnClickListener {
            bottomCounter.text = toEnhancedString(++this.bottomCounter);
        }
        findViewById<Button>(R.id.ResetButton).setOnClickListener {
            this.topCounter = 0
            this.bottomCounter = 0
            topCounter.text = this.topCounter.toString()
            bottomCounter.text = this.bottomCounter.toString()
        }
    }

    private fun toEnhancedString(value: Int): String = when {
        value % 10 == 6 || value % 10 == 9 -> "$value."
        else -> value.toString()
    }
}