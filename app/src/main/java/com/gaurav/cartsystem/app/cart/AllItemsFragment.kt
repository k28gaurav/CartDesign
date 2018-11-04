package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseFragment
import com.gaurav.cartsystem.data.db.entities.Item
import java.lang.RuntimeException
import javax.inject.Inject

class AllItemsFragment: DaggerBaseFragment<AllItemsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    lateinit var allItemsAdapter: AllItemsAdapter
    lateinit var showAddItemToCartDialogListener: ShowAddItemToCartDialogListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_items, container)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[AllItemsViewModel::class.java]
        if(context is ShowAddItemToCartDialogListener) {
            showAddItemToCartDialogListener = context
        } else {
            throw RuntimeException("Must Implement ShowAddItemToCartDialogListener")
        }
    }

    override fun initEventHandlers() {

    }

    override fun observeViewModel() {
        viewModel.itemsLiveData.observe(this, Observer { items ->
            items?.let {
                if(it.size == 0) {
                    viewModel.fetchItemList()
                }
                allItemsAdapter.submitList(items)
            }
        })
    }

    override fun onClick(view: View?) {
        when(view?.id) {

        }
    }

    interface ShowAddItemToCartDialogListener {
        fun onShowAddItemToCartDialog(item: Item)
    }
}