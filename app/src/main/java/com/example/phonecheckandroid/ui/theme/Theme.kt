package com.example.phonecheckandroid.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    // Primary (네이비 계열)
    primary = Navy300,
    onPrimary = White,
    primaryContainer = Navy200,
    onPrimaryContainer = White,

    // Secondary (블루 스카이 계열)
    secondary = BlueSky500,
    onSecondary = White,
    secondaryContainer = BlueSky600,
    onSecondaryContainer = White,

    // Tertiary (골드 옐로우 계열)
    tertiary = GoldYellow600,
    onTertiary = Black,
    tertiaryContainer = GoldYellow500,
    onTertiaryContainer = Black,

    // 다크 모드 배경 및 표면 색상 (라이트 모드와 다른 부분)
    background = DarkBackground,    // 어두운 회색 배경
    onBackground = White,           // 배경 위 텍스트/아이콘 색상 (밝은 색)
    surface = DarkSurface,          // UI 요소의 배경 (배경보다 살짝 밝게)
    onSurface = White,              // surface 위 텍스트/아이콘 색상 (밝은 색)
    surfaceVariant = Navy100,
    onSurfaceVariant = Black,

    // 에러 색상
    error = Color(0xFFB00020),
    onError = White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Black,

    // 아웃라인 색상
    outline = Color(0xFF79747E)
)

private val LightColorScheme = lightColorScheme(
    // Primary (네이비 계열) - 라이트 모드에 맞게 중간 톤
    primary = Navy300,
    onPrimary = White, // 요청하신대로 onPrimary는 흰색 유지
    primaryContainer = Navy600,
    onPrimaryContainer = White,

    // Secondary (블루 스카이 계열) - 라이트 모드에 맞게 중간 톤
    secondary = BlueSky500,
    onSecondary = White,
    secondaryContainer = BlueSky600,
    onSecondaryContainer = White,

    // Tertiary (골드 옐로우 계열) - 라이트 모드에 맞게 중간 또는 어두운 톤
    tertiary = GoldYellow600,
    onTertiary = Black,
    tertiaryContainer = GoldYellow500,
    onTertiaryContainer = Black,

    // 라이트 모드 배경 및 표면 색상
    background = White,             // 요청하신대로 배경은 흰색
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = Navy100,
    onSurfaceVariant = Black,

    // 에러 색상
    error = Color(0xFFB00020),
    onError = White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Black,

    // 아웃라인 색상
    outline = Color(0xFF79747E)
)
@Composable
fun PhoneCheckAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}