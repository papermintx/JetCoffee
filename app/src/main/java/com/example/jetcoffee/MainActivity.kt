package com.example.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcoffee.model.dummylist
import com.example.jetcoffee.ui.components.CategoryItem
import com.example.jetcoffee.ui.components.Search
import com.example.jetcoffee.ui.components.SectionText
import com.example.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetCoffeeTheme {

            }
        }
    }
}

@Composable
fun JetCoffeeApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )

        Search()
    }
    
}

@Preview(showBackground = true)
@Composable
private fun ShowApp() {

    JetCoffeeTheme {
        JetCoffeeApp()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(dummylist) { category ->
            CategoryItem(category)
        }
    }

}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowBanner() {
    JetCoffeeTheme {
        Banner()
    }
}