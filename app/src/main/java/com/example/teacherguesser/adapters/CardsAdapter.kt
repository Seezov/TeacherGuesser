package com.example.teacherguesser.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.teacherguesser.CardStatus
import com.example.teacherguesser.R
import com.example.teacherguesser.entities.Card
import com.example.teacherguesser.extensions.toDp
import kotlinx.android.synthetic.main.card_item.view.*


class CardsAdapter(private val context: Context, var cards: List<Card>) : BaseAdapter() {

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
        view.layoutParams = AbsListView.LayoutParams(GridView.AUTO_FIT, 120.toDp(context))
        val currentItem = cards[position]
        view.img_avatar.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                if (currentItem.status == CardStatus.UNKNOWN)
                    R.drawable.ic_faculty
                else
                    cards[position].drawableId
            )
        )
        return view
    }
}