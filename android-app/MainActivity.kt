package com.happyfrontend

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.json.JSONArray
import java.io.InputStream

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val games = remember { loadGames() }

            LazyColumn {
                items(games.size) { index ->
                    val game = games[index]

                    Text(
                        text = game.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                launchGame(game)
                            }
                    )
                }
            }
        }
    }

    data class Game(
        val title: String,
        val system: String,
        val rom: String,
        val emulator: String
    )

    private fun loadGames(): List<Game> {
        val input: InputStream = assets.open("games.json")
        val json = input.bufferedReader().use { it.readText() }
        val array = JSONArray(json)

        val list = mutableListOf<Game>()

        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)

            list.add(
                Game(
                    obj.getString("title"),
                    obj.getString("system"),
                    obj.getString("rom"),
                    obj.getString("emulator")
                )
            )
        }

        return list
    }

    private fun launchGame(game: Game) {
        val intent = Intent(Intent.ACTION_VIEW)

        intent.setClassName(
            "com.retroarch",
            "com.retroarch.browser.retroactivity.RetroActivityFuture"
        )

        intent.putExtra("ROM", game.rom)
        startActivity(intent)
    }
}
