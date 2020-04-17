package com.example.teacherguesser.viewmodels

import android.app.Application
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.teacherguesser.CardStatus
import com.example.teacherguesser.R
import com.example.teacherguesser.adapters.CardsAdapter
import com.example.teacherguesser.entities.Card

class MainViewModel(
    application: Application,
    val cardsAdapter: CardsAdapter = CardsAdapter(
        application, listOf(
            Card(drawableId = R.drawable.ic_avramenkovs),
            Card(drawableId = R.drawable.ic_avramenkovs),
            Card(drawableId = R.drawable.ic_avramenkoas),
            Card(drawableId = R.drawable.ic_avramenkoas),
            Card(drawableId = R.drawable.ic_grebenovichue),
            Card(drawableId = R.drawable.ic_grebenovichue),
            Card(drawableId = R.drawable.ic_nemchenkovv),
            Card(drawableId = R.drawable.ic_nemchenkovv),
            Card(drawableId = R.drawable.ic_onischenkobo),
            Card(drawableId = R.drawable.ic_onischenkobo),
            Card(drawableId = R.drawable.ic_porublovim),
            Card(drawableId = R.drawable.ic_porublovim),
            Card(drawableId = R.drawable.ic_salapatovvi),
            Card(drawableId = R.drawable.ic_salapatovvi),
            Card(drawableId = R.drawable.ic_yarinichyo),
            Card(drawableId = R.drawable.ic_yarinichyo)
        ).shuffled()
    )
) : BaseViewModel(application) {

    val numColumns = 4
    var numberOfOpenedCards = 0
    lateinit var cards: List<Card>
    var isClickable = true

    private val _guessedPairs = MutableLiveData(0)
    val guessedPairs: LiveData<Int> = _guessedPairs

    fun onItemClick(position: Int) {
        if (isClickable) {
            cards = cardsAdapter.cards
            val currentItem = cards[position]
            when (currentItem.status) {
                CardStatus.UNKNOWN -> {
                    numberOfOpenedCards++
                    val matchedCard = getMatchedCard(currentItem.drawableId)
                    if (matchedCard != null && numberOfOpenedCards == 2) {
                        currentItem.status = CardStatus.GUESSED
                        matchedCard.status = CardStatus.GUESSED
                        numberOfOpenedCards -= 2
                        _guessedPairs.value = _guessedPairs.value!! + 1
                        Toast.makeText(
                            getApplication(),
                            "YOU HAVE GUESSED AN ITEM",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (matchedCard == null && numberOfOpenedCards == 2) {
                        currentItem.status = CardStatus.OPENED
                        isClickable = false
                        Handler().postDelayed({
                            currentItem.status = CardStatus.UNKNOWN
                            getOpenedCard().status = CardStatus.UNKNOWN
                            cardsAdapter.notifyDataSetChanged()
                            isClickable = true
                        }, 1000)
                        numberOfOpenedCards -= 2
                    } else {
                        currentItem.status = CardStatus.OPENED
                    }
                    cardsAdapter.notifyDataSetChanged()
                }
                CardStatus.OPENED -> {
                    Toast.makeText(getApplication(), "PICK A MATCH", Toast.LENGTH_SHORT).show()
                }
                CardStatus.GUESSED -> {
                    Toast.makeText(
                        getApplication(),
                        "YOU'VE ALREADY GUESSED IT",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getOpenedCard(): Card = cards.first { card -> card.status == CardStatus.OPENED }

    private fun getMatchedCard(drawableId: Int): Card? =
        cards.firstOrNull { card ->
            card.drawableId == drawableId && card.status == CardStatus.OPENED
        }

    fun startNewGame() {
        _guessedPairs.value = 0
        numberOfOpenedCards = 0
        cards.forEach { it.status = CardStatus.UNKNOWN }
        cardsAdapter.notifyDataSetChanged()
    }

    fun setSalapatovItems() {
        cards.forEach {
            it.drawableId = R.drawable.ic_salapatovvi
            it.status = CardStatus.OPENED
        }
        cardsAdapter.notifyDataSetChanged()
    }
}