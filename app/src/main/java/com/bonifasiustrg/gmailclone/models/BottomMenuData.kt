package com.bonifasiustrg.gmailclone.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
){
    object Mail: BottomMenuData(
        icon = Icons.Filled.Email,
        title = "Mail"
    )
    object Meet: BottomMenuData(
        icon = Icons.Filled.Phone,
        title = "Meet"
    )
}
