package com.example.teacherguesser.entities

import com.example.teacherguesser.CardStatus

data class Card (var status: CardStatus = CardStatus.UNKNOWN, var drawableId: Int)