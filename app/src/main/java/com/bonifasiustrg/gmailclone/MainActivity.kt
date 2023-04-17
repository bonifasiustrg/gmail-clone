    package com.bonifasiustrg.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bonifasiustrg.gmailclone.component.GmailDrawerMenu
import com.bonifasiustrg.gmailclone.component.HomeAppBar
import com.bonifasiustrg.gmailclone.ui.theme.GmailCloneTheme

    class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun GmailApp() {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState  = rememberDrawerState(initialValue = DrawerValue.Closed)

//    val menuList = listOf(Icons.Filled.Menu to "Menu", Icons.Filled.Person to "Person")
    val menuList = listOf(Icons.Default.Favorite to "Fovorite", Icons.Default.Face to "Face", Icons.Default.Email to "Email")
    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                GmailDrawerMenu()
                menuList.forEachIndexed(){idx, data->
                    NavigationDrawerItem(
                        label = { 
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Icon(
                                        imageVector = data.first,
                                        contentDescription = data.second,
                                    )
                                    Text(text = data.second)
                                }
                        }, 
                        selected = selectedItem == idx,
                        onClick = { selectedItem = idx }
                    )
                }
            }
    }) {
        Scaffold(topBar = { HomeAppBar(snackBarHostState, coroutineScope, drawerState)}
        ){paddingValues ->
//            Box(modifier = Modifier.fillMaxWidth().padding(it))
            // padding of the scaffold is enforced to be used
            Column(modifier = Modifier.padding(paddingValues)) {
                Text("Home")
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}
