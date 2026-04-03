package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = systemBars.top)
            insets
        }

        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {

            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                ) {
                    ContactDetailsPreviewImage()

                }
            }
        }

    }

    @Composable
    fun ContactDetails(contact: Contact) {

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column() {
                BoxTask(contact)
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = "${contact.name} ${contact.surname.orEmpty()}"
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        style = MaterialTheme.typography.h5,
                        text = contact.familyName
                    )
                }
                if (contact.isFavorite) Image(
                    modifier = Modifier.padding(start = 8.dp),
                    painter = painterResource(id = R.drawable.star_big_on),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                verticalAlignment = Alignment.CenterVertically,

                ){
                Column  (
                    modifier = Modifier.fillMaxHeight()
                        .weight(0.5F)
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "${stringResource(id = R.string.phone)}:"
                    )
                    Text(
                        text = "${stringResource(id = R.string.address)}:"
                    )
                    Text(
                        "${stringResource(id = R.string.email)}:"
                    )

                }
                Column  (
                    modifier = Modifier.fillMaxHeight()
                        .weight(0.5F)
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = contact.phone,
                    )
                    Text(
                        text = contact.address,
                    )
                    if (contact.email != null) {
                        Text(
                            contact.email
                        )
                    }

                }
            }

        }
    }


    @Preview(name = "portrain", showSystemUi = true)
    @Composable
    fun ContactDetailsPreview() {

        Box(
            modifier = Modifier.padding(vertical = 30.dp),
        ) {
            ContactDetails(
                contact = Contact(
                    name = "Евгений",
                    surname = "Андреевич",
                    familyName = "Лукашин",
                    imageRes = null,
                    phone = "+7 495 495 95 95",
                    isFavorite = true,
                    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                    email = "Elukashin@practicum.ru"
                )

            )

        }

    }


    @Composable
    fun RoundInitials(contact: Contact) {
        Box(
            contentAlignment = Alignment.Center

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.LightGray)
            )
            Text(
                text = "${contact.name.take(1)}${contact.familyName.take(1)}",
                style = MaterialTheme.typography.h6
            )
        }
    }


    @Composable
    fun BoxTask(contact: Contact) {
        if (contact.imageRes == null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                RoundInitials(contact)
            }
        }
    }


    //Вторая Функция

    @Composable
    fun ContactDetailsImage(contact: Contact) {

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column() {
                BoxTaskImage(contact)
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = "${contact.name} ${contact.surname.orEmpty()}"
                )
            }
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    Text(
                        style = MaterialTheme.typography.h5,
                        text = contact.familyName
                    )
                }
                if (contact.isFavorite) Image(
                    modifier = Modifier.padding(start = 8.dp),
                    painter = painterResource(id = R.drawable.star_big_on),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                verticalAlignment = Alignment.CenterVertically,

                ){
                Column  (
                    modifier = Modifier.fillMaxHeight()
                        .weight(0.5F)
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "${stringResource(id = R.string.phone)}:"
                    )
                    Text(
                        text = "${stringResource(id = R.string.address)}:"
                    )


                }
                Column  (
                    modifier = Modifier.fillMaxHeight()
                        .weight(0.5F)
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = contact.phone,
                    )
                    Text(
                        text = contact.address,
                    )

                }
            }

        }
    }


    @Preview(name = "portrain", showSystemUi = true)
    @Composable
    fun ContactDetailsPreviewImage() {

        Box(
            modifier = Modifier.padding(vertical = 30.dp),
        ) {
            ContactDetailsImage(
                contact = Contact(
                    name = "Василий",
                    surname = null,
                    familyName = "Кузякин",
                    imageRes = R.drawable.cat ,
                    phone = "---",
                    isFavorite = false,
                    address = "Ивановская область,дер.Крутово, д.4",
                    email = null
                )

            )

        }

    }


    @Composable
    fun RoundInitialsImage(contact: Contact) {
        Box(
            contentAlignment = Alignment.Center

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.LightGray)
            )
            Text(
                text = "${contact.name.take(1)}${contact.familyName.take(1)}",
                style = MaterialTheme.typography.h6
            )
        }
    }


    @Composable
    fun BoxTaskImage(contact: Contact) {

        if (contact.imageRes == null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                RoundInitialsImage(contact)
            }
        } else {
            ImageRes(contact.imageRes)
        }
    }

    @Composable
    fun ImageRes(imageRes: Int) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(imageRes),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )
    }

}
