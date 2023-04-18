package com.bonifasiustrg.gmailclone.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GmailFab(scrollState: ScrollState) {
    // fab will shange if pass specifuc scrollstate value
    if (scrollState.value==0) {

        FloatingActionButton(onClick = { /*TODO*/ },
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)

        }
    } else   {

        ExtendedFloatingActionButton(
            text = { Text(text = "Compose", fontSize = 16.sp)  },
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Edit, contentDescription = null) },
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        )
    }

}

@Preview
@Composable
fun GmailFabPrev() {
    GmailFab(scrollState = rememberScrollState())
}