package com.bonifasiustrg.gmailclone.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bonifasiustrg.gmailclone.models.MailData
import com.bonifasiustrg.gmailclone.mailList

@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, Orientation.Vertical)  // scrollstate for fab shanges
        ) {
            items(mailList){ mailData ->
                MailItem(mailData = mailData)
            }
        }
    }
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        // mail sender picture/logo
        Card(modifier = modifier
            .padding(end = 8.dp)
            .size(40.dp)
            .clip(CircleShape),
            colors = CardDefaults.cardColors(Color.Gray)
        ) {
            Text(text = mailData.userName[0].toString(),
                modifier = modifier.padding(start = 16.dp, top = 10.dp),
                textAlign = TextAlign.Center
            )
        }

        Column(modifier.weight(2.0f)) {
            Text(text = mailData.userName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = mailData.body,
                fontSize = 14.sp
            )
        }

        Column() {
            IconButton(modifier = Modifier
                .size(50.dp)
                .padding(top = 16.dp),
                onClick = {

            }) {
                Icon(imageVector = Icons.Default.Star, contentDescription = null)
            }
            Text(text = mailData.timeStamp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailListPreview() {
    MailItem(mailData = MailData(
        1, "Bonifasius Tarigan",
        "Email regarding something important",
        "Email regarding something important",
        "22:22"
    ))
}