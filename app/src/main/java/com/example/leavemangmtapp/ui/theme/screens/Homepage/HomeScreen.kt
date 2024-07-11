package com.example.leavemangmtapp.ui.theme.screens.Homepage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEEPROFILE
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEESETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_HOME

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("PENDING", "APPROVED", "REJECTED")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    var isDialogVisible by remember { mutableStateOf(false) }
    var selectedYear by remember { mutableStateOf(2024) } // Default selected year
    val years = (2020..2026).toList()

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
                            text = "Year $selectedYear", // Display selected year here
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    }
                }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp),
                actions = {
                    IconButton(onClick = { isDialogVisible = true }) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calendar")
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
                            tint = Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "DASHBOARD",
                            fontWeight = FontWeight.Black,
                            color = Color.Blue,
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
                    onClick = { navController.navigate(ROUTE_EMPLOYEEPROFILE) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profile",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "PROFILE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            // Custom Dialog
            if (isDialogVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)) // Background overlay
                        .clickable { isDialogVisible = false }, // Dismiss on click outside
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .background(Color.White)
                            .clickable(enabled = false) {}, // Prevent clicks on the dialog from dismissing it
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TopAppBar(
                            title = { Text("Select Financial Year", color = Color.Black) },
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Cyan),
                        )
                        LazyColumn(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                                .fillMaxWidth()
                                .height(200.dp)
                        ) {
                            items(years) { year ->
                                Text(
                                    text = year.toString(),
                                    fontSize = 20.sp,
                                    color = if (year == selectedYear) Color.Blue else Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                        .fillMaxWidth()
                                        .clickable {
                                            selectedYear = year
                                            isDialogVisible = false
                                        }
                                )
                            }
                        }
                    }
                }
            }

            // Tabs-Pending, Approved, Rejected
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title, color = Color.Black) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }

            // Content for each tab
            when (tabIndex) {
                0 -> PendingScreen(navController)
                1 -> ApprovedScreen(navController)
                2 -> RejectedScreen(navController)
            }
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
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}