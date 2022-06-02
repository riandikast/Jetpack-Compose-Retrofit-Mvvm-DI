package com.binar.jetpackcomposelist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import com.binar.jetpackcomposelist.data.ResponseStafItem
import com.binar.jetpackcomposelist.ui.theme.JetpackComposeListTheme

class Detail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val getnews =  intent?.getParcelableExtra<ResponseNewsItem>("news")
                    val getstaf =  intent?.getParcelableExtra<ResponseStafItem>("staf")
                    if (getnews!= null){
                        Greeting2(getnews)
                    }
                    if (getstaf!= null){
                        Greeting22(getstaf)
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting2(getnews : ResponseNewsItem) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detail", Modifier.padding(30.dp))
        Text(text = getnews.title, Modifier.padding(10.dp))
        Image(painter = rememberImagePainter(data = getnews.image), contentDescription = "icon", Modifier.padding(bottom = 20.dp) )
        Text(text = getnews.description, Modifier.padding(10.dp))

    }
}

@Composable
fun Greeting22(getstaf : ResponseStafItem) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Detail", Modifier.padding(30.dp))
        Text(text = getstaf.name, Modifier.padding(10.dp))
        Image(painter = rememberImagePainter(data = getstaf.image), contentDescription = "icon", Modifier.padding(bottom = 20.dp) )
        Text(text = getstaf.email, Modifier.padding(10.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeListTheme {

    }
}