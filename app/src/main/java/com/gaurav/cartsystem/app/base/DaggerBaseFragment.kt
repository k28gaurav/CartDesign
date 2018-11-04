package com.gaurav.cartsystem.app.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import dagger.android.support.DaggerFragment

abstract class DaggerBaseFragment<VM: BaseViewModel>: DaggerFragment(),  View.OnClickListener {

    protected lateinit var viewModel: VM

    var isFragmentShowCalled = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    protected open fun initViews() {
        initAnimations()
        initEventHandlers()
    }

    protected open fun initAnimations() {


    }

    protected open fun initEventHandlers() {

    }

    override fun onClick(view: View?) {

    }

    protected open fun observeViewModel() {

    }
}