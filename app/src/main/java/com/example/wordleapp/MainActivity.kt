package com.example.wordleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val guessBtn = findViewById<Button>(R.id.button)

        val guess_WORD_0  = findViewById<TextView>(R.id.textView7)
        val user_WORD_0  = findViewById<TextView>(R.id.textView8)

        val guess_WORD_1 = findViewById<TextView>(R.id.textView9)
        val user_WORD_1 = findViewById<TextView>(R.id.textView10)

        val guess_WORD_2 = findViewById<TextView>(R.id.textView11)
        val user_WORD_2 = findViewById<TextView>(R.id.textView12)

        val guess_WORD_3 = findViewById<TextView>(R.id.textView13)


        val editTex = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var count = 0

        val current_Word = findViewById<TextView>(R.id.textView)
        current_Word.text = FourLetterWordList.getRandomFourLetterWord()
        val wordToGuess = current_Word.text

        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == current_Word.text[i]) {
                    result += "O"
                }
                else if (guess[i] in current_Word.text) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }


        guessBtn.setOnClickListener {


            count = count + 1

            if(count == 1){
                guess_WORD_1.text = checkGuess(editTex.toString())
                user_WORD_0.text = editTex.text
            }else if(count == 2){
                guess_WORD_2.text = checkGuess(editTex.toString())
                user_WORD_1.text = editTex.text
            }else if(count == 3){
                guess_WORD_3.text = checkGuess(editTex.toString())
                user_WORD_2.text = editTex.text
            }else if(count == 4){
                //toast game over...
                Toast.makeText(applicationContext, "GAME OVER EXCEED TRIES", Toast.LENGTH_LONG).show()
            }

        }
    }








}