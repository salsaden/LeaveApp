package com.example.leavemangmtapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leavemangmtapp.ui.theme.screens.AddEmployee.AddEmployeeScreen
import com.example.leavemangmtapp.ui.theme.screens.AdminHomePage.AdminHomepageScreen
import com.example.leavemangmtapp.ui.theme.screens.AdminLogin.AdminLoginScreen
import com.example.leavemangmtapp.ui.theme.screens.ApplyLeave.ApplyLeaveScreen
import com.example.leavemangmtapp.ui.theme.screens.EmployeeProfile.EmployeeProfileScreen
import com.example.leavemangmtapp.ui.theme.screens.Homepage.ApprovedScreen
import com.example.leavemangmtapp.ui.theme.screens.LeaveAllocation.LeaveAllocationScreen
import com.example.leavemangmtapp.ui.theme.screens.Register.RegisterScreen
import com.example.leavemangmtapp.ui.theme.screens.Login.LoginScreen
import com.example.leavemangmtapp.ui.theme.screens.ViewEmployees.ViewEmployeesScreen
import com.example.leavemangmtapp.ui.theme.screens.Homepage.HomeScreen
import com.example.leavemangmtapp.ui.theme.screens.Homepage.PendingScreen
import com.example.leavemangmtapp.ui.theme.screens.Homepage.RejectedScreen
import com.example.leavemangmtapp.ui.theme.screens.Settings.AdminSettingScreen
import com.example.leavemangmtapp.ui.theme.screens.Settings.EmployeeSettingScreen
import com.example.leavemangmtapp.ui.theme.screens.SplashScreen.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController:NavHostController= rememberNavController(),
               startDestination:String= ROUTE_SPLASHSCREEN) {
    NavHost(navController = navController, modifier=modifier, startDestination = startDestination){

        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
            RejectedScreen(navController)
            PendingScreen(navController)
            ApprovedScreen(navController)
        }
        composable(ROUTE_APPLY){
            ApplyLeaveScreen(navController)
        }
        composable(ROUTE_ADMINLOGIN){
            AdminLoginScreen(navController)
        }
        composable(ROUTE_ADMINHOME){
            AdminHomepageScreen(navController)
        }
        composable(ROUTE_LEAVEAALOCATION){
            LeaveAllocationScreen(navController)
        }
        composable(ROUTE_VIEWEMPLOYEES){
            ViewEmployeesScreen(navController)
        }
        composable(ROUTE_ADDEMPLOYEE){
            AddEmployeeScreen(navController)
        }
        composable(ROUTE_EMPLOYEEPROFILE){
            EmployeeProfileScreen(navController)
        }
        composable(ROUTE_ADMINSETTINGS){
            AdminSettingScreen(navController)
        }
        composable(ROUTE_EMPLOYEESETTINGS){
            EmployeeSettingScreen(navController)
        }
        composable(ROUTE_SPLASHSCREEN){
            SplashScreen(navController)
        }

    }

}