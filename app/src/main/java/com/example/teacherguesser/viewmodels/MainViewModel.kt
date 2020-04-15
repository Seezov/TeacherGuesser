package com.example.teacherguesser.viewmodels

import android.app.Application
import com.example.teacherguesser.R
import com.example.teacherguesser.adapters.CardsAdapter
import com.example.teacherguesser.entities.Card

class MainViewModel(
    application: Application,
    val cardsAdapter: CardsAdapter = CardsAdapter(
        application, listOf(
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs),
            Card(R.drawable.ic_avramenkovs)
        )
    )
) : BaseViewModel(application) {

    val numColumns = 4
}