package pl.klubmobile.klubmobileapp.bottomNavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import pl.klubmobile.klubmobileapp.destinations.AboutScreenDestination
import pl.klubmobile.klubmobileapp.destinations.BlogsScreenDestination
import pl.klubmobile.klubmobileapp.destinations.CalendarScreenDestination
import pl.klubmobile.klubmobileapp.destinations.DirectionDestination

enum class BottomNavItem(
    val direction: DirectionDestination,
    val label: String,
    val icon: ImageVector
) {
    ABOUT(
        direction = AboutScreenDestination,
        label = "About Club",
        icon = Icons.Filled.Info
    ),
    CALENDAR(
        direction = CalendarScreenDestination,
        label = "Calendar",
        icon = Icons.Filled.Info
    ),
    BLOGS(
        direction = BlogsScreenDestination,
        label = "Blogs",
        icon = Icons.Filled.Info
    )
}
