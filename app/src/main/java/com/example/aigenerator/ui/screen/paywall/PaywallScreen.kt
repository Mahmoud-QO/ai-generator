package com.example.aigenerator.ui.screen.paywall

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.model.User
import com.example.aigenerator.model.UserReview
import com.example.aigenerator.ui.component.FreeTrialProgressBar
import com.example.aigenerator.ui.component.PrimaryButton
import com.example.aigenerator.ui.component.UserReviewCard
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun PaywallScreen() {
    PaywallScreenContent()
}

@Composable
private fun PaywallScreenContent() = Column(
    modifier = Modifier
        .fillMaxSize().background(MaterialTheme.colorScheme.background).navigationBarsPadding()
) {

    Box(modifier = Modifier.fillMaxWidth().weight(0.7f)) {
        Image(
            painter = painterResource(id = R.drawable.paywall_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Spacer(modifier = Modifier.height(44.dp))
                Text(
                    text = "Try for Free",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "How it Works",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            FreeTrialProgressBar(
                Modifier.fillMaxWidth().height(220.dp).padding(start = 24.dp, end = 54.dp)
            )

            val pagerState = rememberPagerState(initialPage = 2) { usersReviews.size }
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 40.dp),
                pageSpacing = 8.dp
            ) {
                UserReviewCard(review = usersReviews[it])
            }

        }

    }

    Column(
        modifier = Modifier.fillMaxWidth().weight(0.3f).padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(R.string._3_day_free_trial),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        PrimaryButton(text = stringResource(R.string.subscribe_for_month)) { /*TODO*/ }

        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_shield_user),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Text(text = " No payment now!")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PaywallScreenPreview() = AIGeneratorTheme {
    PaywallScreenContent()
}

private val usersReviews = listOf(
    UserReview(
        user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
        review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
        rating = 3
    ),
    UserReview(
        user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
        review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
        rating = 5
    ),
    UserReview(
        user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
        review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
        rating = 5
    ),
    UserReview(
        user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
        review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
        rating = 4
    ),
    UserReview(
        user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
        review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
        rating = 5
    )
)