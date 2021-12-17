package com.jashcodes.expense_manager_test



import android.content.BroadcastReceiver
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add_transaction.*

class MyAdater : RecyclerView.Adapter<MyAdater.MyViewHolder>() {



    private var translist:ArrayList<Model> = ArrayList()
    private var onClickItem:((Model)-> Unit)?=null





    fun additems(items:ArrayList<Model>)
    {
        this.translist = items
        this.notifyDataSetChanged()
        }

    fun setOnItemClick(callback:(Model)->Unit)
    {
        this.onClickItem  = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=MyViewHolder (
 LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)

        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val a = translist[position]
        holder.bindView(a)

        holder.itemView.setOnClickListener{onClickItem?.invoke(a)}

    }


    override fun getItemCount(): Int {
return translist.size
    }


    class MyViewHolder(var view:View):RecyclerView.ViewHolder(view) {

        private var category= view.findViewById<TextView>(R.id.category_name)
        private var date = view.findViewById<TextView>(R.id.date_name)
        private  var amount = view.findViewById<TextView>(R.id.amount_name)
        private  var title = view.findViewById<TextView>(R.id.title_name)



        fun bindView(a:Model)
        {


            if(a.type=="Income")
            {
                amount.setTextColor(Color.parseColor("#558EFF"))

            }
            else
            {
                amount.setTextColor(Color.parseColor("#FD6255"))

            }

            category.text=a.category
            date.text=a.date
            amount.text="₹ "+a.amount.toString()
            title.text=a.title



    }
}


}

