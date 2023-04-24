package com.example.poc.search.ui.detail

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
import com.example.poc.search.R
import com.example.poc.search.data.Product
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
                    text = stringResource(R.string.product_details),
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

// Note: Paging preview only works in interactive mode
// See https://issuetracker.google.com/issues/194544557
@Preview(showBackground = true)
@Composable
private fun ProductScreenNotEmptyPreview() {
    ProductScreen(
        uiState = ProductUiState(
            product = Product(
                id = 38488120,
                title = "Big Mac",
                drawableId = com.example.poc.core.ui.R.drawable.ic_fastfood,
                description = "The Big Mac is a hamburger sold by the international fast food restaurant chain McDonald's. It was introduced in the Greater Pittsburgh area in 1967 and across the United States in 1968. It is one of the company's flagship products and signature dishes. The Big Mac contains two beef patties, cheese, shredded lettuce, pickles, minced onions, and a Thousand Island-type dressing advertised as \"special sauce\", on a three-slice sesame-seed bun. "
            ),
            isLoading = false
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