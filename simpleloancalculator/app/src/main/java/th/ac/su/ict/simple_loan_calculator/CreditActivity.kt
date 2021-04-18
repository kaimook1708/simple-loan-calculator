package th.ac.su.ict.simple_loan_calculator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_credit.*
import th.ac.su.ict.simple_loan_calculator.Utils.getJsonDataFromAsset
import th.ac.su.ict.simple_loan_calculator.data.Loan
import th.ac.su.ict.simple_loan_calculator.data.SimpleAdapter

class CreditActivity : AppCompatActivity() {
    var itemList:ArrayList<Loan> = ArrayList<Loan>()
    lateinit var arrayAdapter: ArrayAdapter<Loan>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)


        val jsonFileString =
            getJsonDataFromAsset(applicationContext, "promotion.json")


        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Loan>>() {}.type

        var FoodloverList: ArrayList<Loan> = gson.fromJson(jsonFileString, listItemType)

        itemList = FoodloverList

        val adapter = SimpleAdapter(this@CreditActivity, itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            listView.setOnClickListener {
                setResult(Activity.RESULT_OK, intent)

                finish()
            }
        }
    }
}