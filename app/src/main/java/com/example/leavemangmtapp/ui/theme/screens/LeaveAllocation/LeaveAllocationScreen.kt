package com.example.leavemangmtapp.ui.theme.screens.LeaveAllocation

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_ADMINSETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaveAllocationScreen(navController:NavHostController) {
    var presses by remember { mutableIntStateOf(0) }
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
                            text = "Leave Allocation",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top=10.dp)
                        )
                    }

                }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp),
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
                modifier = Modifier.height(50.dp) // Adjusted height for better fitting
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
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "PENDING LEAVES",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color=Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp) // Adjusted width for fitting
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
                            tint=Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ASSIGN LEAVE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color=Color.Blue,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp) // Adjusted width for fitting
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
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ADD EMPLOYEE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color=Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(80.dp) // Adjusted width for fitting
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
                            modifier = Modifier.width(80.dp) // Adjusted width for fitting
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
                            modifier = Modifier.width(80.dp) // Adjusted width for fitting
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
            Text(
                modifier = Modifier.padding(8.dp),
                text =""
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LeaveAllocationPreview() {
    LeaveAllocationScreen(navController = rememberNavController())
}