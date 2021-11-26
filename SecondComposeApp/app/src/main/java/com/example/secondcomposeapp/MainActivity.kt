package com.example.secondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.secondcomposeapp.ui.theme.SecondComposeAppTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondComposeAppTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var count = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF546E7A)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${count.value}",style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            ))
            Spacer(modifier = Modifier.height(50.dp))
            createCircle(count.value){
                count.value = it+1
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun createCircle(count: Int=0,updateCount:(Int)->Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateCount(count)
            }, shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SecondComposeAppTheme {
        MyApp()
    }
}