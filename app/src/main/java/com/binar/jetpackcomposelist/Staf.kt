package com.binar.jetpackcomposelist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.binar.jetpackcomposelist.data.ResponseNewsItem
import com.binar.jetpackcomposelist.data.ResponseStafItem
import com.binar.jetpackcomposelist.ui.theme.JetpackComposeListTheme
import com.binar.jetpackcomposelist.viewmodel.NewsViewModel
import com.binar.jetpackcomposelist.viewmodel.StafViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Staf : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val stafViewModel  : StafViewModel = viewModel(modelClass = StafViewModel::class.java)
                    val datastaf by stafViewModel.dataState.collectAsState()
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            judulstaf(name = "")

                        }

                        LazyColumn{
                            if (datastaf.isEmpty()){
                                item {
                                }
                            }

                            items(datastaf){

                                AdapterStaf(staf = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun judulstaf(name:String){
    Row() {
        Column() {
            Text(text = "Staf", Modifier.padding(30.dp), fontSize = 18.sp)
        }
        val context = LocalContext.current
        Column() {
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "icon", modifier = Modifier
                .height(60.dp).fillMaxWidth()
                .padding(top = 20.dp)
                .padding(end = 20.dp)
                .clickable {
                    context.startActivity(Intent(context, MainActivity::class.java))
                },(Alignment.CenterEnd))
        }

    }

}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdapterStaf(staf : ResponseStafItem) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(15.dp)) {
        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier
            .fillMaxWidth()
            .height(80.dp), onClick = {

            val intent = Intent(context, Detail::class.java)
            intent.putExtra("staf", staf)
            context.startActivity(intent)

        }){
            Row() {
                Image(painter = rememberImagePainter(data = staf.image), contentDescription = "")
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)) {
                    Text(text = staf.name, color = Color.Black, fontWeight = FontWeight.Normal, modifier = Modifier.padding(start= 5.dp) )
                    Text(text = staf.email, modifier = Modifier.padding(start = 5.dp))
                    Text(text = staf.createdAt, modifier = Modifier.padding(start = 5.dp))
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeListTheme {
        judulstaf(name = "")
    }
}