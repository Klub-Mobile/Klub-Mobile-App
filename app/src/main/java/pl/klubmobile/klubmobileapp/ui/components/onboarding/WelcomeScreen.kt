package pl.klubmobile.klubmobileapp.ui.components.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.klubmobile.klubmobileapp.R
import pl.klubmobile.klubmobileapp.ui.theme.KlubMobileAppTheme

@Composable
fun WelcomeScreen() {

    Column(
        Modifier
            .fillMaxSize()

    ) {
        Header()
        Image(
            painter = painterResource(
                id = R.drawable.welcomelogo),
            contentDescription = null,
            modifier = Modifier.padding(32.dp)
        )
        CenteredTitleSubtitle(
            modifier = Modifier.padding(horizontal = 40.dp),
            title = R.string.welcome_to_klub,
            subtitle = R.string.welcome_message,
            subtitleFontSize = 14.sp
        )

    }


}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KlubMobileAppTheme {
        WelcomeScreen()
    }
}