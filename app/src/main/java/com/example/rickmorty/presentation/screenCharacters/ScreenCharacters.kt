package com.example.rickmorty.presentation.screenCharacters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rickmorty.data.model.ModelCharacter


@Composable
fun ScreenCharacters(screenCharactersVModel: ScreenCharactersVModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
    ) {
        Text(fontSize = 32.sp, text = "Characters: ")
        val list: List<ModelCharacter> = screenCharactersVModel.listCharacters
        val showDialog by screenCharactersVModel.showD.observeAsState(true)

        if (showDialog){
            CircularProgressIndicator(Modifier.align(Alignment.CenterHorizontally).padding(top = 48.dp))
            screenCharactersVModel.callGetList()
        }else{
            LazyColumn {
                items(list){ item->
                    ListCharacters(item)
                }
            }
        }
    }
}

@Composable
fun ListCharacters(item: ModelCharacter) {
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
            )
            Column {
                Text(
                    text = "Name: ${item.name}",
                    modifier = Modifier
                        .padding(8.dp),
                    maxLines = 1,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Specie: ${item.species}",
                    modifier = Modifier
                        .padding(8.dp),
                    maxLines = 1,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Gender: ${item.gender}",
                    modifier = Modifier
                        .padding(8.dp),
                    maxLines = 1,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Location: ${item.location}",
                    modifier = Modifier
                        .padding(8.dp),
                    maxLines = 1,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
