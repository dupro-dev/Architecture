package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel: ViewModel() {
    private val _isCompleted = MutableLiveData<Boolean>();
    private val _word = MutableLiveData<String>();
    private val _score = MutableLiveData<Int>();
    val isCompleted: LiveData<Boolean>
        get() = _isCompleted
    val score: LiveData<Int>
        get() = _score
    val word: LiveData<String>
        get()=_word
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
        _isCompleted.value = false;
        _word.value=""
        _score.value = 0;
        resetList()
        nextWord()
    }
    private fun nextWord() {
        //Select and remove a word from the list
        if (!wordList.isEmpty()) {
            _word.value = wordList.removeAt(0)
        }else{
            onComplete()
        }

    }

    private fun onComplete() {
        Log.i("completed?",_isCompleted.value.toString())
        _isCompleted.value = true
    }

    fun onSkip() {
        _score.value = _score.value?.plus(-1);
        Log.i("mes","${_score.value}")
        nextWord()
    }
    fun onCorrect() {
        _score.value = _score.value?.plus(1);
        Log.i("mes","${_score.value}")
        nextWord()
    }



}