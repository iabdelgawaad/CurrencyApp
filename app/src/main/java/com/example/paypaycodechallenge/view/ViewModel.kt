package com.example.paypaycodechallenge.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.paypaycodechallenge.MyBaseApplication
import com.example.paypaycodechallenge.data.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {
    var repository: Repository? = null

    init {

    }

    companion object {
        private var viewModel: ViewModel? = null

        @Synchronized
        fun getInstance(): ViewModel? {
            return if (viewModel == null) {
                MyBaseApplication.getInstance()?.let { ViewModel(it) }
            } else {
                viewModel
            }
        }
    }
}