package com.example.leavemangmtapp.ui.theme.screens.AdminHomePage

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_ADMINSETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomepageScreen(navController:NavHostController) {

    var presses by remember { mutableIntStateOf(0) }
    val mContext = LocalContext.current
    var search by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Pending Leaves",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top=10.dp)
                        )
//                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Year 2024",
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    }

                }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp),
                        actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "calender")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                contentColor = Color.Black,
                containerColor = Color.Cyan,
                modifier = Modifier.height(46.dp)
            ) {
                IconButton(onClick = { navController.navigate(ROUTE_ADMINHOME) }) {
                    Icon(imageVector = Icons.Filled.Checklist, contentDescription = "PendingLeaves", tint = Color.Blue,modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "PENDING LEAVES", color = Color.Blue, fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))

                }
                Spacer(modifier = Modifier.width(30.dp))

                IconButton(onClick = { navController.navigate(ROUTE_LEAVEAALOCATION) })  {
                    Icon(imageVector = Icons.Filled.AddToPhotos, contentDescription = "AssignLeaves", modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "ASSIGN LEAVE", fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_ADDEMPLOYEE)}) {
                    Icon(imageVector = Icons.Filled.PersonAdd, contentDescription = "AddEmployee", modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "ADD EMPLOYEE",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_VIEWEMPLOYEES)}) {
                    Icon(imageVector = Icons.Filled.People, contentDescription = "ViewEmployees", modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "VIEW EMPLOYEES",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate(ROUTE_ADMINSETTINGS)}){
                    Icon(imageVector =Icons.Filled.Settings , contentDescription = "Settings", modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "SETTINGS", fontWeight = FontWeight.Black, fontSize = 9.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }
            }

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }, containerColor = Color.Cyan) {
                Icon(Icons.Default.CalendarMonth, contentDescription = "Calendar")

            }

        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminHomepageScreenPreview() {
    AdminHomepageScreen(navController = rememberNavController())
}