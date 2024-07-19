package com.example.aigenerator.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.model.User
import com.example.aigenerator.model.UserReview
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun UserReviewCard(review: UserReview, modifier: Modifier = Modifier) = Column(
    modifier = modifier
        .fillMaxWidth().clip(RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.surface).padding(16.dp)
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = review.user.profilePictureId),
                contentDescription = null,
                modifier = Modifier.size(24.dp).clip(CircleShape)
            )

            Text(
                text = review.user.name,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        RatingStars(rating = review.rating)
    }

    Text(
        text = review.review,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    UserReviewCard(userReview)
}

private val userReview = UserReview(
    user = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic),
    review = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
    rating = 3
)