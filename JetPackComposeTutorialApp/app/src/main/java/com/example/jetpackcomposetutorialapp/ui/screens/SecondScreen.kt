package com.example.jetpackcomposetutorialapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcomposetutorialapp.util.ApiState

@Composable
fun SecondScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    when (val result = mainViewModel.response.value) {
        is ApiState.Success ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Demo of RecyclerView",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )
                LazyColumn {
                    items(result.data) { it ->
                        Text(text = "${it.id}")
                        Text(text = it.body)
                        Divider()
                    }
                }
            }

        is ApiState.Failure -> {
            Text(text = "${result.msg}")
        }
        is ApiState.Loading -> {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(modifier = Modifier)
            }

        }
        is ApiState.Empty -> {

        }
    }


}

class Person() {
    var name: String = "Abcd"
    var contactNumber: String = "1234567890"
    var address: String = "xyz"
    fun displayInfo() = print(
        "\n Name: $name\n " +
                "Contact Number: $contactNumber\n " +
                "Address: $address"
    )

}

fun main() {

//    var  name="jit"
//    val person = name.run {
//
//     "The name of the Person is: $name"
//    }
//    print(person)
//var p:Person?=null
//    val person1 = with(p) {
//        this?.name="jit"
//        return@with "The name of the Person is: ${this?.name}"
//    }
//    println(person1)

    val person: Person? = null
   val p= person?.apply {
        name = "asdf"
        contactNumber = "1234"
        address = "wasd"
        displayInfo()
    }
    println(p)

}