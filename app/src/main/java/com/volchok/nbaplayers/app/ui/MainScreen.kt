package com.volchok.nbaplayers.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.volchok.nbaplayers.app.model.BackNavigationEvent
import com.volchok.nbaplayers.app.model.ForwardNavigationEvent
import com.volchok.nbaplayers.app.model.Route
import com.volchok.nbaplayers.app.presentation.MainViewModel
import com.volchok.nbaplayers.feature.details.ui.DetailsScreen
import com.volchok.nbaplayers.feature.home.ui.HomeScreen
import com.volchok.nbaplayers.ui.theme.NBAPlayersTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {
    val viewModel = getViewModel<MainViewModel>()
    val state = viewModel.states.collectAsState()

    MainScreenImpl(
        viewModel = viewModel,
        state = state.value
    )
}

@Composable
fun MainScreenImpl(
    viewModel: MainViewModel,
    state: MainViewModel.State
) {
    NBAPlayersTheme {
        val navController = rememberNavController()

        NavigationEffect(
            navController = navController,
            viewModel = viewModel,
            onNavigationEventConsumed = viewModel::onNavigationEventConsumed
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Screens(
                navController = navController,
                modifier = Modifier
                    .weight(1f)
                    .background(MaterialTheme.colors.background)
            )
            // TODO: Internet status dialog
        }
    }
}

@Composable
private fun Screens(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Initial(),
        modifier = modifier
    ) {
        composable(Route.Home()) { HomeScreen() }
        composable(Route.Details()) { DetailsScreen() }
    }
}

@Composable
private fun NavigationEffect(
    navController: NavHostController,
    viewModel: MainViewModel,
    onNavigationEventConsumed: () -> Unit
) {
    val state = viewModel.states.collectAsState()
    val navigationEvent = state.value.navigationEvent

    SideEffect {
        when (navigationEvent) {
            is BackNavigationEvent -> {
                navController.navigateUp()
                onNavigationEventConsumed()
            }

            is ForwardNavigationEvent -> {
                if (navController.currentDestination?.route != navigationEvent.route()) {
                    var navOptions = prepareNavOptions(navigationEvent)

                    navController.navigate(navigationEvent.route(), navOptions)
                    onNavigationEventConsumed()
                }
            }

            null -> Unit
        }
    }
}

private fun prepareNavOptions(navigationEvent: ForwardNavigationEvent): NavOptions? {
    return if (navigationEvent.clearBackStack) {
        NavOptions.Builder().also { navOptionsBuilder ->
            navigationEvent.clearBackStackRoute?.let {
                navOptionsBuilder.setPopUpTo(it(), false)
            } ?: navOptionsBuilder.setPopUpTo(0, false)
        }.build()
    } else {
        null
    }
}