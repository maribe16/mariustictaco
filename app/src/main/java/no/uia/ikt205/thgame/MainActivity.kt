package no.uia.ikt205.knotsandcrosses

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import no.uia.ikt205.knotsandcrosses.api.GameService
import no.uia.ikt205.knotsandcrosses.api.data.Game
import no.uia.ikt205.knotsandcrosses.databinding.ActivityMainBinding
import no.uia.ikt205.thgame.GameManager

class MainActivity : AppCompatActivity() {

    val TAG:String = "MainActivity"
    lateinit var timer:CountDownTimer
    var timeToCountDownTimer = 5000L
    val timeTicks = 1000L

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGameButton.setOnClickListener {
            createNewGame()
        }

        binding.joinGameButton.setOnClickListener {
            joinGame()
        }

    }

    private fun createNewGame(){

        GameManager.player = binding.username.text.toString()
        GameManager.createGame(GameManager.player.toString())
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        pollclock()


    }

    private fun joinGame(){
        GameManager.gameId = binding.joinid.text.toString()
        GameManager.player = binding.username.text.toString()
        GameManager.joinGame(GameManager.player!!, GameManager.gameId!!)
        val intent = Intent(this,GameActivity::class.java)
        startActivity(intent)
        pollclock()
    }

    private fun pollclock(){
        timer = object : CountDownTimer(timeToCountDownTimer,timeTicks){
            override fun onFinish(){
                GameManager.pollGame(GameManager.currentgame.gameId)
                pollclock()
            }
            override fun onTick(millisUntilFinished: Long){

            }
        }
        timer.start()

    }



}