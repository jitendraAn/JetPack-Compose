package com.example.jetpackcomposetutorialapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcomposetutorialapp.R
import com.example.jetpackcomposetutorialapp.util.DataSources
import com.example.jetpackcomposetutorialapp.util.NavigationScreen
import com.example.jetpackcomposetutorialapp.util.dataList

@Composable
fun MainScreen(navController: NavHostController) {
    var checked by remember {
        mutableStateOf(false)
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Main Screen")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "add")

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        ) {
            Row(

                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("MainScreen")
                Switch(checked = checked, onCheckedChange = {
                    checked = it
                },
                modifier = Modifier.padding(8.dp)
                    )
            }

            Recyclerview(dataList(),navController)
//            Button(onClick = { }) {
//                Text("Click Here")
//            }
        }
    }

}


@Composable
fun EachRow(dataSources: DataSources,navController: NavHostController) {
    return Card(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp).fillMaxWidth().clickable {
            navController.navigate(NavigationScreen.SecondScreen.route)
        },
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 2.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            dataSources.title?.let { Text(text = it, modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp)) }
        }

    }
}

@Composable
fun Recyclerview(data:List<DataSources>,navController: NavHostController) {
    LazyColumn{
        items(data){user->
            EachRow(user,navController)
        }
    }

}
