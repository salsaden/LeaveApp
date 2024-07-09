import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leavemangmtapp.navigation.ROUTE_HOME

//package com.example.leavemangmtapp.ui.theme.screens
//
//import android.content.Intent
//import android.provider.Settings
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Dashboard
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.leavemangmtapp.navigation.ROUTE_APPLY
//import com.example.leavemangmtapp.navigation.ROUTE_HOME
//
//Column(modifier = Modifier.fillMaxSize()) {
//
//    //TopAppBar
//    TopAppBar(title = {
//        Column {
//            Text(
//                text = "Dashboard",
//                color = Color.Black,
//                fontSize = 25.sp,
//            )
//            Spacer(modifier = Modifier.height(5.dp))
//            Text(
//                text = "Year 2024",
//                color = Color.DarkGray,
//                fontSize = 15.sp
//            )
//        }
//
//    }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
//        actions = {
//            IconButton(onClick = { val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
//                mContext.startActivity(calenderIntent)}) {
//                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
//            }
//        })
//    Spacer(modifier = Modifier.height(20.dp))
//    Row(modifier = Modifier.padding(start = 30.dp, end = 5.dp)) {
//        //First Column
//        Column(modifier = Modifier.size(width = 100.dp, height = 630.dp)) {
//            Text(text = "PENDING", fontSize = 15.sp, fontFamily = FontFamily.Monospace)
//        }
//        Spacer(modifier = Modifier.width(30.dp))
//        //Second Column
//        Column(modifier = Modifier.size(width = 100.dp, height = 630.dp)) {
//            Text(text = "APPROVED", fontSize = 15.sp, fontFamily = FontFamily.Monospace)
//        }
//        Spacer(modifier = Modifier.width(30.dp))
//        //Third Column
//        Column(modifier = Modifier.size(630.dp)) {
//            Text(text = "REJECTED", fontSize = 15.sp, fontFamily = FontFamily.Monospace)
//        }
//    }
////        Spacer(modifier = Modifier.height(600.dp))
//
//
//    BottomAppBar(modifier = Modifier.padding(top = 65.dp), actions = {
//        IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
//        Icon(imageVector = Icons.Filled.Dashboard , contentDescription = "Dashboard", modifier = Modifier.padding(bottom = 20.dp))
//        Text(text = "DASHBOARD", fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//    }
//        Spacer(modifier = Modifier.width(60.dp))
//
//        IconButton(onClick = { navController.navigate(ROUTE_APPLY) })  {
//            Icon(imageVector = Icons.Filled.Add, contentDescription = "Apply Leave", modifier = Modifier.padding(bottom = 20.dp))
//            Text(text = "APPLY", fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//
//
//        Spacer(modifier = Modifier.width(60.dp))
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.padding(bottom = 15.dp))
//            Text(text = "PROFILE",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//
//        Spacer(modifier = Modifier.width(60.dp))
//        IconButton(onClick = { val settingsIntent= Intent(Settings.ACTION_SETTINGS)
//            mContext.startActivity(settingsIntent)}) {
//            Icon(imageVector = Icons.Filled.Settings , contentDescription = "Settings", modifier = Modifier.padding(bottom = 15.dp))
//            Text(text = "SETTING", fontWeight = FontWeight.Black, fontSize = 9.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//    })
//
//
//}



//SALMA ADEN SALMA ADEN SALMA ADEN


