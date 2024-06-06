package com.example.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalartspace.ui.theme.DigitalArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigitalArtspaceTheme {
                Surface {
                    val paintings = DataSource().loadPainting()
                    DigitalArtSpace(paintings)
                }
            }
        }
    }
}



@Composable
fun DigitalArtSpace(paintings: List<Painting>, modifier: Modifier = Modifier){
    var imageSource by remember { mutableStateOf(1)}
    Column (modifier = Modifier.fillMaxWidth()){
        Image(painter = painterResource(paintings[imageSource].imageResourceid),
            contentDescription = stringResource(paintings[imageSource].title),
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(top = 30.dp),
            contentScale = ContentScale.FillBounds)
        Spacer(modifier.height(30.dp))
        AuthorInfo(artpiece = stringResource(paintings[imageSource].title),
            author = stringResource(paintings[imageSource].description),
            year = stringResource(paintings[imageSource].year))
        Spacer(modifier.height(30.dp))
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(onClick = { imageSource = (imageSource-1)%paintings.size
                if(imageSource < 0){
                    imageSource = paintings.size-1
                }

            }){ Text(
                text = stringResource(R.string.back_btn),
                fontSize = 24.sp)}
            Spacer(modifier = modifier.padding(16.dp))
            Button(onClick = { imageSource = (imageSource+1)%paintings.size }) {
                Text(
                    text = stringResource(R.string.next_btn),
                    fontSize = 24.sp)}
            }
    }
}



@Composable
fun AuthorInfo(artpiece: String, author: String, year: String, modifier: Modifier=Modifier){
    val temp_string = author + " (" + year + ")"
    Box(modifier = Modifier){
        Column(modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = artpiece,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold)
            Text(text = temp_string,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    DigitalArtspaceTheme {
        AuthorInfo("Test", "Test", "5555")
    }
}