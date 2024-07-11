package com.example.leavemangmtapp.ui.theme.screens.AdminHomePage

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.focus.focusRequester
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomepageScreen(navController: NavHostController) {
    var presses by remember { mutableStateOf(0) }
    val mContext = LocalContext.current
    var search by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    var isDialogVisible by remember { mutableStateOf(false) }
    var selectedYear by remember { mutableStateOf(2024) } // Default selected year
    val years = (2020..2026).toList()
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(isSearchActive) {
        if (isSearchActive) {
            focusRequester.requestFocus()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Pending Leaves",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = "Year $selectedYear", // Display selected year here
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(50.dp),
                actions = {
                    if (isSearchActive) {
                        androidx.compose.material3.TextField(
                            value = search,
                            onValueChange = { search = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester),
                            placeholder = { Text(text = "Search...") },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Search
                            ),
                            keyboardActions = KeyboardActions(
                                onSearch = {
                                    // Handle search action here
                                }
                            )
                        )
                    } else {
                        IconButton(onClick = { isSearchActive = true }) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                contentColor = Color.Black,
                containerColor = Color.Cyan,
                modifier = Modifier.height(50.dp)
            ) {
                IconButton(
                    onClick = { navController.navigate(ROUTE_ADMINHOME) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Checklist,
                            contentDescription = "PendingLeaves",
                            tint = Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "PENDING LEAVES",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color = Color.Blue,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_LEAVEAALOCATION) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddToPhotos,
                            contentDescription = "AssignLeaves",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ASSIGN LEAVE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_ADDEMPLOYEE) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PersonAdd,
                            contentDescription = "AddEmployee",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ADD EMPLOYEE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_VIEWEMPLOYEES) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.People,
                            contentDescription = "ViewEmployees",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "VIEW EMPLOYEES",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }

                IconButton(
                    onClick = { navController.navigate(ROUTE_ADMINSETTINGS) },
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "SETTINGS",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp)
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isDialogVisible = true },
                containerColor = Color.Cyan
            ) {
                Icon(Icons.Default.CalendarMonth, contentDescription = "Calendar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = ""
            )

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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdminHomepageScreenPreview() {
    AdminHomepageScreen(navController = rememberNavController())
}