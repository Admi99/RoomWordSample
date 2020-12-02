package com.example.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import com.example.roomwordsample.WordRoomDatabase

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database  by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}