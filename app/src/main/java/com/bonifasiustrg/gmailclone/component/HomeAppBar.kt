package com.bonifasiustrg.gmailclone.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bonifasiustrg.gmailclone.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun HomeAppBar(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope,
               drawerState: DrawerState, openDialog: MutableState<Boolean>
) {
    Box(modifier = Modifier
        .background(Color.Transparent)
        .padding(10.dp)) {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
//                        snackbarHostState.showSnackbar("Snackbar")
                        drawerState.open()

                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Draw")
                }
                Text(text = "Search mail", modifier = Modifier
                    .weight(2.0f)
                    .padding(start = 8.dp))
                IconButton(onClick = { /*TODO*/ }) {

                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon", modifier = Modifier.padding(horizontal = 8.dp))
                }

                Image(painter = painterResource(id = R.drawable.profile_picture), contentDescription = "",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable {
                            openDialog.value = true
                        }

                )
                if (openDialog.value) {
                    AccountsDialog(openDialog = openDialog)
                }

            }
        }
    }
}
