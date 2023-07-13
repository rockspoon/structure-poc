package com.example.poc.orders.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poc.orders.R
import com.example.poc.orders.data.Product
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProductScreen(
    viewModel: ProductViewModel = koinViewModel(),
    onBackClick: (() -> Unit) = { }
) {
    ProductScreen(
        uiState = viewModel.uiState,
        onBackClick = onBackClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductScreen(
    uiState: ProductUiState,
    onBackClick: (() -> Unit) = { }
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        MediumTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.order_details),
                    style = MaterialTheme.typography.headlineLarge
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
            }
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .weight(1f)
        ) {
            uiState.product?.let { item ->
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(4.dp),
                    painter = painterResource(id = item.drawableId),
                    contentDescription = item.title
                )
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp, top = 24.dp, end = 4.dp, bottom = 4.dp)
                        .align(Alignment.CenterHorizontally),
                    text = item.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "ID ${item.id}",
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    text = item.description,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            shape = MaterialTheme.shapes.large,
            onClick = { onBackClick.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(text = stringResource(R.string.dismiss))
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
private fun ProductScreenLoadingPreview() {
    ProductScreen(
        uiState = ProductUiState(
            isLoading = true
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenErrorPreview() {
    ProductScreen(
        uiState = ProductUiState(
            product = Product(0, "Burger"),
            isLoading = false,
            error = RuntimeException("Invalid query exception.")
        )
    )
}