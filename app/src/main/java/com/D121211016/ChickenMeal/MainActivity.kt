package com.D121211016.ChickenMeal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211016.ChickenMeal.data.models.Article
import com.D121211016.ChickenMeal.ui.theme.D121211016CHICKENMEALTheme
import com.D121211016.ChickenMeal.ui.theme.MainUiState
import com.D121211016.ChickenMeal.ui.theme.MainViewModel


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
            D121211016CHICKENMEALTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListFoodsScreen(mainViewModel.mainUiState)
                }
            }
        }
    }

    @Composable
    private fun ListFoodsScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> Text(text = "Sedang Loading", fontSize = 16.sp)
            is MainUiState.Error -> Text(text = "Terjadi Error", fontSize = 16.sp)
            is MainUiState.Success -> ListFoods(mainUiState.foods)
        }
    }

    @Composable
    fun ListFoods(chickenFood: List<Article>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(chickenFood) { makan ->
                makanEnak(makan = makan)
            }
        }
    }



    @Composable
    fun makanEnak(makan: Article) {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp),)
                .clickable {
                    val intent = Intent(this, DetailActivities::class.java)
                    intent.putExtra("Ayam", makan)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Character Image
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(makan.strMealThumb)
                        .crossfade(true)
                        .build(),
                    contentDescription = makan.strMeal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                // Character Details
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = makan.strMeal ?: "Unknown",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black // Set text color to black for clarity
                )
            }
        }
    }
}

