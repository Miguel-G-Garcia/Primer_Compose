package com.example.primercompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import java.util.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import coil.compose.rememberImagePainter
import coil.annotation.ExperimentalCoilApi
import com.example.primercompose.ui.theme.PrimerComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.UUID

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PrimerComposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					Screen()
				}
			}
		}
	}
}

//@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun itemView(){
	
	Box(modifier = Modifier
		.fillMaxSize()){
		Text(
			text = "Hello Android",
			modifier = Modifier
				.clickable {
				
				}
				.border(2.dp, Color.Blue)
				.background(Color.Yellow)
				.padding(horizontal = 16.dp, vertical = 8.dp)
				.background(Color.Gray)
				.border(width = 2.dp, color = Color.Red)
				.background(Color.Gray)
		
		
		)
	}
	
}



@Preview(showBackground = true)
@Composable
fun Screen(){
	Column(modifier = Modifier.fillMaxSize()) {
		Greeting(name ="Android", modifier = Modifier
			.background(Color.Green))
		VerticalCycle()
	}

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun VerticalCycle() {
	LazyColumn(
		modifier = Modifier.fillMaxSize()
	) {
		items(20) { index ->
			// Aquí puedes colocar cualquier contenido que desees repetir en el ciclo
			Text(
				text = "Imagen $index",
				modifier = Modifier.padding(16.dp)
			)
			val imageUrl = remember { "https://picsum.photos/400/300?random=${UUID.randomUUID()}" }
			
			androidx.compose.foundation.Image(
				painter = rememberImagePainter(imageUrl),
				contentDescription = "Imagen del artículo",
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.fillMaxWidth()
					.height(200.dp)
			)
		}
	}
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}
