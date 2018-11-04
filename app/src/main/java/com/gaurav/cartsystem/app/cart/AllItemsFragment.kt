package com.gaurav.cartsystem.app.cart

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurav.cartsystem.R
import com.gaurav.cartsystem.app.base.DaggerBaseFragment
import com.gaurav.cartsystem.data.db.entities.Item
import kotlinx.android.synthetic.main.fragment_all_items.rv_all_items
import java.lang.RuntimeException
import javax.inject.Inject

class AllItemsFragment @Inject constructor(): DaggerBaseFragment<AllItemsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    lateinit var allItemsAdapter: AllItemsAdapter
    lateinit var showAddItemToCartDialogListener: ShowAddItemToCartDialogListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_items, container, false)
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

    override fun initViews() {
        rv_all_items.layoutManager = LinearLayoutManager(activity)
        activity?.let {
            allItemsAdapter = AllItemsAdapter(it) { position, item ->
                showAddItemToCartDialog(item)
            }
            rv_all_items.adapter = allItemsAdapter
        }
        super.initViews()
    }

    private fun showAddItemToCartDialog(item: Item) {
        showAddItemToCartDialogListener.onShowAddItemToCartDialog(item)
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