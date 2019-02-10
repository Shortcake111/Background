package kdg.be.background

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txtView: TextView
    private lateinit var layout: ConstraintLayout
    private val backgrounds: IntArray = intArrayOf(
        Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE
    )
    private val foregrounds: IntArray = intArrayOf(
        Color.BLACK, Color.YELLOW, Color.MAGENTA,
        Color.WHITE
    )
    private var currentColorIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initilizeViews()
        addEventHandlers()
        applyColor()
    }

    private fun initilizeViews() {
        txtView = findViewById(R.id.bgTextView)
        layout = findViewById(R.id.layoutConstraintLayout)
    }

    private fun applyColor() {
        layout.setBackgroundColor(backgrounds[currentColorIndex])
        txtView.setTextColor(foregrounds[currentColorIndex])
    }

    private fun addEventHandlers(){
        layout.setOnClickListener {
            if (currentColorIndex < 3) {
                ++currentColorIndex
            } else {
                currentColorIndex = 0
            }
            applyColor()
        }
    }
}
