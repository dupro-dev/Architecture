package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment



class GameViewModel: ViewModel() {
    var word = MutableLiveData<String>();
    val score = MutableLiveData<Int>();
    private lateinit var wordList: MutableList<String>
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    init{
        word.value=""
        score.value = 0;
        resetList()
        nextWord()
    }
    private fun nextWord() {
        //Select and remove a word from the list
        if (!wordList.isEmpty()) {


            word.value = wordList.removeAt(0)
        }

    }
    fun onSkip() {
        score.value = score.value?.plus(-1);
        Log.i("mes","${score.value}")
        nextWord()
    }
    fun onCorrect() {
        score.value = score.value?.plus(1);
        Log.i("mes","${score.value}")
        nextWord()
    }


}