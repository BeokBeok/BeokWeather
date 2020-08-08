package com.example.common.base

class ViewModelBindComponent {

    fun bindViewModel(bind: () -> Unit) = bind.invoke()
    fun bindObserver(bind: () -> Unit) = bind.invoke()
}