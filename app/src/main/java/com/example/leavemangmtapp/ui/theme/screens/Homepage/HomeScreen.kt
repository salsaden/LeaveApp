package com.example.leavemangmtapp.ui.theme.screens.Homepage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEEPROFILE
import com.example.leavemangmtapp.navigation.ROUTE_EMPLOYEESETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_HOME
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalPagerApi::class
)
@Composable
fun HomeScreen(navController: NavHostController) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("PENDING", "APPROVED", "REJECTED")
    val pagerState = rememberPagerState(initialPage = 0)
    var isDialogVisible by remember { mutableStateOf(false) }
    var selectedYear by remember { mutableStateOf(2024) }
    val years = (2020..2026).toList()
    val coroutineScope = rememberCoroutineScope()

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
                            text = "Year $selectedYear",
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            modifier = Modifier.width(90.dp)
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(ROUTE_APPLY) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            modifier = Modifier.width(90.dp)
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(ROUTE_EMPLOYEEPROFILE) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            modifier = Modifier.width(90.dp)
                        )
                    }
                }
                IconButton(
                    onClick = { navController.navigate(ROUTE_EMPLOYEESETTINGS) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            modifier = Modifier.width(90.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (isDialogVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                        .clickable { isDialogVisible = false },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                            .background(Color.White),
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

            Column {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        )
                    }
                }
                HorizontalPager(
                    count = tabs.size,
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    when (page) {
                        0 -> PendingScreen(navController)
                        1 -> ApprovedScreen(navController)
                        2 -> RejectedScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun PendingScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Pending Screen Content", modifier = Modifier.padding(16.dp))
        Text(text = "Pending Screen Content", modifier = Modifier.padding(16.dp))
        Text(text = "Pending Screen Content", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ApprovedScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Approved Screen Content", modifier = Modifier.padding(16.dp))
        Text(text = "Not Approved", modifier = Modifier.padding(16.dp))
        Text(text = "Checking", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RejectedScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Rejected Screen Content", modifier = Modifier.padding(16.dp))
        Text(text = "Rejected Screen Content", modifier = Modifier.padding(16.dp))
        Text(text = "Rejected Screen Content", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
