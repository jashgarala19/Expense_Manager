package com.jashcodes.expense_manager_test

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import java.lang.Exception


val DATABASE_NAME = "ExpressManagerDB"
val TABLE_NAME = "Transactions"
val COL_DATE = "Date"
val COL_AMOUNT= "Amount"
val COL_CATEGORY = "Category"
val COL_TITLE = "Title"
val COL_DESCRIPTION = "Description"
val COL_TRANS_TYPE="Type"
val COL_TRANSACTIONID = "TransID"





val TABLE_NAME2="All_Amount"
val COL_INCOME="Income"
val COL_EXPENSE="Expense"
val COL_TOTAL = "Total"

val COL_AMOUNT_TYPE="Amount_Type"



class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        Log.d("db","created db")


val context=this
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_TRANSACTIONID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_DATE + " VARCHAR(256)," +
                COL_CATEGORY + " VARCHAR(256)," +
                COL_TITLE + " VARCHAR(256)," +
                COL_DESCRIPTION + " VARCHAR(256)," +
                COL_TRANS_TYPE +" VARCHAR(256)," +
                COL_AMOUNT + " DOUBLE)"

//
//        val createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (" +
//                COL_AMOUNT_TYPE + " VARCHAR(256)," +
//                COL_AMOUNT + " DOUBLE)"


        val createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (" +
                COL_INCOME+ " DOUBLE," +
                COL_EXPENSE+ " DOUBLE," +
                COL_TOTAL + " DOUBLE)"






        p0?.execSQL(createTable)
        p0?.execSQL(createTable2)


//        val insertamount="INSERT INTO All_Amount (Amount_Type,Amount)\n" +
//                "VALUES ('Income',0.0);"
//        val insertamount2="INSERT INTO All_Amount (Amount_Type,Amount)\n" +
//                "VALUES ('Expense',0.0);"
//        val insertamount3="INSERT INTO All_Amount (Amount_Type,Amount)\n" +
//                "VALUES ('Total',0.0);"


        val insertamount="INSERT INTO All_Amount (Income,Expense,Total)\n" +
                "VALUES (0.0,0.0,0.0);"

        p0?.execSQL(insertamount)
//        p0?.execSQL(insertamount2)
//        p0?.execSQL(insertamount3)



    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(t:Tranaction)

    {

        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_DATE,t.date)
        cv.put(COL_CATEGORY,t.category)
        cv.put(COL_TITLE,t.title)
        cv.put(COL_DESCRIPTION,t.description)
        cv.put(COL_TRANS_TYPE,t.type)
        cv.put(COL_AMOUNT,t.amount)

        var result=db.insert(TABLE_NAME,null,cv)
        if(result==-1.toLong())
        {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()

        }
        else
        {

            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }


    }



//    fun readdata(): Amount {
//
//
//
//        val db  = this.readableDatabase
//        val query = "select * from "+ TABLE_NAME2 +" where "+ COL_AMOUNT_TYPE +" = " + COL_INCOME
//        val cursor:Cursor= db.rawQuery(query,null)
//
//        val am = Amount()
//
//
//              val index:Int= cursor.getColumnIndex(COL_AMOUNT)
//                am.Income_Amount=cursor.getString(index).toDouble()
//
//
//
//        cursor.close()
//        return am
//
//    }

