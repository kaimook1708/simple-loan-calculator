package th.ac.su.ict.simple_loan_calculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_credit.*
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.simple_loan_calculator.Utils.getJsonDataFromAsset
import th.ac.su.ict.simple_loan_calculator.data.Loan
import th.ac.su.ict.simple_loan_calculator.data.SimpleAdapter

class MainActivity : AppCompatActivity() {

    companion object{
        const val CHANGE = 1000

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var calculate = 0.0

        btn0.setOnClickListener {
            var b1 = edt.text.toString().toDouble()
            var b2 = edt2.text.toString().toDouble()
            var b3 = edt3.text.toString().toDouble()

            calculate = (b1+(b1*(b2/100)*b3)) / (b3*12)

            var intent = Intent(this@MainActivity,CalculateActivity::class.java)

            intent.putExtra("calculate",calculate)

            startActivityForResult(intent,CHANGE)

        }

        btn1.setOnClickListener {
            var intent = Intent(this@MainActivity,CreditActivity::class.java)


            startActivityForResult(intent,CHANGE)
        }



    }
}