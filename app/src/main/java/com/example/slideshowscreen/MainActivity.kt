package com.example.slideshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slideshowscreen.R
import com.example.slideshowscreen.SlideItem
import com.example.slideshowscreen.ui.theme.SlideshowScreenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowScreenTheme {
                SlideshowScreen()
            }
        }
    }
}

@Composable
fun SlideshowScreen() {
    val slideItems = listOf(
        SlideItem(R.drawable.image1, "Hello! I am picture 1"),
        SlideItem(R.drawable.image2, "Hello! I am picture 2"),
        SlideItem(R.drawable.image3, "Hello! I am picture 3"),
        SlideItem(R.drawable.image4, "Hello! I am picture 4"),
        SlideItem(R.drawable.image5, "Hello! I am picture 5"),
        SlideItem(R.drawable.image6, "Hello! I am picture 6"),
        SlideItem(R.drawable.image7, "Hello! I am picture 7"),
        SlideItem(R.drawable.image8, "Hello! I am picture 8"),
        SlideItem(R.drawable.image9, "Hello! I am picture 9"),
        SlideItem(R.drawable.image10, "Hello! I am picture 10")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Cute Animal List",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        slideItems.forEach { item ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = item.caption,
                    modifier = Modifier.size(250.dp)
                )
                Text(
                    text = item.caption,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SlideshowPreview() {
    SlideshowScreenTheme {
        SlideshowScreen()
    }
}

