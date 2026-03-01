package com.nebula.force

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

private data class Bullet(var pos: Offset, val vel: Offset)

@Composable
fun NebulaForceApp() {
    MaterialTheme {
        GameScreen()
    }
}

@Composable
fun GameScreen() {
    var levelIndex by remember { mutableIntStateOf(0) }
    val spec = retroBosses[levelIndex]

    var playerX by remember { mutableFloatStateOf(0.5f) }
    var bossHp by remember(levelIndex) { mutableIntStateOf(spec.maxHp) }
    var playerHp by remember(levelIndex) { mutableIntStateOf(5) }
    var status by remember(levelIndex) { mutableStateOf("Lluita!") }

    val bullets = remember(levelIndex) { mutableStateListOf<Bullet>() }

    LaunchedEffect(levelIndex, spec.patternCooldownMs, spec.bulletSpeed) {
        while (playerHp > 0 && bossHp > 0) {
            bullets += Bullet(Offset(0.2f, 0.18f), Offset(0f, spec.bulletSpeed / 1000f))
            bullets += Bullet(Offset(0.5f, 0.18f), Offset(0f, spec.bulletSpeed / 1000f))
            bullets += Bullet(Offset(0.8f, 0.18f), Offset(0f, spec.bulletSpeed / 1000f))
            delay(spec.patternCooldownMs)
        }
    }

    LaunchedEffect(levelIndex) {
        while (playerHp > 0 && bossHp > 0) {
            bossHp -= 1 // auto-fire simulation
            if (bossHp <= 0) {
                status = "Cap derrotat!"
                break
            }
            delay(85)
        }
    }

    LaunchedEffect(levelIndex, playerX) {
        while (playerHp > 0 && bossHp > 0) {
            val iterator = bullets.iterator()
            while (iterator.hasNext()) {
                val b = iterator.next()
                val y = b.pos.y + b.vel.y
                b.pos = Offset(b.pos.x, y)
                if (y > 1.05f) iterator.remove()
                val hit = y > 0.87f && kotlin.math.abs(b.pos.x - playerX) < 0.07f
                if (hit) {
                    iterator.remove()
                    playerHp -= 1
                    if (playerHp <= 0) {
                        status = "Has perdut"
                    }
                }
            }
            delay(16)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080B1A))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Nivell ${levelIndex + 1}: ${spec.levelName}", color = Color.White)
        Text(spec.bossName, color = spec.primaryColor)

        LinearProgressIndicator(
            progress = { bossHp.coerceAtLeast(0) / spec.maxHp.toFloat() },
            modifier = Modifier.fillMaxWidth().height(8.dp),
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("HP jugador: $playerHp", color = Color(0xFF80CBC4))
            Text(status, color = Color.White)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val next = playerX + (dragAmount.x / size.width)
                        playerX = next.coerceIn(0.08f, 0.92f)
                    }
                }
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Boss
                drawRect(
                    color = spec.primaryColor,
                    topLeft = Offset(size.width * 0.35f, size.height * 0.06f),
                    size = Size(size.width * 0.3f, size.height * 0.08f)
                )

                // Bullets
                bullets.forEach {
                    drawCircle(
                        color = Color(0xFF64B5F6),
                        radius = size.minDimension * 0.012f,
                        center = Offset(size.width * it.pos.x, size.height * it.pos.y)
                    )
                }

                // Player ship
                drawRect(
                    color = Color(0xFF00E676),
                    topLeft = Offset(size.width * playerX - 20f, size.height * 0.9f),
                    size = Size(40f, 18f)
                )
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                if (bossHp <= 0) {
                    levelIndex = (levelIndex + 1).coerceAtMost(retroBosses.lastIndex)
                }
            }) { Text("Següent cap") }

            Button(onClick = {
                bossHp = spec.maxHp
                playerHp = 5
                bullets.clear()
                status = "Reiniciat"
            }) { Text("Reinicia") }
        }
    }
}
