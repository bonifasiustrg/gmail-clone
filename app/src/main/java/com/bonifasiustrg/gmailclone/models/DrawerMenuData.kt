package com.bonifasiustrg.gmailclone.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon: ImageVector? = null,
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader:Boolean = false
){

    object Mail: DrawerMenuData(
        icon = Icons.Outlined.Email,
        title = "Inbox"
    )
    object Person: DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Contacts"
    )
    object Starred: DrawerMenuData(
        icon = Icons.Outlined.Star,
        title = "Starred"
    )
    object MailOutline: DrawerMenuData(
        icon = Icons.Filled.MailOutline,
        title = "All Mail"
    )
    object Send: DrawerMenuData(
        icon = Icons.Outlined.Send,
        title = "Send Mail"
    )
    object Setting: DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )


    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )
    object HeaderTwo: DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )
}

/*
*  1. The image of actor in the title can be null because if it's a divider
that we don't need to have an image and title
* 2. And if it is not a divider and that is a header, then we need to have
the title and not the icon.
* */
