package com.example.teacherguesser.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEGATIVE
import android.content.DialogInterface.BUTTON_POSITIVE
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
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

        viewModel.guessedPairs.observe(this, Observer {
            txt_title.text = "Pairs guessed: $it"
            if (it == 8) {
                AlertDialog.Builder(this).apply {
                    setTitle("YOU HAVE WON")
                    setMessage("Візьми з полки пірожок, а потім поклади на місце!")
                    setNegativeButton("НЕ ВІЗЬМУ! (А треба)"
                    ) { _, _ ->
                        txt_title.text = "YOU DIED"
                        viewModel.setSalapatovItems()
                    }
                    setPositiveButton("БЕРУ (New Game)") { _, _ ->
                        viewModel.startNewGame()
                    }
                }.create().show()
            }
        })
    }
}