//Column(modifier = Modifier.fillMaxSize()) {
//    //TopAppBar
//    TopAppBar(title = {
//        Column {
//            Text(
//                text = "New Leave Application",
//                color = Color.Black,
//                fontSize = 18.sp,
//            )
//            Spacer(modifier = Modifier.height(5.dp))
//            Text(
//                text = "Year 2024",
//                color = Color.DarkGray,
//                fontSize = 15.sp
//            )
//        }
//
//    }, colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
//        actions = {
//            IconButton(onClick = {
//                val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
//                mContext.startActivity(calenderIntent)
//            }) {
//                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
//            }
//        })
//
//    OutlinedTextField(
//        value = selectedOption,
//        onValueChange = { selectedOption = it },
//        label = { Text(text = "Leave Type") },
//        placeholder = { Text(text = "Select Leave Type") },
//        readOnly = true,
//        modifier = Modifier
//            .size(400.dp, 90.dp)
//            .padding(15.dp)
//            .clickable(onClick = { expanded = true })
//    )
//    Row {
//        Button(
//            onClick = {
//                val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
//                mContext.startActivity(calenderIntent)
//            },
//            modifier = Modifier
//                .size(width = 200.dp, height = 50.dp)
////                .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
//                .padding(start = 20.dp),
//            shape = CutCornerShape(5.dp),
////                colors = ButtonDefaults.buttonColors(Color.Transparent)
//            colors = ButtonDefaults.buttonColors(
//                Color.Transparent, // Set button background color
//                contentColor = Color.Black // Set button text color
//            ),
//            border = BorderStroke(3.dp, Color.Black)
//        ) {
//            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
//            Text(text = " From Date", fontSize = 15.sp, color = Color.Gray)
//
//        }
//        Spacer(modifier = Modifier.width(5.dp))
//        Button(
//            onClick = {
//                val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
//                mContext.startActivity(calenderIntent)
//            },
//            modifier = Modifier
//                .size(width = 200.dp, height = 50.dp)
////                .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
//                .padding(end = 20.dp),
//            shape = CutCornerShape(5.dp),
////                colors = ButtonDefaults.buttonColors(Color.Transparent)
//            colors = ButtonDefaults.buttonColors(
//                Color.Transparent, // Set button background color
//                contentColor = Color.Black // Set button text color
//            ),
//            border = BorderStroke(3.dp, Color.Black)
//        ) {
//            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
//            Text(text = " To Date", fontSize = 15.sp, color = Color.Gray)
//
//        }
//    }
//    TextField(value = textValue, onValueChange = {textValue=it},
//        label = { Text("Enter reason", fontSize = 13.sp) },
//        modifier = Modifier
//            .background(color = Color.White)
//            .size(400.dp, 120.dp)
//            .padding(15.dp))
//
//    Spacer(modifier = Modifier.height(10.dp))
//
//    OutlinedTextField(
//        value = selectedOption,
//        onValueChange = { selectedOption = it },
//        placeholder = { Text(text = "Send Request to (For Approval)") },
//        readOnly = true,
//        modifier = Modifier
//            .size(400.dp, 80.dp)
//            .padding(11.dp)
//            .clickable(onClick = { expanded = true })
//    )
//    //Apply leave button
//    Spacer(modifier = Modifier.height(30.dp))
//    Button(
//        onClick = { navController.navigate(ROUTE_HOME) },
//        modifier = Modifier
//            .size(width = 350.dp, height = 50.dp)
//            .padding(start = 10.dp, end = 10.dp)
//            .align(Alignment.CenterHorizontally),
//        shape = CutCornerShape(5.dp),
//        colors = ButtonDefaults.buttonColors(Color.Cyan)
//    ) {
//
//        Text(
//            text = "Apply Leave",
//            color = Color.Black,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//
//
//
////        DropdownMenu(
////            expanded = expanded,
////            onDismissRequest = { expanded = false },
////            modifier = Modifier.padding(16.dp)
////        ) {
////            options.forEach { option ->
////                DropdownMenuItem(onClick = {
////                    selectedOption = option
////                    expanded = false
////                }){
////                    Text(text = option)
////                }
////            }
////        }
//
//    Spacer(modifier = Modifier.height(200.dp))
//
//
//    BottomAppBar(modifier = Modifier.padding(top = 65.dp), actions = {
//        IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
//            Icon(imageVector = Icons.Filled.Home , contentDescription = "Dashboard", modifier = Modifier.padding(bottom = 20.dp))
//            Text(text = "HOME", fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//        Spacer(modifier = Modifier.width(60.dp))
//
//        IconButton(onClick = { /*TODO*/ })  {
//            Icon(imageVector = Icons.Filled.Add, contentDescription = "Apply Leave", modifier = Modifier.padding(bottom = 20.dp))
//            Text(text = "APPLY", fontWeight = FontWeight.Black,fontSize = 10.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//
//
//        Spacer(modifier = Modifier.width(60.dp))
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", modifier = Modifier.padding(bottom = 15.dp))
//            Text(text = "PROFILE",fontWeight = FontWeight.Black,fontSize = 10.sp,textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//
//        Spacer(modifier = Modifier.width(60.dp))
//        IconButton(onClick = { val settingsIntent= Intent(Settings.ACTION_SETTINGS)
//            mContext.startActivity(settingsIntent)}) {
//            Icon(imageVector = Icons.Filled.Settings , contentDescription = "Settings", modifier = Modifier.padding(bottom = 15.dp))
//            Text(text = "SETTING", fontWeight = FontWeight.Black, fontSize = 9.sp, textAlign = TextAlign.Justify,modifier = Modifier.padding(top = 25.dp))
//        }
//    })
//}


