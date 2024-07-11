package com.example.leavemangmtapp.ui.theme.screens.EmployeeProfile

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEEPROFILE
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEESETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_HOME
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_REGISTER
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeProfileScreen(navController:NavHostController) {
    var presses by remember { mutableIntStateOf(0) }
    val mContext = LocalContext.current
    var search by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var mobilenumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val checkedState = remember { mutableStateOf(true) }
    val bitmap =  remember { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? -> imageUri = uri }

    // Remember the state of the button click
    val clicked = remember { mutableStateOf(false) }

    // Update the clicked state when the button is clicked
    val updatedClicked = rememberUpdatedState(clicked.value)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Profile",
                            color = Color.Black,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start=15.dp, top = 10.dp)
                        )
                    }

                }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp)
            )
        },
        bottomBar = {
            BottomAppBar(
                contentColor = Color.Black,
                containerColor = Color.Cyan,
                modifier = Modifier.height(46.dp)
            ) {
                IconButton(
                    onClick = { navController.navigate(ROUTE_HOME) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Dashboard,
                            contentDescription = "Dashboard",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "DASHBOARD",
                            fontWeight = FontWeight.Black,
                            color=Color.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(90.dp) // Adjusted width for fitting
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(ROUTE_APPLY) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "ApplyLeave",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "APPLY LEAVE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(90.dp) // Adjusted width for fitting
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_APPLY) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profile",
                            tint = Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "PROFILE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color=Color.Blue,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(90.dp) // Adjusted width for fitting
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_EMPLOYEESETTINGS) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "SETTINGS",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(90.dp) // Adjusted width for fitting
                        )
                    }
                }
            }

        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Card( colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp, end = 5.dp)
                    .size(width = 360.dp, height = 400.dp)
//                .shadow(elevation = 50.dp, shape = (RoundedCornerShape(15.dp)))
            )
            {
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Employee Information",
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Left,
                    color = Color.Blue,
                    fontSize = 13.sp, fontWeight = FontWeight.Bold,
                )

                //Name
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 15.dp, end = 10.dp),
                    colors = TextFieldDefaults.textFieldColors(),
                    label = {
                        Text(
                            text = "Employee Name",
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    },
                    placeholder = { Text(text = "", fontSize = 13.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                //Address
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 15.dp, end = 10.dp),
                    label = {
                        Text(
                            text = "Employee Address",
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    },
                    placeholder = { Text(text = "", fontSize = 11.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),

                    )
                //DateOfBirth
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = dob,
                    onValueChange = { dob = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 15.dp, end = 10.dp),
                    label = {
                        Text(
                            text = "Date of Birth",
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    },
                    placeholder = { Text(text = "", fontSize = 11.sp) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.EditCalendar,
                            contentDescription = ""
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),

                    )
                //Mobile number
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = mobilenumber,
                    onValueChange = { mobilenumber = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 15.dp, end = 10.dp),
                    label = {
                        Text(
                            text = "Mobile No.",
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    },
                    placeholder = { Text(text = "+254721793739", fontSize = 11.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                //Position
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = designation,
                    onValueChange = { designation = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 15.dp, end = 10.dp),
                    label = {
                        Text(
                            text = "Designation(E.g. Employee,Manager)",
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    },
                    placeholder = { Text(text = "", fontSize = 13.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
//                Spacer(modifier = Modifier.height(10.dp))
//                Text(text = "Leave Approval Rights", fontSize = 20.sp)
//                Text(text = "Able to approve / reject leave requests of")
//                Text(text = "other employees.")
            }

            Spacer(modifier = Modifier.height(1.dp))
            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 20.dp, end = 5.dp)
                    .size(width = 360.dp, height = 150.dp)
            ){
                Text(text = "Credentials",
                    modifier = Modifier
                        .padding(3.dp)
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Left,
                    color = Color.Blue,
                    fontSize = 13.sp, fontWeight = FontWeight.Bold)
                //Email
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 30.dp, end = 20.dp),
                    label = { Text(text = "Email",modifier = Modifier.padding(start = 1.dp)) },
                    placeholder = { Text(text = "", fontSize = 13.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                //Password
                Spacer(modifier = Modifier.height(5.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .size(width = 350.dp, height = 50.dp)
                        .padding(start = 30.dp, end = 20.dp),
                    label = { Text(text = "Password",modifier = Modifier.padding(start = 1.dp))},
                    placeholder = { Text(text = "", fontSize = 11.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EmployeeProfileScreenPreview() {
    EmployeeProfileScreen(navController = rememberNavController())
}