package com.jashcodes.expense_manager_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_add_transaction.*
import kotlinx.android.synthetic.main.fragment_account_type_.cancel_button
import kotlinx.android.synthetic.main.fragment_category_type_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Category_type_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Category_type_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_type_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        cancel_button.setOnClickListener{
//
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//
//
//
//
//
//        }
//
//
//
//        category_1.setOnClickListener{
//
//            (activity as Add_Transaction?)?.setcategorytype("Grocery")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_2.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Clothing")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//
//        category_3.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Travel")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_4.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Rent")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_5.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Education")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_6.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Food")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_7.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Medical")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_8.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Entertainment")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_9.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Business")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_10.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Shopping")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_11.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Transport")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_12.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Home")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_13.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Car")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_14.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Family&Personel")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_15.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Gift")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_16.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("HealthCare")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_17.setOnClickListener{
//            (activity as Add_Transaction?)?.setcategorytype("Other")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }






    }
//    fun my_fun()
//    {
//
//
//
//        activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//
//
//
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Category_type_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Category_type_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}