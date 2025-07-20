package com.example.phonecheckandroid.ui.components


import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.phonecheckandroid.R
import com.example.phonecheckandroid.ui.theme.PhoneCheckAndroidTheme


@Composable
fun FeatureButton(
    painter: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    text: String = "Name",
    description: String = "Describe",
    contentDescription: String = "Icon",
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .width(150.dp)
            .height(140.dp)
            .padding(0.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(40.dp)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color =  MaterialTheme.colorScheme.onPrimary
            )

        }
    }
}

//@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FeatureButtonPreview() {
    PhoneCheckAndroidTheme {
        FeatureButton()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun FeatureButtonPreview2() {
    PhoneCheckAndroidTheme {
        FeatureButton()
    }
}