package com.example.leavemangmtapp.ui.theme.screens.Homepage

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.Pager
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEEPROFILE
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEESETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_HOME
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen (navController:NavHostController) {

    val mContext = LocalContext.current
//    var presses by remember { mutableIntStateOf(0) }
//    var search by remember { mutableStateOf("") }
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("PENDING", "APPROVED", "REJECTED")
    val pagerState = rememberPagerState(pageCount = { tabs.size })


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Dashboard",
                            color = Color.Black,
                            fontSize = 18.sp,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
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
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
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
                IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                    Icon(imageVector = Icons.Filled.Dashboard, contentDescription = "Dashboard", tint = Color.Blue , modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "DASHBOARD", fontWeight = FontWeight.Black,fontSize = 10.sp, color=Color.Blue,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))

                }
                Spacer(modifier = Modifier.width(60.dp))

                IconButton(onClick = { navController.navigate(ROUTE_APPLY) })  {
                    Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "ApplyLeaves", tint = Color.Black , modifier = Modifier.padding(bottom = 20.dp))
                    Text(text = "APPLY LEAVE",color = Color.Black, fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(60.dp))
                IconButton(onClick = { navController.navigate(ROUTE_EMPLOYEEPROFILE)}) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile",  tint = Color.Black ,modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "PROFILE",color = Color.Black,fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }

                Spacer(modifier = Modifier.width(60.dp))
                IconButton(onClick = { navController.navigate(ROUTE_EMPLOYEESETTINGS)}) {
                    Icon(imageVector =Icons.Filled.Settings , contentDescription = "Settings",  tint = Color.Black ,modifier = Modifier.padding(bottom = 15.dp))
                    Text(text = "SETTINGS",color = Color.Black, fontWeight = FontWeight.Black, fontSize = 9.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
                }
            }

        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(title, color = Color.Black)},
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
//            when (tabIndex) {
//                0 -> PendingScreen()
//                1 -> ApproveScreen()
//                2 -> RejectScreen()
//            }

            // Use Pager to enable swiping between tabs
//            Pager(
//                state = pagerState,
//                modifier = Modifier.weight(1f)
//            ) { page ->
//                when (tabs[page]) {
//                    "PENDING" -> PendingScreen()
//                    "APPROVE" -> ApproveScreen()
//                    "REJECT" -> RejectScreen()
//                    else -> Text("Not implemented")
//                }
//            }

        }
    }

}

@Composable
fun PendingScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Pending Screen Content", modifier = Modifier.padding(16.dp))
    }

}

@Composable
fun ApprovedScreen(navController: NavHostController) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Text(text = "Approved Screen Content", modifier = Modifier.padding(16.dp))
        }
    }

@Composable
fun RejectedScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Rejected Screen Content", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun homeScreenPreiew() {
    HomeScreen(navController = rememberNavController())
}





