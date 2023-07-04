package com.example.poc.search.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.poc.search.R
import com.example.poc.search.data.Product
import kotlinx.coroutines.flow.flowOf
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ProductListScreen(
    viewModel: ProductListViewModel = koinViewModel(),
    onItemClicked: ((item: Product) -> Unit)? = null,
    onActionSettingsClicked: () -> Unit = {}
) {
    ProductListScreen(
        uiState = viewModel.uiState,
        onQueryChanged = { query ->
            viewModel.loadProducts(query = query)
        },
        onItemClickedListener = onItemClicked,
        onActionSettingsClicked = onActionSettingsClicked
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    uiState: ProductListUiState,
    onQueryChanged: ((query: String) -> Unit)? = null,
    onItemClickedListener: ((item: Product) -> Unit)? = null,
    onActionSettingsClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        MediumTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.search),
                    style = MaterialTheme.typography.headlineLarge
                )
            },
            actions = {
                IconButton(onClick = onActionSettingsClicked) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = stringResource(id = com.example.poc.settings.R.string.settings)
                    )
                }
            }
        )

        SearchTextField(
            onQueryChanged = onQueryChanged,
            error = uiState.error
        )

        val lazyPagingItems = uiState.products?.collectAsLazyPagingItems()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(200.dp)
        ) {
            lazyPagingItems?.let { lazyItems ->
                items(
                    items = lazyItems
                ) { item ->
                    ProductListItem(
                        item = item ?: Product(0, "Placeholder"),
                        onItemClickedListener = onItemClickedListener
                    )
                }
            }
        }
    }
}

// Local component
@Composable
private fun ProductListItem(
    item: Product,
    modifier: Modifier = Modifier,
    onItemClickedListener: ((item: Product) -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .clickable { onItemClickedListener?.invoke(item) }
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp)
                .padding(4.dp),
            painter = painterResource(id = item.drawableId),
            contentDescription = item.title
        )
        Column(
            Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                text = "ID ${item.id}",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview() {

    ProductListItem(
        item = Product(1, "Coca-cola")
    )
}

// In reality, a search text field would be a global component
// provided by the Design library, but if was not, like it usually the case of components
// that extends Cards, here would be the place to put.
@Composable
private fun SearchTextField(
    onQueryChanged: ((query: String) -> Unit)? = null,
    error: Throwable? = null
) {
    val query = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 12.dp),
        value = query.value,
        onValueChange = {
            query.value = it
            // TODO add a debounce?
            onQueryChanged?.invoke(it.text)
        },
        shape = MaterialTheme.shapes.extraLarge,
        leadingIcon = {
            Icon(Icons.Default.Search, null)
        },
        label = {
            Text(text = stringResource(R.string.search_label))
        },
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = stringResource(R.string.invalid_query))
            }
        }
    )
}

// Previews
@Preview(showBackground = true)
@Composable
private fun ProductListScreenLoadingPreview() {
    ProductListScreen(
        uiState = ProductListUiState(
            isLoading = true
        )
    )
}

// Note: Paging preview only works in interactive mode
// See https://issuetracker.google.com/issues/194544557
@Preview(showBackground = true)
@Composable
private fun ProductListScreenNotEmptyListPreview() {
    ProductListScreen(
        uiState = ProductListUiState(
            products = flowOf(
                PagingData.from(
                    listOf(
                        Product(1, "Test"),
                        Product(2, "Also a test")
                    )
                )
            ),
            isLoading = false
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenErrorPreview() {
    ProductListScreen(
        uiState = ProductListUiState(
            products = flowOf(
                PagingData.from(
                    listOf(
                        Product(1, "Test"),
                        Product(2, "Also a test")
                    )
                )
            ),
            isLoading = false,
            error = RuntimeException("Invalid query exception.")
        )
    )
}