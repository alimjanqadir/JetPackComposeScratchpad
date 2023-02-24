package com.example.drawpad.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.drawpad.R
import ui.theme.DrawPadTheme

class ComposeLearning : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello")
        }
    }

    data class Message(val firstName: String, val message: String)

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.primary, CircleShape),
                painter = painterResource(R.drawable.icon),
                contentDescription = "icon"
            )
            Spacer(modifier = Modifier.width(12.dp))
            var isExpanded by remember { mutableStateOf(false) }
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    msg.firstName,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(2.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                    modifier = Modifier.animateContentSize().padding(all = 1.dp)
                ) {
                    Text(
                        text = msg.message,
                        modifier = Modifier
                            .padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }


    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }

    @Preview("Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun MessageCardPreview() {
        DrawPadTheme {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                Conversation(SampleData.messages)
            }
        }
    }

    object SampleData {
        val messages = listOf<Message>(
            Message("Shayla", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message("Jakob", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message(
                "Lindsey",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc a accumsan sem. Ut rutrum nunc metus. Duis nec leo mollis, venenatis metus eu, laoreet nunc. Fusce rhoncus commodo ligula eu tristique. Praesent facilisis neque non ullamcorper lacinia. Nullam et bibendum est, et porta tortor. Vivamus posuere vehicula nibh eu aliquam. Vivamus bibendum erat elit. In hendrerit rutrum accumsan. In vel enim eu nunc commodo condimentum nec in dolor. Donec dictum eros ut diam sollicitudin, sed ultrices elit sollicitudin. Mauris aliquam ligula magna, nec mollis urna blandit ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Cras fringilla ipsum pulvinar diam pulvinar ultrices. In ultricies est et massa iaculis, eget blandit ipsum porta. Morbi at ipsum justo. "
            ),
            Message(
                "Bradley",
                " Fusce eu est sed lorem sollicitudin varius. Praesent feugiat ipsum quis arcu fringilla pellentesque. Mauris semper porttitor convallis. Proin aliquet, lacus cursus tincidunt venenatis, neque turpis dapibus massa, nec imperdiet nunc purus sit amet eros. Nam a enim ligula. Nunc purus tellus, aliquam eget ex in, mollis blandit sapien. Mauris tempor lectus ligula, fringilla suscipit lectus varius sit amet. Vestibulum eleifend ligula sed dolor dapibus fermentum. Etiam consectetur metus at velit accumsan ultricies. Fusce ultricies eu erat ut consectetur. "
            ),
            Message(
                "Lexi",
                " In consectetur, tellus a pharetra vestibulum, ipsum odio luctus mauris, non malesuada arcu est vitae lorem. Sed suscipit lacus in congue suscipit. Proin vel pellentesque orci, fringilla fringilla nisl. Nam imperdiet scelerisque lorem, ut tincidunt orci consequat ac. Vivamus elementum ligula vitae nisl imperdiet auctor. Etiam id lorem accumsan, porta turpis quis, sodales purus. Nam ligula urna, rutrum a laoreet ac, lacinia at ex. Morbi tempor massa eros, sit amet mollis mauris fermentum eget. Praesent quis quam sit amet nisl volutpat varius. Fusce faucibus consectetur blandit. Praesent ac hendrerit dui. Aliquam dictum sodales consequat. Donec commodo, quam id dapibus consectetur, purus augue luctus diam, a sollicitudin turpis quam sit amet mauris. "
            ),
            Message("Gabrielle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message(
                "Claudia",
                " Sed eu pharetra nisl. Aliquam hendrerit lacus id nunc rhoncus, ut dapibus lectus pulvinar. Praesent condimentum urna arcu, id tempor diam ultricies eu. Fusce in nisl at lacus congue pretium sit amet sit amet ligula. Fusce eget pulvinar velit. Donec aliquam scelerisque luctus. Maecenas eget placerat augue. Nam mollis ipsum a vestibulum dignissim. In rutrum nisl vel velit mollis, eget varius enim aliquet. Sed vel efficitur nisl. Morbi varius vel magna nec ullamcorper. Cras at facilisis mi, non rhoncus nisl. "
            ),
            Message("Leah", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message("Kolton", "Rose"),
            Message("Shawn", "Ellis"),
            Message("Aryan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message("Jazmin", "Ashley"),
            Message(
                "Corbin",
                " Vivamus porta, erat eget venenatis semper, purus libero semper massa, quis sollicitudin quam libero in sapien. Duis tempus quis arcu ullamcorper pharetra. Praesent vitae arcu at lectus iaculis vehicula non sed nunc. Etiam in erat in tellus cursus mattis. Proin ornare, sem at pulvinar auctor, nulla erat elementum odio, quis tempus nisi nulla sed nunc. Cras eu risus risus. Donec justo arcu, tempus eu fermentum vel, mollis sit amet leo. Praesent justo magna, congue vel dui nec, consequat hendrerit mauris. Integer at pellentesque erat, id rhoncus nulla. Integer vehicula turpis non turpis sodales, eu ultricies quam rhoncus. Fusce tellus dui, condimentum ac justo nec, volutpat rutrum orci. In a eleifend odio. Phasellus. "
            ),
            Message("Kingston", "Pierce"),
            Message("Gretchen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            Message("Fisher", "Woods"),
        )
    }
}


