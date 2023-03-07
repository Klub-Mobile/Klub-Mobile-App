package pl.klubmobile.klubmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.klubmobile.klubmobileapp.bottomNavbar.BottomNavItem
import pl.klubmobile.klubmobileapp.ui.theme.KlubMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KlubMobileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        bottomBar = { BottomNavbar() }
                    ) {}
                }
            }
        }
    }
}
@Composable
fun BottomNavbar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(BottomNavItem.AboutClub)
    BottomNavigation{
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label)},
                label = {Text(text = item.label)},
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KlubMobileAppTheme {
        BottomNavbar()
    }
}
