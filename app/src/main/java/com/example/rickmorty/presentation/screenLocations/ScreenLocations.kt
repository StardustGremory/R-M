package com.example.rickmorty.presentation.screenLocations

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import coil.compose.rememberAsyncImagePainter
import com.example.rickmorty.data.modelRealm.CharacterModel


@Composable
fun ScreenLocations(screenLocationsVModel: ScreenLocationsVModel) {
    Column(Modifier.fillMaxSize().padding(bottom = 50.dp)) {
        Text(fontSize = 32.sp, text = "Locations and Residents: ")

        val list: List<CharacterModel> = screenLocationsVModel.listLocations
        val showDialog by screenLocationsVModel.showD.observeAsState(true)

        if (showDialog){
            CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally).padding(top = 48.dp))
            screenLocationsVModel.callGetList()
            screenLocationsVModel.callReadList()
        }else{
            LazyColumn {
                items(list){ item->
                    ListLocations(item)
                }
            }
        }
    }
}

@Composable
fun ListLocations(item: CharacterModel) {
    Card(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(top = 24.dp),
        border = BorderStroke(2.dp, Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Row {
            Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = "Card view",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(100.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
            )
            Column {
                Text(
                    text = "Resident: ${item.name}",
                    modifier = Modifier
                        .padding(4.dp),
                    maxLines = 1,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Name Location: ${item.nameLocation}",
                    modifier = Modifier
                        .padding(4.dp),
                    maxLines = 2,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Type: ${item.type}",
                    modifier = Modifier
                        .padding(4.dp),
                    maxLines = 2,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Created: ${item.created}",
                    modifier = Modifier
                        .padding(4.dp),
                    maxLines = 2,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Dimension: ${item.dimension}",
                    modifier = Modifier
                        .padding(4.dp),
                    maxLines = 2,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}