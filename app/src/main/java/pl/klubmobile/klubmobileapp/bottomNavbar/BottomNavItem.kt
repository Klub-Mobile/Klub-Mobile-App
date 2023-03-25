package pl.klubmobile.klubmobileapp.bottomNavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var label: String, var icon: ImageVector) {
    object AboutClub : BottomNavItem(label = "About Club", icon = Icons.Filled.Info)
}