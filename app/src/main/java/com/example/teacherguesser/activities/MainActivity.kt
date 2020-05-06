package com.example.teacherguesser.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.content.DialogInterface.BUTTON_POSITIVE
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.teacherguesser.R
import com.example.teacherguesser.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid.apply {
            numColumns = viewModel.numColumns
            adapter = viewModel.cardsAdapter
            onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                viewModel.onItemClick(position)
            }
        }

        btn_new_game.setOnClickListener {
            viewModel.startNewGame()
            btn_new_game.isVisible = false
        }

        viewModel.guessedPairs.observe(this, Observer {
            txt_title.text = "Pairs guessed: $it"
            if (it == 8) {
                AlertDialog.Builder(this).apply {
                    setTitle("VICTORY")
                    setMessage("Start a new game?")
                    setNegativeButton("No") { _, _ ->
                        txt_title.text = "You have won!"
                        btn_new_game.isVisible = true
                    }
                    setPositiveButton("Yes") { _, _ ->
                        viewModel.startNewGame()
                    }
                    setCancelable(false)
                }.create().show()
            }
        })
    }
}
