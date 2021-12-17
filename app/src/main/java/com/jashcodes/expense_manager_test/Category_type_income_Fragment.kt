package com.jashcodes.expense_manager_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_account_type_.*
import kotlinx.android.synthetic.main.fragment_account_type_.cancel_button
import kotlinx.android.synthetic.main.fragment_category_type_.*
import kotlinx.android.synthetic.main.fragment_category_type_income_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Category_type_income_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Category_type_income_Fragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_category_type_income_, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        cancel_button.setOnClickListener{
//
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//
//
//        category_18.setOnClickListener{
//
//            (activity as Add_Transaction?)?.setcategorytype("Business")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//
//        category_19.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Loan")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_20.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Insuarance")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_21.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Rent")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_22.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Salary")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_23.setOnClickListener {
//            (activity as Add_Transaction?)?.setcategorytype("Gift")
//            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
//            (activity as Add_Transaction?)?.cancelpressed(0)
//        }
//        category_24.setOnClickListener {
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
         * @return A new instance of fragment Category_type_income_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Category_type_income_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}