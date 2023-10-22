package com.volchok.nbaplayers.feature.team.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.volchok.nbaplayers.R
import com.volchok.nbaplayers.feature.team.presentation.TeamViewModel
import com.volchok.nbaplayers.library.ui.NbaColors
import com.volchok.nbaplayers.library.ui.NbaDimensions
import com.volchok.nbaplayers.library.ui.NbaText
import com.volchok.nbaplayers.library.ui.NbaTopBar
import org.koin.androidx.compose.getViewModel

@Composable
fun TeamScreen() {
    val viewModel = getViewModel<TeamViewModel>()
    val state = viewModel.states.collectAsState()

    TeamScreenImpl(
        state = state.value,
        onBackClick = viewModel::onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TeamScreenImpl(
    state: TeamViewModel.State,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            NbaTopBar(
                title = state.team?.full_name.orEmpty(),
                onBackClick = { onBackClick() }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(NbaColors.background)
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = NbaDimensions.sizeXXS),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(NbaDimensions.sizeS),
                colors = CardDefaults.cardColors(containerColor = NbaColors.chrome50)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(NbaDimensions.sizeS)
                ) {
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_name),
                        subtitle = state.team?.full_name.orEmpty()
                    )
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_abbreviation),
                        subtitle = state.team?.abbreviation.orEmpty()
                    )
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_city),
                        subtitle = state.team?.city.orEmpty()
                    )
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_abbreviation),
                        subtitle = state.team?.abbreviation.orEmpty()
                    )
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_conference),
                        subtitle = state.team?.conference.orEmpty()
                    )
                    TeamItem(
                        title = stringResource(id = R.string.team_screen_division),
                        subtitle = state.team?.division.orEmpty()

                    )
                }
            }
        }
    }
}

@Composable
private fun TeamItem(
    title: String,
    subtitle: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(NbaDimensions.sizeXS),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NbaText(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            color = NbaColors.chrome400,
            modifier = Modifier
                .padding(end = NbaDimensions.sizeS)
        )
        NbaText(
            text = subtitle,
            style = MaterialTheme.typography.h6,
            color = NbaColors.black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(NbaDimensions.sizeXS))
    }
}