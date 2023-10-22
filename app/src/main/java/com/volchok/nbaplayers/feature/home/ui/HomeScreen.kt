package com.volchok.nbaplayers.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.volchok.nbaplayers.R
import com.volchok.nbaplayers.feature.home.presentation.HomeViewModel
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.ui.NbaColors
import com.volchok.nbaplayers.library.ui.NbaColors.black
import com.volchok.nbaplayers.library.ui.NbaColors.chrome400
import com.volchok.nbaplayers.library.ui.NbaDimensions
import com.volchok.nbaplayers.library.ui.NbaDimensions.sizeS
import com.volchok.nbaplayers.library.ui.NbaDimensions.sizeXS
import com.volchok.nbaplayers.library.ui.NbaText
import com.volchok.nbaplayers.library.ui.NbaTopBar
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen() {
    val viewModel = getViewModel<HomeViewModel>()
    val pagingItems = viewModel.playerState.collectAsLazyPagingItems()

    HomeScreenImpl(
        pagingData = pagingItems,
        viewModel::onItem
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenImpl(
    pagingData: LazyPagingItems<PlayerModel>,
    onItem: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            NbaTopBar(
                title = stringResource(id = R.string.home_screen_top_bar_title),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(NbaColors.background)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(sizeS)
            ) {
                items(pagingData.itemCount) { index ->
                    ListItem(
                        modifier = Modifier
                            .clickable { pagingData[index]?.id?.let { onItem(it) } },
                        firstName = pagingData[index]?.first_name.orEmpty(),
                        lastName = pagingData[index]?.last_name.orEmpty(),
                        teamName = pagingData[index]?.team?.full_name.orEmpty()
                    )
                    Spacer(modifier = Modifier.height(sizeS))
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ListItem(
    modifier: Modifier = Modifier,
    firstName: String,
    lastName: String,
    teamName: String
) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = NbaDimensions.sizeXXS),
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = CardDefaults.cardColors(containerColor = NbaColors.chrome50)
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
                        text = "$firstName $lastName",
                        style = MaterialTheme.typography.h6,
                        color = black,
                        fontWeight = FontWeight.Bold
                    )
                    NbaText(
                        text = "${stringResource(id = R.string.home_screen_team)} $teamName",
                        style = MaterialTheme.typography.subtitle1,
                        color = chrome400
                    )
                }
            }
        }
}