//sWIPE SWIPE SWIPE SWIPE



//    var tabIndex by remember { mutableStateOf(0) }
//    val tabs = listOf("Home", "About", "Settings")
//
//        TabRow(selectedTabIndex = tabIndex) {
//            tabs.forEachIndexed { index, title ->
//                Tab(text = { Text(title) },
//                    selected = tabIndex == index,
//                    onClick = { tabIndex = index }
//                )
//            }
//        }
//        when (tabIndex) {
//            0 -> HomeScreen()
//            1 -> AboutScreen()
//            2 -> SettingsScreen()
//        }



//DATEPICKER YEAR PICKER

//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.Button
//import androidx.compose.material.Icon
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import java.util.*
//
//@Composable
//fun YearPicker(selectedYear: MutableState<Int>) {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp)
//    ) {
//        // Display the selected year
//        Text(text = "Selected Year: ${selectedYear.value}")
//
//        // Button to open the custom year picker dialog
//        IconButton(
//            onClick = {
//                // Show the year picker dialog
//                showYearPickerDialog(selectedYear)
//            }
//        ) {
//            Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calendar")
//        }
//    }
//}
//
//@Composable
//private fun showYearPickerDialog(selectedYear: MutableState<Int>) {
//    // Create a list of years
//    val years = (Calendar.getInstance().get(Calendar.YEAR) - 100..Calendar.getInstance().get(Calendar.YEAR)).toList()
//
//    var selectedYearIndex by remember { mutableStateOf(years.indexOf(selectedYear.value)) }
//    var showDialog by remember { mutableStateOf(true) }
//
//    AlertDialog(
//        onDismissRequest = {
//            // Dismiss the dialog
//            showDialog = false
//        },
//        title = {
//            Text(text = "Select Year")
//        },
//        buttons = {
//            Column {
//                years.forEachIndexed { index, year ->
//                    Button(
//                        onClick = {
//                            // Update the selected year
//                            selectedYear.value = years[selectedYearIndex]
//                            showDialog = false
//                        },
//                        colors = ButtonDefaults.buttonColors(
//                            if (index == selectedYearIndex) {
//                                MaterialTheme.colors.primary
//                            } else {
//                                MaterialTheme.colors.surface
//                            }
//                        )
//                    ) {
//                        Text(text = year.toString())
//                    }
//                }
//            }
//        },
//        modifier = Modifier.padding(16.dp)
//    )
//}
//



//
//fun DropdownMenuExample(items: List<String>) {
//    var expanded by remember { mutableStateOf(false) }
//    var selectedIndex by remember { mutableStateOf(0) }
//    var textValue by remember { mutableStateOf(TextFieldValue(items[selectedIndex])) }
//
//    Column {
//        // Text field to show the selected item
//        OutlinedTextField(
//            value = textValue,
//            onValueChange = {
//                textValue = it
//            },
//            readOnly = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Dropdown menu
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            items.forEachIndexed { index, item ->
//                DropdownMenuItem(onClick = {
//                    selectedIndex = index
//                    textValue = TextFieldValue(item)
//                    expanded = false
//                }) {
//                    Text(text = item)
//                }
//            }
//        }
//
//        // Clickable area to expand/collapse the dropdown
//        Box(modifier = Modifier.fillMaxWidth().clickable(onClick = { expanded = true })) {
//            // Invisible box that expands to fill the row and is clickable
//        }
//    }
//}


//@Composable
//fun ApproveScreen() {
//
//    var presses by remember { mutableIntStateOf(0) }
//    val mContext = LocalContext.current
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(text = "Approve Screen Content", modifier = Modifier.padding(16.dp))
//
//
//    }
//}