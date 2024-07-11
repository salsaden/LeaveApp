package com.example.leavemangmtapp.ui.theme.screens.AddEmployee

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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToPhotos
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.navigation.ROUTE_ADDEMPLOYEE
import com.example.leavemangmtapp.navigation.ROUTE_ADMINHOME
import com.example.leavemangmtapp.navigation.ROUTE_ADMINSETTINGS
import com.example.leavemangmtapp.navigation.ROUTE_APPLY
import com.example.leavemangmtapp.navigation.ROUTE_HOME
import com.example.leavemangmtapp.navigation.ROUTE_LEAVEAALOCATION
import com.example.leavemangmtapp.navigation.ROUTE_REGISTER
import com.example.leavemangmtapp.navigation.ROUTE_VIEWEMPLOYEES
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEmployeeScreen(navController: NavHostController) {
    var presses by remember { mutableIntStateOf(0) }
    val mContext = LocalContext.current
    var search by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var mobilenumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val checkedState = remember { mutableStateOf(true) }
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? -> imageUri = uri }
    var showSaveEmployeeDialog by remember { mutableStateOf(false) } // State to control dialog visibility


    // DatePickerDialog state
    var showDatePicker by remember { mutableStateOf(false) }

    // Date Picker Dialog
    if (showDatePicker) {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                dob = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                showDatePicker = false
            },
            year, month, day
        ).show()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Add Employee",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Cyan),
                modifier = Modifier.height(46.dp)
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
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ASSIGN LEAVE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
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
                            tint = Color.Blue,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "ADD EMPLOYEE",
                            fontWeight = FontWeight.Black,
                            fontSize = 9.sp,
                            color=Color.Blue,
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    .shadow(5.dp, shape = CutCornerShape(5.dp))
                    .width(400.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start=50.dp, end = 50.dp, top = 20.dp, bottom = 20.dp)
                ) {
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

                    Button(onClick = {
                        launcher.launch("image/*")
                    },colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.InsertPhoto,
                            contentDescription = "choose profile image",
                        )
                        Text(text = "Choose Profile Image", color = Color.Black)
                    }

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text(text = "Full Name") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "personIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        )
                    )

                    TextField(
                        value = mobilenumber,
                        onValueChange = { mobilenumber = it },
                        label = { Text(text = "Mobile Number") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "callIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        )
                    )

                    TextField(
                        value = address,
                        onValueChange = { address = it },
                        label = { Text(text = "Address") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "personIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        )
                    )

                    // TextField for Date of Birth
                    TextField(
                        value = dob,
                        onValueChange = { dob = it },
                        label = { Text(text = "Date of Birth") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.EditCalendar,
                                contentDescription = "calendarIcon")
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.CalendarMonth,
                                contentDescription = "calendarIcon",
                                modifier = Modifier.clickable {
                                    showDatePicker = true
                                }
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        )
                    )

                    TextField(
                        value = designation,
                        onValueChange = { designation = it },
                        label = { Text(text = "Designation") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "personIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        )
                    )

                }
            }
            //
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp),
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    .shadow(5.dp, shape = CutCornerShape(5.dp))
                    .width(400.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start=50.dp, end = 50.dp, top = 20.dp, bottom = 20.dp)
                ) {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "emailIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = "passwordIcon")
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Cyan,
                            containerColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = PasswordVisualTransformation()
                    )

                }
            }
            Button(
                onClick = {showSaveEmployeeDialog=true},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(200.dp)
            ) {
                Text(
                    text = "Save Employee",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            if (showSaveEmployeeDialog) {
                AlertDialog(
                    onDismissRequest = { showSaveEmployeeDialog = false },
                    modifier = Modifier.width(400.dp),
                    title = { Text(text = "Successfully Added") },
                    text = {
                        Column {
                            Text("Employee Added Successfully.")
                            Spacer(modifier = Modifier.height(20.dp))
                            Text("Please share required details with #name. So he/she can start using the application.")
                        }
                    },
                    confirmButton = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "VIA EMAIL",
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_EMAIL, arrayOf("employeemail@gmail.com"))
                                        putExtra(Intent.EXTRA_SUBJECT, "subject")
                                        putExtra(Intent.EXTRA_TEXT, "Hello, this is the email")
                                    }
                                    mContext.startActivity(shareIntent)
                                }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "VIA SMS",
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = Uri.parse("smsto:0712345678")
                                        putExtra("sms_body", "Hello #name, these are your credentials use them to log in?")
                                    }
                                    mContext.startActivity(smsIntent)
                                }
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "CANCEL",
                                color = Color.Red,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    showSaveEmployeeDialog = false
                                }
                            )
                        }
                    },
                    dismissButton = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddEmployeeScreenPreview() {
    val navController = rememberNavController()
    AddEmployeeScreen(navController)
}