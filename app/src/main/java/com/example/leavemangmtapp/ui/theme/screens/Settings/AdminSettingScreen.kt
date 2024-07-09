package com.example.leavemangmtapp.ui.theme.screens.Settings

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_ADMINLOGIN
import com.example.leavemangmtapp.navigation.ROUTE_ADMINSETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_LOGIN
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminSettingScreen(navController: NavHostController){

    var presses by remember { mutableIntStateOf(0) }
    val mContext = LocalContext.current
    var search by remember { mutableStateOf("") }
    var showLogoutDialog by remember { mutableStateOf(false) } // State to control dialog visibility
    var showTermsPrivacyDialog by remember { mutableStateOf(false) } // State to control dialog visibility
    var showPasswordDialog by remember { mutableStateOf(false) } // State to control dialog visibility
    var newPassword by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Settings",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top=10.dp)
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
                IconButton(onClick = { navController.navigate(ROUTE_ADMINHOME) }) {
                    Icon(imageVector = Icons.Filled.Checklist, contentDescription = "PendingLeaves", modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "PENDING LEAVES", fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))

                }
                Spacer(modifier = Modifier.width(30.dp))

                IconButton(onClick = { navController.navigate(ROUTE_LEAVEAALOCATION) })  {
                    Icon(imageVector = Icons.Filled.AddToPhotos, contentDescription = "AssignLeaves", modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "ASSIGN LEAVE", fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_ADDEMPLOYEE) }) {
                    Icon(imageVector = Icons.Filled.PersonAdd, contentDescription = "AddEmployee", modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "ADD EMPLOYEE",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_VIEWEMPLOYEES)}) {
                    Icon(imageVector = Icons.Filled.People, contentDescription = "ViewEmployees", modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "VIEW EMPLOYEES",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_ADMINSETTINGS)}) {
                    Icon(imageVector = Icons.Filled.Settings , contentDescription = "Settings",tint = Color.Blue , modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "SETTINGS", fontWeight = FontWeight.Black, fontSize = 9.sp, color =Color.Blue,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
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
            Spacer(modifier = Modifier.height(5.dp))
            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(width = 400.dp, height = 50.dp)
            ) {
                Row {
                    Column {
                        Text(
                            text = "Terms and Privacy Policy",
                            modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold, fontFamily = FontFamily.Default
                        )
                        Text(
                            text = "Read Terms and Privacy Policy",
                            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                            fontSize = 10.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                    Spacer(modifier = Modifier.width(160.dp))
                    IconButton(onClick = {showTermsPrivacyDialog=true}) {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "terms&conditions")

                    }

                    if (showTermsPrivacyDialog) {
                        AlertDialog(
                            onDismissRequest = { showTermsPrivacyDialog = false },
                            title = { Text(text = "Terms and Privacy Policy") },
                            text = {
                                Column {
                                    Text("1. Leave application store application sata on Firebase server.")
                                    Text("2. We are not responsible of lose of data in case of any isssues.")
                                    Text("3. Keep the leave app up to date to enjoy new features.")
                                    // Add more terms and conditions as needed
                                }
                            },
                            confirmButton = {
                                Button(
                                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                                    onClick = { showTermsPrivacyDialog = false }
                                ) {
                                    Text("OK", color=Color.Black)
                                }
                            },
                        )
                    }

                }
            }
            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(width = 400.dp, height = 40.dp)
            ) {
                Row {
                    Text(
                        text = "Change Password",
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold, fontFamily = FontFamily.Default
                    )
                    Spacer(modifier = Modifier.width(220.dp))
                    IconButton(onClick = {showPasswordDialog=true}) {
                        Icon(imageVector = Icons.Filled.ArrowForwardIos, contentDescription = "changepassword")

                    }
                    if (showPasswordDialog) {
                        AlertDialog(
                            onDismissRequest = { showPasswordDialog = false },
                            title = { Text(text = "Change Pasword") },
                            text = {
                                Column {
                                    Text("Please enter your new password:")
                                    Spacer(modifier = Modifier.height(8.dp))
                                    TextField(
                                        value = newPassword,
                                        onValueChange = { newPassword = it },
                                        trailingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                        placeholder = { Text("New Password") },
                                        singleLine = true
                                    )
                                }
                            },
                            confirmButton = {
                                Button(
                                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                                    onClick = {
                                        showPasswordDialog = false
                                        // Handle password change logic here
                                    }
                                ) {
                                    Text("Change", color=Color.Black)
                                }
                            },
                            dismissButton = {
                                Button(
                                    colors = ButtonDefaults.buttonColors(Color.Red),
                                    onClick = { showPasswordDialog = false }
                                ) {
                                    Text("No")
                                }
                            }
                        )
                    }

                }
            }


            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(width = 400.dp, height = 40.dp)
            ) {
                Row {
                    Text(
                        text = "Log Out",
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold, fontFamily = FontFamily.Default
                    )
                    Spacer(modifier = Modifier.width(290.dp))
                    IconButton(onClick = {showLogoutDialog=true}) {
                        Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "logout")

                    }
                    if (showLogoutDialog) {
                        AlertDialog(
                            onDismissRequest = { showLogoutDialog = false },
                            title = { Text(text = "Confirm") },
                            text = { Text("Are you sure you want to log out?") },
                            confirmButton = {
                                Button(
                                    colors = ButtonDefaults.buttonColors(Color.Cyan),
                                    onClick = {
                                        showLogoutDialog=false
                                        navController.navigate(ROUTE_ADMINLOGIN)
                                        // Handle logout logic here
                                    }
                                ) {
                                    Text("Yes", color = Color.Black)
                                }
                            },
                            dismissButton = {
                                Button(
                                    colors = ButtonDefaults.buttonColors(Color.Red),
                                    onClick = { showLogoutDialog = false }
                                ) {
                                    Text("No")
                                }
                            }
                        )
                    }

                }
            }
            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(width = 400.dp, height = 200.dp)
            ){
                Text(text = "Extra",
                    modifier = Modifier.
                    padding(start = 5.dp, top = 10.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default)
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = "Rate Us",
                        modifier = Modifier.
                        padding(start = 5.dp, top = 5.dp),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(300.dp))
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = "like")

                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row {
                    Text(text = "Feedback", modifier = Modifier.
                    padding(start = 5.dp, top= 5.dp) ,
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(280.dp))
                    IconButton(onClick = {val feedbackIntent = Intent(Intent.ACTION_SEND)
                        feedbackIntent.type = "text/email" // You can use "message/rfc822" for email MIME type
                        feedbackIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("your@email.com"))
                        feedbackIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Salma's Leave app")
                        feedbackIntent.putExtra(Intent.EXTRA_TEXT, "Dear Developer,\n\nI would like to share the following feedback:\n\n")
                        mContext.startActivity(Intent.createChooser(feedbackIntent, "Send Feedback"))}) {
                        Icon(imageVector = Icons.Filled.Quiz, contentDescription = "feedback")

                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Row {
                    Text(text = "Share App", modifier = Modifier.
                    padding(start = 5.dp, top= 5.dp) ,
                        fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(275.dp))
                    IconButton(onClick = {val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "CHECK OUT THIS IS MY LEAVE APP")
                        mContext.startActivity(Intent.createChooser(shareIntent, "Share")) }) {
                        Icon(imageVector = Icons.Filled.Share, contentDescription = "shareapp")

                    }
                }
            }
            Card (colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(width = 400.dp, height = 120.dp)
            ){
                Text(text = "About Me",
                    modifier = Modifier.
                    padding(start = 5.dp, top = 10.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default,
                    color = Color.Blue
                )
                Row {
                    Text(text = "Developed by", modifier = Modifier.padding(start = 5.dp, top= 5.dp) , color = Color.Gray)
                    Spacer(modifier = Modifier.width(160.dp))
                    Text(text = "Salma Sirat", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.ExtraBold,modifier = Modifier.padding(start = 5.dp, top= 5.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = "Contact", modifier = Modifier.padding(start = 5.dp, top= 5.dp) , color = Color.Gray)
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "0721793739", fontFamily = FontFamily.Monospace, fontWeight = FontWeight.ExtraBold,modifier = Modifier.padding(start = 5.dp, top= 5.dp))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AdminSettingScreenPreview(){
    AdminSettingScreen(navController = rememberNavController())

}