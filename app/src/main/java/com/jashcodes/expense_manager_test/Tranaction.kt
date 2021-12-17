package com.jashcodes.expense_manager_test

class Tranaction {

    var id:Int = 0
    var date :String =""
    var amount:Double?= 0.0
    var category:String=""
    var title:String=""
    var description:String=""
    var type:String=""

    constructor(date:String, category:String, title:String, description:String,type:String , amount: Double?)
    {

        this.date=date
        this.amount=amount
        this.category=category
        this.title=title
        this.description=description
        this.type=type
   }
    constructor()
    {

    }
//    constructor(title:String,category:String)
//    {
//
//        this.title=title
//        this.description=description
//
//    }

}