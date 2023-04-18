package com.bonifasiustrg.gmailclone.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bonifasiustrg.gmailclone.R

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest =  {
        Log.e("mytag", "Dialog Accounts")
        openDialog.value = false
    }) {
        AccountsDialogUI()
    }
}

@Composable
fun AccountsDialogUI(modifier: Modifier = Modifier) {
   Card() {
       Column(
           modifier
               .background(Color.White)
               .padding(16.dp)
       ) {
            Row(modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }
                Image(painter = painterResource(id = R.drawable.google_logo), contentDescription = "google logo",
                    modifier
                        .height(30.dp)
                        .weight(2.0f)
                )
            }

           Row(modifier.padding(top = 16.dp, bottom = 16.dp)) {
               Image(painter = painterResource(id = R.drawable.profile_picture), contentDescription = "",
                   modifier = Modifier
                       .size(35.dp)
                       .clip(CircleShape)
                       .background(Color.White)
                       .clickable {
                       }

               )

               Column(
                   modifier
                       .padding(start = 16.dp)
                       .weight(2.0f)) {
                   Text(text = "Bonifasius Tarigan", fontWeight = FontWeight.SemiBold)
                   Text(text = "bonifasius.tambak@gmail.com", fontWeight = FontWeight.Normal, fontSize = 12.sp)

                   Row(modifier.fillMaxWidth().padding(top = 8.dp), horizontalArrangement = Arrangement.Start) {
                       Card(modifier.requiredWidth(140.dp), colors = CardDefaults.cardColors(Color.Transparent),
                           shape = RoundedCornerShape(50.dp),
                           border = BorderStroke(1.dp, Color.Gray)
                       ) {
                           Text(text = "Google Account", modifier.padding(8.dp), fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
                       }
                       Spacer(modifier = modifier.width(10.dp))
                   }
               }

               Text(text = "999+", fontWeight = FontWeight.Medium)

           }
           Divider(modifier.padding(top=10.dp))


       }

   }
}

@Preview
@Composable
fun ACPrev() {
    AccountsDialogUI()
}