//    fun viewtransactiondata(): Cursor {
//        val db  = this.readableDatabase
//        val query = "select * from "+ TABLE_NAME
//        val cursor:Cursor= db.rawQuery(query,null)
//        return cursor
//
//    }

    fun viewtransactiondata():ArrayList<Model>
    {
        val list:ArrayList<Model> = ArrayList()
        val selectQuery= "select * from $TABLE_NAME"
        val cursor:Cursor?
        val db=this.readableDatabase

        try {
            cursor=db.rawQuery(selectQuery,null)

        }
        catch (e:Exception)
        {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return  ArrayList()
        }

        var category:String
        var title:String
        var amount:Double
        var date:String
        var type:String
        var transactionid:Int
        if(cursor.moveToFirst())
        {
            do {
                val index2:Int= cursor.getColumnIndex(COL_CATEGORY)
                category=cursor.getString(index2).toString()

                val index3:Int= cursor.getColumnIndex(COL_TITLE)
                title=cursor.getString(index3).toString()

                val index1:Int= cursor.getColumnIndex(COL_DATE)
              date=cursor.getString(index1).toString()

                val index6:Int= cursor.getColumnIndex(COL_AMOUNT)
                amount=cursor.getString(index6).toDouble()

                val index5:Int=cursor.getColumnIndex(COL_TRANS_TYPE)
                type=cursor.getString(index5).toString()

                val index0:Int=cursor.getColumnIndex(COL_TRANSACTIONID)
                transactionid=cursor.getString(index0).toInt()


                val a = Model(date=date,category=category,title=title,amount=amount,type=type, transactionid = transactionid)
                list.add(a)




            }
                while (cursor.moveToNext())
        }
        return  list

    }

    fun readdata():MutableList<Amount>

    {

        var list :MutableList<Amount> = ArrayList()

        val db  = this.readableDatabase
        val query = "select * from "+ TABLE_NAME2
        val result:Cursor= db.rawQuery(query,null)

        if(result.moveToFirst())
        {

            do {
                var am=Amount()


                val index1:Int= result.getColumnIndex(COL_INCOME)
                am.Income_Amount=result.getString(index1).toDouble()

                val index2:Int=result.getColumnIndex(COL_EXPENSE)
                am.Expense_Amount=result.getString(index2).toDouble()

                val index3:Int=result.getColumnIndex(COL_TOTAL)
                am.Total_Amount=result.getString(index3).toDouble()

                list.add(am)//we have only one row so actually we do not need list

            }
            while (result.moveToNext())
        }
        result.close()
        return list
    }

    fun updatedata(flag:Int,income:Double,expense:Double,total:Double,user_amount:Double): MutableList<Double> {

      var mylist:MutableList<Double> = ArrayList()
        var add:Double=0.0
        var sub:Double=0.0
        var tot:Double=0.0

        val db = this.writableDatabase
        val query = "select * from "+ TABLE_NAME2

        val result = db.rawQuery(query,null)

        if(result.moveToFirst())
        {
            do {

                val index3:Int=result.getColumnIndex(COL_TOTAL)
                if(flag==1)
                {
                    var cv = ContentValues()
                    val index1:Int= result.getColumnIndex(COL_INCOME)



                    cv.put(COL_INCOME,income+user_amount)
                    add=income+user_amount
                    cv.put(COL_TOTAL,total+user_amount)
                    tot=total+user_amount


                    db.update(TABLE_NAME2,cv,"Income"+" = ?", arrayOf(result.getString(index1)))
                    db.update(TABLE_NAME2,cv,"Total"+" = ?", arrayOf(result.getString(index3)))


                    mylist.add(add)
                    mylist.add(sub)
                    mylist.add(tot)

                }
                else if(flag==0)
                {
                    var cv = ContentValues()
                    val index2:Int= result.getColumnIndex(COL_EXPENSE)

                    var am=Amount()

                    cv.put(COL_EXPENSE,expense-user_amount)
                    sub = expense-user_amount
                    cv.put(COL_TOTAL,total-user_amount)
                    tot=total-user_amount


                    db.update(TABLE_NAME2,cv,"Expense"+" = ?", arrayOf(result.getString(index2)))
                    db.update(TABLE_NAME2,cv,"Total"+" = ?", arrayOf(result.getString(index3)))

                    mylist.add(add)
                    mylist.add(sub)
                    mylist.add(tot)

                }








            }


                while (result.moveToNext())
        }

        return mylist

    }





//
//
//    fun readdata():MutableList<Amount>
//
//    {
//
//        var list :MutableList<Amount> = ArrayList()
//
//        val db  = this.readableDatabase
//        val query = "select * from "+ TABLE_NAME
//        val result:Cursor= db.rawQuery(query,null)
//
//        if(result.moveToFirst())
//        {
//
//            do {
//                var am=Amount()
//
//
//                val index:Int= result.getColumnIndex(COL_AMOUNT)
//                am.amount=result.getString(index).toDouble()
//
//                list.add(am)
//
//            }
//            while (result.moveToNext())
//        }
//        result.close()
//        return list
//    }




}