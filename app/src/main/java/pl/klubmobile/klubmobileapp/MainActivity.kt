package pl.klubmobile.klubmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import pl.klubmobile.klubmobileapp.bottomNavbar.BottomNavItem
import pl.klubmobile.klubmobileapp.ui.theme.KlubMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KlubMobileAppTheme {
                MainScreen()
            }
        }
    }

    @Composable
    private fun MainScreen() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val engine = rememberNavHostEngine()
            val navController = engine.rememberNavController()
            val startRoute = NavGraphs.root.startRoute

            navController.currentBackStackEntryAsState().value?.print()

            Scaffold(
                bottomBar = { BottomNavBar(navController) }
            ) { contentPadding ->
                DestinationsNavHost(
                    engine = engine,
                    navController = navController,
                    navGraph = NavGraphs.root,
                    modifier = Modifier.padding(contentPadding),
                    startRoute = startRoute
                )
            }
        }
    }
}

@Composable
private fun BottomNavBar(navController: NavHostController) {
    BottomNavigation {
        BottomNavItem.values()
            .forEach { destination ->
                val isCurrentDestOnBackStack = navController

                    .isRouteOnBackStack(destination.direction)
                BottomNavigationItem(
                    icon = { Icon(destination.icon, contentDescription = destination.label) },
                    label = { Text(text = destination.label) },
                    selected = isCurrentDestOnBackStack,
                    onClick = {
                        if (isCurrentDestOnBackStack) {
                            // When we click again on a bottom bar item and it was already selected
                            // we want to pop the back stack until the initial destination of this bottom bar item
                            navController.popBackStack(destination.direction.route, false)
                            return@BottomNavigationItem
                        }
                        navController.navigate(destination.direction.route) {
                            // Pop up to the root of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(NavGraphs.root.route) {
                                saveState = true
                            }

                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
    }
}

private fun NavBackStackEntry.print(prefix: String = "stack") {
    val stack = destination.route
    println("$prefix = $stack")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KlubMobileAppTheme {
        BottomNavBar(NavHostController(LocalContext.current))
    }
}
