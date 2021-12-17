package com.jashcodes.expense_manager_test


import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle

import android.util.Log
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.widget.*

import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var Income_Amount = 0.0
    var Expense_Amount = 0.0
    var Total_Amount = 0.0
//    val list = mutableListOf<Model>()
    val context:Context=this

    private lateinit var recyclerView: RecyclerView
    private lateinit var db:DataBaseHandler
    private var adapter:MyAdater?=null


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val listView = findViewById<ListView>(R.id.listviewtrans)
        db = DataBaseHandler(this)

        initView()
        initRecyclerView()

        viewtransdata()

        adapter?.setOnItemClick {
            Toast.makeText(this,it.transactionid.toString(),Toast.LENGTH_SHORT).show()

//            Intent(this, Add_Transaction::class.java).apply {
//
//                startActivity(this)
//
//
//                Log.d("test", "ok")
//
//
//            }

        }

        val context = this
        val db = DataBaseHandler(context)
        val data = db.readdata()
        val db_income_amount: Double = data.get(0).Income_Amount
        val db_expense_amount: Double = data.get(0).Expense_Amount
        val db_Total_amount: Double = data.get(0).Total_Amount


        Income_Amount = db_income_amount
        Expense_Amount = db_expense_amount
        Total_Amount = db_Total_amount

        incomevalue.text = "₹ " + Income_Amount.toString()
        expensevalue.text = "₹ " + Expense_Amount.toString()
        totalvalue.text = "₹ " + Total_Amount.toString()


        val Bottomnavigationview = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        Bottomnavigationview?.selectedItemId = R.id.home
        Bottomnavigationview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Intent(this, MainActivity::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.calendar -> {
                    Intent(this, Calendar::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.stats -> {
                    Intent(this, Stats::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0)
                    }
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Intent(this, Settings::class.java).apply {
                        startActivity(this)
                        overridePendingTransition(0, 0)
                    }
                    return@setOnItemSelectedListener true
                }
            }


        }

        //open add_transaction activity
        floatingActionButton.setOnClickListener {
            Intent(this, Add_Transaction::class.java).apply {

                startActivity(this)


                Log.d("test", "ok")


            }


        }

////        listView.setOnItemClickListener(OnItemClickListener { parent, v, position, id ->
//        Toast.makeText(applicationContext,position.toString(),Toast.LENGTH_SHORT).show()
//
////            Intent(this, Add_Transaction::class.java).apply {
////
////                startActivity(this)
////
////
////                Log.d("test", "ok")
////
////
////            }
//
//
//
//
//
//        })


    }




    private fun viewtransdata() {
//        val listView = findViewById<ListView>(R.id.listviewtrans)


        val mylist= db.viewtransactiondata()
        Log.e("pppp","${mylist.size}")
        if(mylist.size==0)
        {
//            Toast.makeText(this,"No data to show",Toast.LENGTH_SHORT).show()

            textviewnotrans.visibility= View.VISIBLE
        }
        else
        {
            textviewnotrans.visibility= View.GONE
        }
        adapter?.additems(mylist)


    }
    private fun initRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdater()
        recyclerView.adapter = adapter

    }

    private fun initView() {

        recyclerView=findViewById(R.id.recyclerView)
    }

    override fun onStart() {
        Log.d("onstart", "started")


        super.onStart()

        val context = this
        val db = DataBaseHandler(context)
        val data = db.readdata()
        val db_income_amount: Double = data.get(0).Income_Amount
        val db_expense_amount: Double = data.get(0).Expense_Amount
        val db_Total_amount: Double = data.get(0).Total_Amount



        Income_Amount = db_income_amount
        Expense_Amount = db_expense_amount
        Total_Amount = db_Total_amount

        incomevalue.text = "₹ " + Income_Amount.toString()
        expensevalue.text = "₹ " + Expense_Amount.toString()
        totalvalue.text ="₹ " +  Total_Amount.toString()

//list.clear()
        viewtransdata()

    }


}

