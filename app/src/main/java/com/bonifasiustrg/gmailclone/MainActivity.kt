    package com.bonifasiustrg.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.gmailclone.component.GmailDrawerMenu
import com.bonifasiustrg.gmailclone.component.GmailFab
import com.bonifasiustrg.gmailclone.component.HomeAppBar
import com.bonifasiustrg.gmailclone.component.HomeBottomMenu
import com.bonifasiustrg.gmailclone.component.MailList
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
    val scrollState = rememberScrollState()
    val openDialog =  remember { mutableStateOf(false) }

//    val menuList = listOf(Icons.Filled.Menu to "Menu", Icons.Filled.Person to "Person")
    val menuList = listOf(
        Icons.Filled.MailOutline to "All Inbox",
        Icons.Filled.Email to "Inbox",
        Icons.Filled.Email to "Unread",
        Icons.Filled.Star to "Starred",
        Icons.Filled.DateRange to "Snoozed",
        Icons.Filled.Send to "Sent",
        Icons.Filled.Send to "Scheduled",
        Icons.Filled.Send to "Outbox",
        Icons.Filled.Info to "Drafts",
        Icons.Filled.MailOutline to "All Mail",
        Icons.Filled.Info to "Spam",
        Icons.Filled.Delete to "Trash",
        Icons.Filled.DateRange to "Date",
        Icons.Filled.Favorite to "Favorite",
        Icons.Filled.Settings to "Settings",
        Icons.Filled.Face to "Help"
    )

    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                GmailDrawerMenu()
                menuList.forEachIndexed(){idx, data->
                    NavigationDrawerItem(
                        label = {
                            Row(modifier = Modifier
                                    .fillMaxWidth()){
                                Icon(
                                        imageVector = data.first,
                                        contentDescription = data.second,
                                    )
                                Text(text = data.second, modifier = Modifier.padding(start = 8.dp))

                                }
                        }, 
                        selected = selectedItem == idx,
                        onClick = {
                            selectedItem = idx
                            // NAV CONTROLLER EHRE
                        }
                    )
                }
            }
    }) {
        Scaffold(
            topBar = { HomeAppBar(snackBarHostState, coroutineScope, drawerState, openDialog)},
            bottomBar = { HomeBottomMenu() },
            floatingActionButton = { GmailFab(scrollState = scrollState)}
        ){paddingValues ->
//            Box(modifier = Modifier.fillMaxWidth().padding(it))
            // padding of the scaffold is enforced to be used

            MailList(paddingValues = paddingValues, scrollState)
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
