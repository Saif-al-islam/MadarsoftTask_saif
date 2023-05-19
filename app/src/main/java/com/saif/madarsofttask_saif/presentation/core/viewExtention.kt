package com.saif.madarsofttask_saif.presentation.core

import android.view.View
import com.google.android.material.snackbar.Snackbar


fun handleLoading(isLoading: Boolean, pb: View?, vararg disabledViews: View) = if (isLoading)
    showProgress(pb, *disabledViews)
else
    hideProgress(pb, *disabledViews)

private fun showProgress(pb: View?, vararg enabledViews: View) {
    pb?.show()
}

private fun hideProgress(pb: View?, vararg disabledViews: View) {
    pb?.hide()
    disabledViews.forEach {
        it.enable()
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}


fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

fun Error.showSnackMsg(view: View) {
    when (this) {
        is Error.ErrorStr -> view.showSnackMsg(this.msg)
        is Error.ErrorInt -> view.showSnackMsg(this.msg)
    }
}

fun View.showSnackMsg(msg: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, length).show()
}

fun View.showSnackMsg(msg: Int, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, context.getString(msg), length).show()
}

