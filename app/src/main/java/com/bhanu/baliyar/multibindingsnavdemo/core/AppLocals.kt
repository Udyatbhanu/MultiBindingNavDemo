package com.bhanu.baliyar.multibindingsnavdemo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import com.bhanu.baliyar.multibindingsnavdemo.R

data class AppSpacing(val small: Dp, val medium: Dp, val large: Dp)

val LocalSpacingProvider = staticCompositionLocalOf<AppSpacing> { error("Spacing not provided") }

val LocalNavProvider = compositionLocalOf<NavHostController> { error("NavHost not provided") }

@Composable
fun rememberLocalSpacing(): AppSpacing {
    val small = dimensionResource(R.dimen.small)
    val medium = dimensionResource(R.dimen.medium)
    val large = dimensionResource(R.dimen.large)

    return remember {
        AppSpacing(small, medium, large)
    }
}


val LocalNavController: NavHostController
    @Composable get() = LocalNavProvider.current

val LocalAppSpacing: AppSpacing
    @Composable get() = LocalSpacingProvider.current

