package com.example.leavemangmtapp.ui.theme.screens.Login

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.R
import com.example.leavemangmtapp.navigation.ROUTE_ADMINLOGIN
import com.example.leavemangmtapp.navigation.ROUTE_HOME
import com.example.leavemangmtapp.navigation.ROUTE_LOGIN
import com.example.leavemangmtapp.navigation.ROUTE_REGISTER


@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    val mContext = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Remember the state of the button click
    val clicked = remember { mutableStateOf(false) }

    // Update the clicked state when the button is clicked
    val updatedClicked = rememberUpdatedState(clicked.value)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(modifier = Modifier.height(150.dp))

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.employeelogin),
                contentDescription = "",
                modifier = Modifier.size(130.dp)
            )

        }
        //Admin login button
        Row {
            Button(
                onClick = { navController.navigate(ROUTE_ADMINLOGIN)
                    // Toggle the clicked state when the button is clicked
                    clicked.value = !updatedClicked.value},
                modifier = Modifier
                    .size(width = 170.dp, height = 50.dp)
                    .clickable { clicked.value = !clicked.value } // Toggle clicked state when clicked
//                    .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .padding(start = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent, // Set button background color
                    contentColor = Color.Black // Set button text color
                ),
                border = BorderStroke(3.dp, Color.Black)
            ) {

                Text(
                    text = "Admin",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(2.dp))

            //Employee login Button
            Button(
                onClick = { navController.navigate(ROUTE_LOGIN)
                    // Toggle the clicked state when the button is clicked
                    clicked.value = !updatedClicked.value },
                modifier = Modifier
                    .size(width = 170.dp, height = 50.dp)
                    .clickable { clicked.value = !clicked.value } // Toggle clicked state when clicked
//                    .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .padding(start = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Cyan, // Set button background color
                    contentColor = Color.Black // Set button text color
                ),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text(
                    text = "Employee",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp),
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                .shadow(5.dp, shape = CutCornerShape(5.dp))
                .width(400.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Welcome! Please log in to proceed",
                modifier = Modifier.padding(start = 30.dp, bottom = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start=50.dp, end = 50.dp, top = 20.dp, bottom = 20.dp)
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "emailIcon")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Cyan,
                        containerColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "passwordIcon")
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Cyan,
                        containerColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

            }

        }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { navController.navigate(ROUTE_HOME) },
                modifier = Modifier
                    .size(width = 150.dp, height = 50.dp)
                    .padding(start = 20.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(Color.Cyan)
            ) {

                Text(
                    text = "Login",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
    }

}


@Preview
@Composable
fun LoginScreeenPreview() {
    LoginScreen(navController = rememberNavController())
}