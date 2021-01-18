package com.example.madlevel5task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.Database.Game
import com.example.madlevel5task2.Database.GameRepository
import kotlinx.coroutines.*
import java.util.*

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository =
        GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val games = gameRepository.getAllGames()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    fun insertGame(title: String, platform: String, release: Date) {
        val newGame = Game(
            title = title,
            platform = platform,
            release = release
        )
        if(isGameValid(newGame)) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.insertGame(newGame)
                }
                success.value = true
            }
        }
    }

    fun deleteGames() {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteGames()
            }
        }
    }

    fun deleteGame(game: Game) {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteGame(game)
            }
        }
    }

    private fun isGameValid(game: Game): Boolean {
        return when {
            game.title.isBlank() -> {
                error.value = "A Title is required to add a game"
                false
            }
            game.platform.isBlank() -> {
                error.value = "A Platform is required to add a game"
                false
            }
            else -> true
        }
    }

}