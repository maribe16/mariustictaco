package no.uia.ikt205.thgame

import no.uia.ikt205.knotsandcrosses.GameActivity
import no.uia.ikt205.knotsandcrosses.api.GameService
import no.uia.ikt205.knotsandcrosses.api.data.Game
import no.uia.ikt205.knotsandcrosses.api.data.GameState

object GameManager {
    var onGameActivity:((Game) -> Unit)? = null
    var player:String? = null
    var state:GameState? = null
    var gameId:String? = null
    lateinit var currentgame :Game
    val StartingGameState:GameState = mutableListOf(mutableListOf(0,0,0),
        mutableListOf(0,0,0), mutableListOf(0,0,0)
    )

    fun createGame(player:String){

        GameService.createGame(player,StartingGameState) { game: Game?, err: Int? ->
            if(err != null){
                println("hei")
            } else {
                if (game != null) {
                    println("${game.gameId}")
                    currentgame =game
                }
            }
        }

    }
    fun joinGame(player:String, gameId:String){

        GameService.joinGame(player, gameId) { game: Game?, err: Int? ->
            if(err != null){
                println(err)
            } else {
                if (game != null) {
                    println("Game id:${game.gameId}")
                    println("Players: ${game.players}")
                    currentgame=game
                }
            }
        }

    }
    fun updateGame(gameId: String, state: GameState){

        GameService.updateGame(gameId,state) { game: Game?, err: Int? ->
            if(err != null){
                println(err)
            } else {
                if (game != null) {
                    println("Game id:${game.gameId}")
                    println("Players: ${game.players}")
                    println("updated game")
                    println("${game.state}")
                    currentgame=game
                }
            }
        }

    }
    fun pollGame(gameId: String){

        GameService.pollGame(gameId) { game: Game?, err: Int? ->
            if(err != null){
                println(err)
            } else {
                if (game != null) {
                    println("Game id:${game.gameId}")
                    println("Players: ${game.players}")
                    println("updated game")
                    println("${game.state}")
                    println("Du Pollet")
                    currentgame=game
                    gameChange()
                }
            }
        }

    }

    fun gameChange(){
        onGameActivity?.invoke(currentgame)
    }

}