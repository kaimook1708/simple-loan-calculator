package th.ac.su.ict.simple_loan_calculator.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_items.view.*
import th.ac.su.ict.simple_loan_calculator.R

class SimpleAdapter(private val context: Context,
                    private val dataSource:ArrayList<Loan>) : BaseAdapter(){


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_items,null)

        rowView.name01.text = dataSource[position].promo_name
        rowView.code01.text = dataSource[position].promo_code.toString()
        rowView.detail01.text = dataSource[position].promo_description



//        rowView.img.setImageResource(R.drawable.food01)

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.img.setImageResource(drawableId)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}