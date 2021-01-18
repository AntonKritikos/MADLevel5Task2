package com.example.madlevel5task2.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("SELECT * FROM gameTable ORDER BY `release` ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()
}
