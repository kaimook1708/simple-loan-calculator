package th.ac.su.ict.simple_loan_calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        var bth = intent.getDoubleExtra("calculate",0.0)

        tv01.text = bth.toFloat().toString()

        btn00.setOnClickListener {
            setResult(Activity.RESULT_OK,intent)

            finish()
        }

    }
}