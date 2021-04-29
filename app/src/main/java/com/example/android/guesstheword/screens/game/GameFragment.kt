/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding


/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {



    // The current word


    // The current score


    // The list of words - the front of the list is the next word to guess


    private lateinit var binding: GameFragmentBinding
    val model:GameViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )




        binding.gameViewModel=model
        binding.setLifecycleOwner(this)


        model.isCompleted.observe(viewLifecycleOwner, Observer<Boolean> {
            isCompleted -> if(isCompleted){ gameFinished()
            model.onGameFinish()
        }
        })

        model.timeLeft.observe(viewLifecycleOwner, Observer<Long> {
            newTime->binding.timerText.text=newTime.toString()
        })
        return binding.root


    }
    private fun gameFinished() {
        Log.i("completed?","Game Finished Function is called")
        //Toast.makeText(this.context,"Game Finished Function is called",Toast.LENGTH_LONG).show()
        val action = GameFragmentDirections.actionGameToScore(model.score.value ?: 0)
        NavHostFragment.findNavController(this).navigate(action)
    }
    private fun buzz(pattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()

        buzzer?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                //deprecated in API 26
                buzzer.vibrate(pattern, -1)
            }
        }
    }



    /**
     * Resets the list of words and randomizes the order
     */

    /**
     * Called when the game is finished
     */


    /**
     * Moves to the next word in the list
     */


    /** Methods for buttons presses **/





    /** Methods for updating the UI **/




}


