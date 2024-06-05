package com.example.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.digitalartspace.ui.theme.DigitalArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigitalArtspaceTheme {
                Surface {

                }
            }
        }
    }
}

@Composable
fun DigitalArtSpace(){

}

fun Buttons(paintings: List<Painting>, modifier: Modifier=Modifier){
    val total = paintings.size
}

@Composable
fun AuthorInfo(artpiece: String, author: String, year: Int, modifier: Modifier=Modifier){
    val temp_string = author + " (" + year + ")"
    Box(modifier = Modifier){
        Column(){
            Text(text = artpiece)
            Text(text = temp_string)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    DigitalArtspaceTheme {
        AuthorInfo("Test", "Test", 5555)
    }
}