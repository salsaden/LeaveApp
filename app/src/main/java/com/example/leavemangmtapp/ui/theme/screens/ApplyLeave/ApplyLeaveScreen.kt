package com.example.leavemangmtapp.ui.theme.screens.ApplyLeave

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
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
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import java.util.Calendar




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplyLeaveScreen(navController: NavHostController) {
    val mContext = LocalContext.current
    var dob by remember { mutableStateOf("") }
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf("") }
    var textValue by remember { mutableStateOf(TextFieldValue()) }
    val options = listOf(
        "Select leave type", "Casual Leave", "Sick Leave", "Maternity Leave",
        "Marriage Leave", "Paternity Leave", "Bereavement Leave"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? -> var imageUri = uri }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    var fromDate by remember { mutableStateOf("") }
    var toDate by remember { mutableStateOf("") }
    var numberOfDays by remember { mutableStateOf(0) }


    var isDialogVisible by remember { mutableStateOf(false) }
    var selectedYear by remember { mutableStateOf(2024) } // Default selected year
    val years = (2020..2026).toList()

    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    fun showDatePickerDialog(isFromDate: Boolean) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            mContext,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance().apply {
                    set(year, month, dayOfMonth)
                }
                val formattedDate = dateFormatter.format(selectedDate.time)
                if (isFromDate) {
                    fromDate = formattedDate
                } else {
                    toDate = formattedDate
                }
                if (fromDate.isNotEmpty() && toDate.isNotEmpty()) {
                    val startDate = dateFormatter.parse(fromDate)!!
                    val endDate = dateFormatter.parse(toDate)!!
                    val diff = endDate.time - startDate.time
                    numberOfDays = (diff / (1000 * 60 * 60 * 24)).toInt() + 1
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }


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
                        Text(
                            text = "Year $selectedYear", // Display selected year here
                            color = Color.DarkGray,
                            fontSize = 15.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp),
                actions = {
                    IconButton(onClick = {isDialogVisible = true }) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calendar")
                    }
                },

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
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "DASHBOARD",
                            fontWeight = FontWeight.Black,
                            color = Color.Black,
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
                            tint = Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "APPLY LEAVE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color = Color.Blue,
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
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            // Custom Dialog
            if (isDialogVisible) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)) // Background overlay
                        .clickable { isDialogVisible = false }, // Dismiss on click outside
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
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

            // Leave type dropdown
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = {},
                    label = {},
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption, fontSize = 15.sp) },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            // Date range buttons
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { showDatePickerDialog(isFromDate = true) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp),
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(3.dp, Color.Cyan)
                ) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calendar")
                    Text(
                        text = if (fromDate.isEmpty()) " From Date" else " From Date: $fromDate",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { showDatePickerDialog(isFromDate = false) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp),
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    border = BorderStroke(3.dp, Color.Cyan)
                ) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "calendar")
                    Text(
                        text = if (toDate.isEmpty()) " To Date" else " To Date: $toDate",
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Display number of days
            if (numberOfDays > 0) {
                Text(
                    text = "Number of days: $numberOfDays",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // OutlinedTextField for reason
            OutlinedTextField(
                value = textValue,
                onValueChange = { textValue = it },
                label = { Text("Enter Reason") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(150.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent // Use `containerColor` instead of `backgroundColor`
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            //Proof
            imageUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    bitmap.value = MediaStore.Images
                        .Media.getBitmap(context.contentResolver, it)

                } else {
                    val source = ImageDecoder
                        .createSource(context.contentResolver, it)
                    bitmap.value = ImageDecoder.decodeBitmap(source)
                }

                bitmap.value?.let { btm ->
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
            Button(
                onClick = { launcher.launch("image/*")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(70.dp),
                shape = CutCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                border = BorderStroke(0.dp, Color.Black)
            ) {
                Icon(imageVector = Icons.Filled.Attachment, contentDescription = "attachproof")
                Text(text = "Attach Proof", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(30.dp))
            // Submit button
            Button(
                onClick = { /* Handle submission */ },
                modifier = Modifier
//                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan,
                    contentColor = Color.Black
                ),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text(text = "Submit", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApplyLeaveScreenPreview() {
    ApplyLeaveScreen(navController = rememberNavController())
}