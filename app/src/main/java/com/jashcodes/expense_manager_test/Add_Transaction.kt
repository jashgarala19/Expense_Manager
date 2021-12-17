package com.jashcodes.expense_manager_test


import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_transaction.*
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.charset.MalformedInputException
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar


class Add_Transaction : AppCompatActivity() {

    private lateinit var tvDatePicker: TextView
    lateinit var weekDay: String
    private lateinit var etamount: EditText
    private lateinit var ettitle: EditText
    private lateinit var category: String
    private lateinit var etdesc: EditText
    var income_button_pressed = 0
    var expense_button_pressed = 1

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        expense_button_pressed = 1
        setContentView(R.layout.activity_add_transaction)
        setTitle("Add Transaction")
        etamount = findViewById(R.id.amount_edittext)
        ettitle = findViewById(R.id.title_et)
        etdesc = findViewById(R.id.editTextTextMultiLine)
        tvDatePicker = findViewById(R.id.tv_date)
        val myCalendar = Calendar.getInstance()
        val dayy = myCalendar.get(Calendar.DAY_OF_MONTH)
        val yearr = myCalendar.get(Calendar.YEAR)
        val monthh = myCalendar.get(Calendar.MONTH)
        val dayy_of_week = myCalendar.get(Calendar.DAY_OF_WEEK)
        if (Calendar.MONDAY == dayy_of_week) {
            weekDay = "Mon"
        } else if (Calendar.TUESDAY == dayy_of_week) {
            weekDay = "Tue"
        } else if (Calendar.WEDNESDAY == dayy_of_week) {
            weekDay = "Wed"
        } else if (Calendar.THURSDAY == dayy_of_week) {
            weekDay = "Thu"
        } else if (Calendar.FRIDAY == dayy_of_week) {
            weekDay = "Fri"
        } else if (Calendar.SATURDAY == dayy_of_week) {
            weekDay = "Sat"
        } else {
            weekDay = "Sun"
        }
        tvDatePicker.text = ("$dayy/$monthh/$yearr ($weekDay)")
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->

            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth)

            val dayofWeek = myCalendar.get(Calendar.DAY_OF_WEEK)
            if (Calendar.MONDAY == dayofWeek) {
                weekDay = "Mon"
            } else if (Calendar.TUESDAY == dayofWeek) {
                weekDay = "Tue"
            } else if (Calendar.WEDNESDAY == dayofWeek) {
                weekDay = "Wed"
            } else if (Calendar.THURSDAY == dayofWeek) {
                weekDay = "Thu"
            } else if (Calendar.FRIDAY == dayofWeek) {
                weekDay = "Fri"
            } else if (Calendar.SATURDAY == dayofWeek) {
                weekDay = "Sat"
            } else {
                weekDay = "Sun"
            }

            updateLable(myCalendar)

        }
        tv_date.setOnClickListener {
            DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        val items = resources.getStringArray(R.array.spinner1)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, items
        )
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                category = spinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        income_button.setOnClickListener {
            income_button_pressed = 1
            expense_button_pressed = 0
            val items = resources.getStringArray(R.array.spinner2)
            val arrayAdapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item, items
            )
            spinner.adapter = arrayAdapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    category = spinner.selectedItem.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
            expense_button.setTextColor(Color.parseColor("#C5C1C1"))
            expense_button.setBackgroundColor(Color.parseColor("#141417"))
            income_button.setTextColor(Color.parseColor("#1A1C20"))
            income_button.setBackgroundColor(Color.parseColor("#558EFF"))
            save_button.setBackgroundColor(Color.parseColor("#558EFF"))
            save_button.setTextColor(Color.parseColor("#1A1C20"))
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.parseColor("#558EFF"))
        }
        expense_button.setOnClickListener {
            expense_button.setTextColor(Color.parseColor("#1A1C20"))
            expense_button.setBackgroundColor(Color.parseColor("#FD6255"))
            income_button.setTextColor(Color.parseColor("#C5C1C1"))
            income_button.setBackgroundColor(Color.parseColor("#141417"))
            save_button.setTextColor(Color.parseColor("#1A1C20"))
            save_button.setBackgroundColor(Color.parseColor("#FD6255"))
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.parseColor("#FD6255"))
            val items = resources.getStringArray(R.array.spinner1)
            val arrayAdapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item, items
            )
            spinner.adapter = arrayAdapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    category = spinner.selectedItem.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
            expense_button_pressed = 1
            income_button_pressed = 0
        }
        save_button.setOnClickListener {

            val amount = etamount.text
            var numeric_amount = amount_edittext.getNumericValue()
            val title = ettitle.text.toString().trim()
            val description = etdesc.text.toString().trim()
            if (amount.isEmpty()) {
                amount_edittext.setError("Enter Amount")
                return@setOnClickListener
            } else if (title.isEmpty()) {
                title_et.setError("Title Required!!")
                return@setOnClickListener
            } else {

                var type: String = ""
                if (income_button_pressed == 1) {
                    type = "Income"
                } else if (expense_button_pressed == 1) {
                    type = "Expense"
                }
                var transaction = Tranaction(tvDatePicker.text.toString(), category, title, description, type, numeric_amount
                )
                var db = DataBaseHandler(context)
                db.insertData(transaction)
                val data = db.readdata()

                val db_income_amount: Double = data.get(0).Income_Amount
                val db_expense_amount: Double = data.get(0).Expense_Amount
                val db_Total_amount: Double = data.get(0).Total_Amount
                var flag = 0


                if (income_button_pressed == 1) {

                    flag = 1
                    if (numeric_amount != null) {
                        val updated_amount = db.updatedata(
                            flag,
                            db_income_amount,
                            db_expense_amount,
                            db_Total_amount,
                            numeric_amount
                        )
//                      textView7.text=  updated_amount[0].toString()+ " "+updated_amount[1].toString()+" "+updated_amount[2].toString()

//                        textView7.text = db_income_amount.toString()
//                        textView10.text=db_expense_amount.toString()
//                        textView11.text=db_Total_amount.toString()

                    }


                } else if (expense_button_pressed == 1) {
                    flag = 0
                    if (numeric_amount != null) {
                        val updated_amount = db.updatedata(
                            flag,
                            db_income_amount,
                            db_expense_amount,
                            db_Total_amount,
                            numeric_amount
                        )
//                       textView7.text=  updated_amount[0].toString()+" "+updated_amount[1].toString()+" "+updated_amount[2].toString()

//
//                        textView7.text = db_income_amount.toString()
//                        textView10.text=db_expense_amount.toString()
//                        textView11.text=db_Total_amount.toString()
                    }
                }


                //no need of loop bcz only one row
//                for (i in 0..data.size-1)
//                {
//                    textView7.append(data.get(i).amount.toString())
//                }


//                var data = db.readdata()
//
//                textView7.text=data.Income_Amount.toString()


                val toast = Toast.makeText(applicationContext, "Saved!!", Toast.LENGTH_SHORT)
                toast.show()
//
//                val a = Intent()
//                a.putExtra("result",0)
//                a.putExtra("result2",0)
//                a.putExtra("result3",0)
//                setResult(Activity.RESULT_OK, a)
                this.finish()
            }

        }

    }

//
//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        currentFocus?.let {
//            val imm: InputMethodManager = getSystemService(
//                Context.INPUT_METHOD_SERVICE
//            ) as (InputMethodManager)
//            imm.hideSoftInputFromWindow(it.windowToken, 0)
//        }
//        return super.dispatchTouchEvent(ev)
//    }
    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH)
        tvDatePicker.text = (sdf.format(myCalendar.time) + " (" + weekDay + ")")
    }
}

