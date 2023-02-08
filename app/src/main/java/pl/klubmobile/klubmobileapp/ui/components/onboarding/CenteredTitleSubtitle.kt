package pl.klubmobile.klubmobileapp.ui.components.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CenteredTitleSubtitle(
    modifier: Modifier = Modifier,
    title: Int,
    subtitle: Int,
    titleFontSize: TextUnit = 24.sp,
    subtitleFontSize: TextUnit = 16.sp
) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Title(title = title, titleFontSize = titleFontSize)
        Spacer(modifier = Modifier.height(8.dp))
        SubTitle(subtitle = subtitle, subtitleFontSize = subtitleFontSize)
    }
}

@Composable
private fun SubTitle(
    subtitle: Int,
    subtitleFontSize: TextUnit = 16.sp
) {
    Text(
        text = stringResource(id = subtitle),
        textAlign = TextAlign.Center,
      //  color =
    )
}

@Composable
private fun Title(
    title: Int,
    titleFontSize: TextUnit = 24.sp
) {
    Text(
        text = stringResource(id = title),
     //   style =
        textAlign = TextAlign.Center,
     //   color =
    )
}
