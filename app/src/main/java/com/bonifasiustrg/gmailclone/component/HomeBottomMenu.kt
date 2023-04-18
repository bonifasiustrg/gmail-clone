package com.bonifasiustrg.gmailclone.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import com.bonifasiustrg.gmailclone.models.BottomMenuData

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeBottomMenu() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )

    NavigationBar() {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(text = item.title)},
//                selected = selectedItem == index,
                selected = false,
                alwaysShowLabel = true,
                onClick = { selectedItem = index },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) }
                )
        }
    }
}