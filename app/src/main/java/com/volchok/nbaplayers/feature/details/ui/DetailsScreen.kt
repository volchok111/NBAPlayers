package com.volchok.nbaplayers.feature.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volchok.nbaplayers.R
import com.volchok.nbaplayers.feature.details.presentation.DetailsViewModel
import com.volchok.nbaplayers.library.ui.NbaColors
import com.volchok.nbaplayers.library.ui.NbaDimensions
import com.volchok.nbaplayers.library.ui.NbaIcon
import com.volchok.nbaplayers.library.ui.NbaText
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsScreen() {
    val viewModel = getViewModel<DetailsViewModel>()
    val state = viewModel.states.collectAsState()

    DetailsScreenImpl(
        state = state.value
    )
}

@Composable
private fun DetailsScreenImpl(
    state: DetailsViewModel.State
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(NbaDimensions.sizeXS)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = NbaDimensions.sizeXXS),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(NbaDimensions.sizeS)
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .size(150.dp)
                        .padding(end = NbaDimensions.sizeS)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.nba_player),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = NbaDimensions.sizeXS)
                ) {
                    NbaText(
                        text = stringResource(id = R.string.details_screen_name),
                        style = MaterialTheme.typography.subtitle1,
                        color = NbaColors.chrome600,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(NbaDimensions.sizeS))

                    NbaText(
                        text = "${state.player?.first_name} ${state.player?.last_name}",
                        style = MaterialTheme.typography.h5,
                        color = NbaColors.black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(NbaDimensions.sizeS))

                    NbaText(
                        text = stringResource(id = R.string.details_screen_position),
                        style = MaterialTheme.typography.subtitle1,
                        color = NbaColors.chrome600,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(NbaDimensions.sizeS))

                    NbaText(
                        text = state.player?.position.orEmpty(),
                        style = MaterialTheme.typography.h5,
                        color = NbaColors.black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(NbaDimensions.sizeS))
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = NbaDimensions.sizeXXS),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clickable { }
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(NbaDimensions.sizeS)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    NbaText(
                        text = stringResource(id = R.string.details_screen_team),
                        style = MaterialTheme.typography.subtitle1,
                        color = NbaColors.chrome600,
                        fontSize = 20.sp,
                    )

                    Spacer(modifier = Modifier.height(NbaDimensions.sizeXS))
                    NbaText(
                        text = state.player?.team?.full_name.orEmpty(),
                        style = MaterialTheme.typography.h5,
                        color = NbaColors.black,
                        fontWeight = FontWeight.Bold,
                    )
                }
                NbaIcon(
                    icon = R.drawable.arrow,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}
