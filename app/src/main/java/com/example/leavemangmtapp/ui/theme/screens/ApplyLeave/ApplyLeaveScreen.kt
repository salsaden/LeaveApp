package com.example.leavemangmtapp.ui.theme.screens.ApplyLeave

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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


@SuppressLint("RememberReturnType", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplyLeaveScreen(navController:NavHostController) {

    val mContext = LocalContext.current
    var selectedOption by remember { mutableStateOf("") }
    var textValue by remember { mutableStateOf(TextFieldValue()) }
    //var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    val options = listOf("Select leave type","Casual Leave","Sick Leave","Maternity Leave","Marriage Leave","Paternity Leave", "Bereavement Leave")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0])}


        Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "New Leave Application",
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
                    Icon(
                        imageVector = Icons.Filled.Dashboard,
                        contentDescription = "Dashboard",
                        tint = Color.Black,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "DASHBOARD",
                        color = Color.Black,
                        fontWeight = FontWeight.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 25.dp)
                    )

                }
                Spacer(modifier = Modifier.width(60.dp))

                IconButton(onClick = { navController.navigate(ROUTE_APPLY) }) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "ApplyLeaves",
                        tint = Color.Blue,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "APPLY LEAVE",
                        fontWeight = FontWeight.Black,
                        color = Color.Blue,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                }

                Spacer(modifier = Modifier.width(60.dp))
                IconButton(onClick = { navController.navigate(ROUTE_EMPLOYEEPROFILE) }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        tint = Color.Black,
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                    Text(
                        text = "PROFILE",
                        color = Color.Black,
                        fontWeight = FontWeight.Black,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 25.dp)
                    )
                }

                Spacer(modifier = Modifier.width(60.dp))
                IconButton(onClick = { navController.navigate(ROUTE_EMPLOYEESETTINGS)}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        tint = Color.Black,
                        modifier = Modifier.padding(bottom = 15.dp)
                    )
                    Text(
                        text = "SETTINGS",
                        color = Color.Black,
                        fontWeight = FontWeight.Black,
                        fontSize = 9.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 25.dp)
                    )
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

       // LeavetypeTextField
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                TextField(
                    // The `menuAnchor` modifier must be passed to the text field for correctness.
                    modifier = Modifier
                        .menuAnchor()
                        .size(430.dp, 80.dp)
                        .padding(11.dp),
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = {},
                    label = { Text("Leave Type") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption) },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }


            //Date Range Buttons
            Row {
                Button(
                    onClick = {
                        val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
                        mContext.startActivity(calenderIntent)
                    },
                    modifier = Modifier
                        .size(width = 200.dp, height = 50.dp)
                        .padding(start = 20.dp),
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent, // Set button background color
                        contentColor = Color.Black // Set button text color
                    ),
                    border = BorderStroke(3.dp, Color.Black)
                ) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
                    Text(text = " From Date", fontSize = 15.sp, color = Color.Gray)

                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = {
                        val calenderIntent = Intent(Settings.ACTION_DATE_SETTINGS)
                        mContext.startActivity(calenderIntent)
                    },
                    modifier = Modifier
                        .size(width = 200.dp, height = 50.dp)
                        .padding(end = 20.dp),
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Transparent, // Set button background color
                        contentColor = Color.Black // Set button text color
                    ),
                    border = BorderStroke(3.dp, Color.Black)
                ) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calender")
                    Text(text = " To Date", fontSize = 15.sp, color = Color.Gray)

                }
            }
            //Enter Reason TextField
            TextField(
                value = textValue, onValueChange = { textValue = it },
                label = { Text("Enter reason", fontSize = 13.sp) },
                modifier = Modifier
                    .background(color = Color.White)
                    .size(430.dp, 100.dp)
                    .padding(start = 10.dp, end = 10.dp),
//                colors = TextFieldColors
            )

            //Send Request for Approval
//    Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = selectedOption,
                onValueChange = { selectedOption = it },
                placeholder = { Text(text = "Send Request to (For Approval)") },
                readOnly = true,
                modifier = Modifier
                    .size(430.dp, 80.dp)
                    .padding(11.dp)
                    .clickable(onClick = { expanded = true })
            )
//            DropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                options.forEach { item ->
//                    DropdownMenuItem(text = { Text(item)},
//                        onClick = {
//                            selectedOption = item
//                            expanded = false
//                        }
//                    )
//
//                }
//            }

            //Apply leave button
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.navigate(ROUTE_HOME) },
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
                    .padding(start = 70.dp, end = 10.dp),
//            .align(Alignment.)
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Cyan)
            ) {

                Text(
                    text = "Apply Leave",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ApplyLeaveScreenPreview() {
    ApplyLeaveScreen(navController = rememberNavController())
}