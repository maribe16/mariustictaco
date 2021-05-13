package no.uia.ikt205.knotsandcrosses

import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import no.uia.ikt205.knotsandcrosses.api.GameService
import no.uia.ikt205.knotsandcrosses.api.data.Game
import no.uia.ikt205.knotsandcrosses.api.data.GameState
import no.uia.ikt205.knotsandcrosses.databinding.ActivityGameBinding
import no.uia.ikt205.thgame.GameManager

class GameActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GameManager.onGameActivity ={
            checkMove()
            checkPlayers()
            checkGameId()
            checkStatus()
        }
        binding.gobackButton.setOnClickListener{

            finish()
        }
        binding.r1b1.setOnClickListener{
        val player = playercheck()
            if(binding.r1b1.text =="") {
                if (player == 1) {
                    binding.r1b1.text = "X"
                } else {
                    binding.r1b1.text = "O"
                }

                move(0, 0, player)

                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r1b2.setOnClickListener{
            val player = playercheck()
            if(binding.r1b2.text =="") {
                if (player == 1) {
                    binding.r1b2.text = "X"
                } else {
                    binding.r1b2.text = "O"
                }
                move(0, 1, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r1b3.setOnClickListener{
            val player = playercheck()
            if(binding.r1b3.text =="") {
                if (player == 1) {
                    binding.r1b3.text = "X"
                } else {
                    binding.r1b3.text = "O"
                }
                move(0, 2, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r2b1.setOnClickListener{
            val player = playercheck()
            if(binding.r2b1.text =="") {
                if (player == 1) {
                    binding.r2b1.text = "X"
                } else {
                    binding.r2b1.text = "O"
                }
                move(1, 0, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r2b2.setOnClickListener{
            val player = playercheck()
            if(binding.r2b2.text =="") {
                if (player == 1) {
                    binding.r2b2.text = "X"
                } else {
                    binding.r2b2.text = "O"
                }
                move(1, 1, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r2b3.setOnClickListener{
            val player = playercheck()
            if(binding.r2b3.text =="") {
                if (player == 1) {
                    binding.r2b3.text = "X"
                } else {
                    binding.r2b3.text = "O"
                }
                move(1, 2, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r3b1.setOnClickListener{
            val player = playercheck()
            if(binding.r3b1.text=="") {
                if (player == 1) {
                    binding.r3b1.text = "X"
                } else {
                    binding.r3b1.text = "O"
                }
                move(2, 0, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }

        }
        binding.r3b2.setOnClickListener{
            val player = playercheck()
            if(binding.r3b2.text=="") {
                if (player == 1) {
                    binding.r3b2.text = "X"
                } else {
                    binding.r3b2.text = "O"
                }
                move(2, 1, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
        binding.r3b3.setOnClickListener{
            val player = playercheck()
            if (binding.r3b3.text=="") {
                if (player == 1) {
                    binding.r3b3.text = "X"

                } else {
                    binding.r3b3.text = "O"
                }
                move(2, 2, player)
                GameManager.updateGame(GameManager.currentgame.gameId, GameManager.currentgame.state)
            }
            else{
                Toast.makeText(this, "Cant Do that", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun playercheck():Int{
        val playerspot :Int
        if (GameManager.player == GameManager.currentgame.players [0]){
            playerspot = 1
        }
        else {
            playerspot = 2
        }
        return playerspot
    }
    private fun move(row:Int, button:Int, player: Int) {
        if (GameManager.currentgame.state [row]  [button] == 0) {
            GameManager.currentgame.state[row].set(button, player)
        }



    }
    fun  checkMove(){
        if(GameManager.currentgame.state [0][0] == 1){
            binding.r1b1.text = "X"
        }
        if (GameManager.currentgame.state [0] [0] == 2){
            binding.r1b1.text="O"
        }
        if(GameManager.currentgame.state [0][1] == 1){
            binding.r1b2.text = "X"
        }
        if (GameManager.currentgame.state [0] [1] == 2){
            binding.r1b2.text="O"
        }
        if(GameManager.currentgame.state [0][2] == 1){
            binding.r1b3.text = "X"
        }
        if (GameManager.currentgame.state [0] [2] == 2){
            binding.r1b3.text="O"
        }
        if(GameManager.currentgame.state [1][0] == 1){
            binding.r2b1.text = "X"
        }
        if (GameManager.currentgame.state [1] [0] == 2){
            binding.r2b1.text="O"
        }
        if(GameManager.currentgame.state [1][1] == 1){
            binding.r2b2.text = "X"
        }
        if (GameManager.currentgame.state [1] [1] == 2){
            binding.r2b2.text="O"
        }
        if(GameManager.currentgame.state [1][2] == 1){
            binding.r2b3.text = "X"
        }
        if (GameManager.currentgame.state [1] [2] == 2){
            binding.r2b3.text="O"
        }
        if(GameManager.currentgame.state [2][0] == 1){
            binding.r3b1.text = "X"
        }
        if (GameManager.currentgame.state [2] [0] == 2){
            binding.r3b1.text="O"
        }
        if(GameManager.currentgame.state [2][1] == 1){
            binding.r3b2.text = "X"
        }
        if (GameManager.currentgame.state [2] [1] == 2){
            binding.r3b2.text="O"
        }
        if(GameManager.currentgame.state [2][2] == 1){
            binding.r3b3.text = "X"
        }
        if (GameManager.currentgame.state [2] [2] == 2){
            binding.r3b3.text="O"
        }
    }
    fun checkPlayers(){
        binding.players.text = "Players: ${GameManager.currentgame.players}"
    }
    fun checkGameId(){
        binding.gameid.text ="GameId: ${GameManager.currentgame.gameId}"
    }
    fun checkStatus(){
        if (GameManager.currentgame.state [0][0] == 1 && GameManager.currentgame.state [0][1] == 1 && GameManager.currentgame.state [0][2] == 1) {
            binding.players.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [0][0] == 2 && GameManager.currentgame.state [0][1] == 2 && GameManager.currentgame.state [0][2] == 2) {
            binding.players.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [1][0] == 1 && GameManager.currentgame.state [1][1] == 1 && GameManager.currentgame.state [1][2] == 1) {
            binding.players.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [1][0] == 2 && GameManager.currentgame.state [1][1] == 2 && GameManager.currentgame.state [1][2] == 2) {
            binding.players.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [2][0] == 1 && GameManager.currentgame.state [2][1] == 1 && GameManager.currentgame.state [2][2] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [2][0] == 2 && GameManager.currentgame.state [2][1] == 2 && GameManager.currentgame.state [2][2] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [0][0] == 1 && GameManager.currentgame.state [1][0] == 1 && GameManager.currentgame.state [2][0] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [0][0] == 2 && GameManager.currentgame.state [1][0] == 2 && GameManager.currentgame.state [2][0] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [0][1] == 1 && GameManager.currentgame.state [1][1] == 1 && GameManager.currentgame.state [2][1] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [0][1] == 2 && GameManager.currentgame.state [1][1] == 2 && GameManager.currentgame.state [2][1] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [0][2] == 1 && GameManager.currentgame.state [1][2] == 1 && GameManager.currentgame.state [2][2] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [0][2] == 2 && GameManager.currentgame.state [1][2] == 2 && GameManager.currentgame.state [2][2] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [0][0] == 1 && GameManager.currentgame.state [1][1] == 1 && GameManager.currentgame.state [2][2] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [0][0] == 2 && GameManager.currentgame.state [1][1] == 2 && GameManager.currentgame.state [2][2] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if (GameManager.currentgame.state [2][0] == 1 && GameManager.currentgame.state [1][1] == 1 && GameManager.currentgame.state [0][2] == 1) {
            binding.status.text = "${GameManager.currentgame.players[0]} Wins"
        }
        if (GameManager.currentgame.state [2][0] == 2 && GameManager.currentgame.state [1][1] == 2 && GameManager.currentgame.state [0][2] == 2) {
            binding.status.text = "${GameManager.currentgame.players[1]} Wins"
        }
        if(GameManager.currentgame.state [0][0] != 0 && GameManager.currentgame.state [0][1] != 0 && GameManager.currentgame.state [0][2] != 0 && GameManager.currentgame.state [1][0] != 0 && GameManager.currentgame.state [1][1] != 0 && GameManager.currentgame.state [1][2] != 0 &&
                GameManager.currentgame.state [2][0] != 0 && GameManager.currentgame.state [2][1] != 0 && GameManager.currentgame.state [2][2] != 0 && binding.status.text == ""){
            binding.players.text = "Draw"
        }
    }
}

