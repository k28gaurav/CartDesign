package com.gaurav.cartsystem.app.cart

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseFragment
import kotlinx.android.synthetic.main.fragment_library.*
import java.lang.RuntimeException
import javax.inject.Inject

class LibraryFragment @Inject constructor(): DaggerBaseFragment<LibraryViewModel>() {

    enum class NextFrag {
        ALL_DISCOUNT, ALL_ITEMS
    }

    private lateinit var changeFragmentListener: ChangeFragmentListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is ChangeFragmentListener) {
            changeFragmentListener = context
        } else {
            throw RuntimeException("Must implement ChangeFragmentListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_library, container)
    }


    override fun initEventHandlers() {
        cl_all_discounts.setOnClickListener(this)
        cl_all_items.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            cl_all_discounts.id -> changeFragmentListener.onFragmentChange(NextFrag.ALL_DISCOUNT)
            cl_all_items.id -> changeFragmentListener.onFragmentChange(NextFrag.ALL_ITEMS)
        }
    }

    interface ChangeFragmentListener {
        fun onFragmentChange(fragmentName: NextFrag)
    }

}