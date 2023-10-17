package com.volchok.nbaplayers.feature.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.volchok.nbaplayers.R
import com.volchok.nbaplayers.feature.home.presentation.HomeViewModel
import com.volchok.nbaplayers.library.ui.NbaColors.black
import com.volchok.nbaplayers.library.ui.NbaColors.chrome400
import com.volchok.nbaplayers.library.ui.NbaDimensions
import com.volchok.nbaplayers.library.ui.NbaDimensions.sizeS
import com.volchok.nbaplayers.library.ui.NbaDimensions.sizeXS
import com.volchok.nbaplayers.library.ui.NbaText
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val state = viewModel.states.collectAsState()


    HomeScreenImpl(
        state = state.value
    )
}

@Composable
private fun HomeScreenImpl(
    state: HomeViewModel.State
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(sizeS)
    ) {
        item {
            NbaText(
                text = stringResource(id = R.string.home_screen_title),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }
        items(state.players) { item ->
            Spacer(modifier = Modifier.height(sizeXS))
            ListItem(
                modifier = Modifier
                    .clickable { item.id?.let {} },
                item = item
            )
            Spacer(modifier = Modifier.height(sizeXS))
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ListItem(
    modifier: Modifier = Modifier,
    item: HomeViewModel.State.PlayerItem
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = NbaDimensions.sizeXXS),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(sizeXS),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = R.drawable.nba_player,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(85.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = sizeS)
            ) {
                NbaText(
                    text = "${item.first_name} ${item.last_name}",
                    style = MaterialTheme.typography.h6,
                    color = black,
                    fontWeight = FontWeight.Bold
                )
                NbaText(
                    text = "${stringResource(id = R.string.home_screen_team)} ${item.teamName}",
                    style = MaterialTheme.typography.subtitle1,
                    color = chrome400
                )
            }
        }
    }
}