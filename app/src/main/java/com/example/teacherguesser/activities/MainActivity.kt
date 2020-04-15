package com.example.teacherguesser.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teacherguesser.R
import com.example.teacherguesser.adapters.CardsAdapter
import com.example.teacherguesser.entities.Card
import com.example.teacherguesser.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grid.apply {
            // TODO: WTF IS THIS, FIX
            verticalSpacing = -120
            numColumns = viewModel.numColumns
            adapter = viewModel.cardsAdapter
        }
    }
}
