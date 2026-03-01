package com.nebula.force

import androidx.compose.ui.graphics.Color

data class BossSpec(
    val levelName: String,
    val bossName: String,
    val maxHp: Int,
    val bulletSpeed: Float,
    val patternCooldownMs: Long,
    val primaryColor: Color,
)

val retroBosses = listOf(
    BossSpec("Frontera de Runa", "Tyrax-01 Sentinel Core", 80, 210f, 900L, Color(0xFFD32F2F)),
    BossSpec("Mar de Sorra", "Vor'Keth", 120, 250f, 780L, Color(0xFFE67E22)),
    BossSpec("Ruïnes Soterrades", "Heliox-Prime", 140, 285f, 700L, Color(0xFF42A5F5)),
    BossSpec("Tempesta Ionitzada", "Kraion Colossus", 180, 320f, 620L, Color(0xFF64B5F6)),
    BossSpec("Corredor Estel·lar", "Oryx Dual Core", 200, 360f, 520L, Color(0xFF9C27B0)),
    BossSpec("Cor de Nàqira", "Reina Nàqira", 260, 420f, 460L, Color(0xFFE53935)),
)
