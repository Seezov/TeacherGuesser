package com.example.teacherguesser.adapters

import android.content.Context
import android.view.View

import android.view.ViewGroup

import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.teacherguesser.R
import com.example.teacherguesser.entities.Card
import kotlinx.android.synthetic.main.card_item.view.*


class CardsAdapter(private val context: Context, private val cards: List<Card>) : BaseAdapter() {

    override fun getCount(): Int {
        return cards.size
    }

    override fun getItem(i: Int): Any {
        return cards[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val view = View.inflate(context, R.layout.card_item, null)
        view.img_avatar.setImageDrawable(ContextCompat.getDrawable(context, cards[position].drawableId))
        return view
    }
}