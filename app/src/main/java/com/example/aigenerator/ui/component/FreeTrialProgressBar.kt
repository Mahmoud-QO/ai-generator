package com.example.aigenerator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import com.example.aigenerator.R
import com.example.aigenerator.ui.theme.AIGeneratorTheme

// TODO: Refactor 'FreeTrialProgressBar()' to be a general case 'StepProgressBar()' for reusability
@Composable
fun FreeTrialProgressBar(modifier: Modifier = Modifier) = ConstraintLayout(
    modifier = modifier
) {
    val (step1, step2, step3) = createRefs()
    val (line1, line2, line3) = createRefs()
    val (spc1, spc2) = createRefs()

    constrain(
        createVerticalChain(step1, spc1, step2, spc2, step3, chainStyle = ChainStyle.Spread)
    ) {
        top.linkTo(parent.top); bottom.linkTo(parent.bottom)
    }

    FreeTrialProgressLine(
        modifier = Modifier.constrainAs(line3) {
            linkTo(step1.top, step3.bottom); linkTo(step1.start, step1.end)
            height = Dimension.fillToConstraints
        }
    ) { false }

    FreeTrialProgressLine(
        modifier = Modifier.constrainAs(line2) {
            linkTo(step1.top, spc2.top); linkTo(step1.start, step1.end)
            height = Dimension.fillToConstraints
        }
    ) { false }

    FreeTrialProgressLine(
        modifier = Modifier.constrainAs(line1) {
            linkTo(step1.top, spc1.top); linkTo(step1.start, step1.end)
            height = Dimension.fillToConstraints
        }
    ) { true }

    FreeTrialStep(
        ref = step1,
        iconPainter = painterResource(id = R.drawable.ic_unlock),
        title = stringResource(R.string.today_get_instant_access),
        body = stringResource(R.string.start_your_full_access)
    ) { true }
    

    FreeTrialStep(
        ref = step2, iconPainter = painterResource(id = R.drawable.ic_bell),
        title = stringResource(R.string.day_2_trial_reminder),
        body = stringResource(R.string.get_reminder)
    ) { false }

    FreeTrialStep(
        ref = step3, iconPainter = painterResource(id = R.drawable.ic_magic_stick),
        title = stringResource(R.string.day_3_trial_ends),
        body = stringResource(R.string.cancel_anytime_before)
    ) { false }
}

@Composable
private fun ConstraintLayoutScope.FreeTrialStep(
    ref: ConstrainedLayoutReference,
    iconPainter: Painter, title: String, body: String,
    isDone: () -> Boolean
) {
    val done = isDone()

    Box(
        modifier = Modifier
            .size(40.dp).clip(CircleShape)
            .background(
                if (done) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondary
            )
            .constrainAs(ref) { start.linkTo(parent.start) },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }

    Column(
        Modifier.padding(start = 12.dp, top = 8.dp).constrainAs(createRef()) {
            linkTo(ref.end, parent.end); top.linkTo(ref.top)
            width = Dimension.fillToConstraints
        }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = if (done) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun FreeTrialProgressLine(modifier: Modifier, isDone: () -> Boolean) = VerticalDivider(
    modifier = modifier.clip(RoundedCornerShape(10.dp)),
    color =
        if (isDone()) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.secondary,
    thickness = 6.dp
)

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    FreeTrialProgressBar(Modifier.size(400.dp))
}
