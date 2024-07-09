package com.example.leavemangmtapp.ui.theme.screens.Register

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.MainActivity
import com.example.leavemangmtapp.R
import com.example.leavemangmtapp.navigation.ROUTE_ADMINLOGIN
import com.example.leavemangmtapp.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController:NavHostController) {

    val mContext = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier
        .fillMaxSize()) {

        //TopAppBar
        TopAppBar(title = {
            Text(
                text = "Create Admin Account",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 19.sp,
                modifier=Modifier.padding(top=10.dp)
            )
        },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
            modifier= Modifier.height(46.dp),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUTE_ADMINLOGIN)})
                {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "arrowback")
                }
            }
        )
        Spacer(modifier = Modifier.height(130.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.createacct),
                contentDescription = "",
                modifier = Modifier.size(150.dp)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        //Name
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 40.dp, end = 20.dp),
            label = { Text(text = "Name", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your name", fontSize = 11.sp) },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        //Email
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 40.dp, end = 20.dp),
            label = { Text(text = "Email", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your email", fontSize = 11.sp) },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        //Password
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 40.dp, end = 20.dp),
            label = { Text(text = "Password", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Type your password", fontSize = 11.sp) },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        //Phonumber
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = phonenumber,
            onValueChange = { phonenumber = it },
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
                .padding(start = 40.dp, end = 20.dp),
            label = { Text(text = "Contact", fontWeight = FontWeight.Bold) },
            placeholder = { Text(text = "Enter your phonenumber", fontSize = 11.sp) },
            leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, MainActivity::class.java))

            },
            modifier = Modifier
                .size(width = 150.dp, height = 50.dp)
                .padding(start = 20.dp),
            shape = CutCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Cyan),

        ) {

            Text(
                text = "Register",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate(ROUTE_LOGIN) }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Already have an account?",
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Login",
                color = Color.Blue,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {navController.navigate(ROUTE_ADMINLOGIN)})

        }
    }
}





@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(navController = rememberNavController())
}