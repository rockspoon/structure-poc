package com.example.poc.orders.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poc.core.data.order.Order
import com.example.poc.orders.R
import com.example.poc.orders.data.toModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun OrdersScreen(
    viewModel: OrderListViewModel = koinViewModel(),
    onItemClicked: ((item: Order) -> Unit)? = null,
    onActionSettingsClicked: () -> Unit = {}
) {
    OrderListScreen(
        uiState = viewModel.uiState,
        onItemClickedListener = onItemClicked,
        onActionSettingsClicked = onActionSettingsClicked,
        onItemDeleteClickListener = viewModel::deleteItem
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun OrderListScreen(
    uiState: OrderListUiState,
    onItemClickedListener: ((item: Order) -> Unit)? = null,
    onActionSettingsClicked: () -> Unit = {},
    onItemDeleteClickListener: ((Order) -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        MediumTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.orders),
                    style = MaterialTheme.typography.headlineLarge
                )
            },
            actions = {
                IconButton(onClick = onActionSettingsClicked) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = stringResource(id = R.string.orders)
                    )
                }
            }
        )

        /* val lazyPagingItems = uiState.ordersPaging?.collectAsLazyPagingItems()

         LazyColumn(
             modifier = Modifier
                 .fillMaxWidth()
                 .weight(1f)
                 .height(200.dp)
         ) {

             lazyPagingItems?.let {
                 items(it) { order ->
                     order?.let {
                         OrderListItem(
                             item = it,
                             onItemClickedListener = onItemClickedListener
                         )
                     } ?: OrderPreview()
                 }
             }
         }*/

        if (uiState.error != null) {
            Text(text = "Error = ${uiState.error}")
            Spacer(modifier = Modifier.height(12.dp))
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(200.dp)
        ) {

            items(uiState.orders) {
                OrderListItem(
                    item = it.toModel(),
                    onItemClickedListener = null,
                    onItemDeleteClickListener = onItemDeleteClickListener
                )
            }
        }
    }
}

@Composable
fun OrderPreview(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
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
                text = "loading",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

// Local component
@Composable
private fun OrderListItem(
    item: Order,
    modifier: Modifier = Modifier,
    onItemClickedListener: ((item: Order) -> Unit)? = null,
    onItemDeleteClickListener: ((Order) -> Unit)?,
) {
    Row(
        modifier = modifier
            .clickable { onItemClickedListener?.invoke(item) }
            .padding(8.dp)
            .fillMaxWidth()
    ) {
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
                text = item.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                text = "ID ${item.id}",
                style = MaterialTheme.typography.labelSmall
            )
            Column(
                modifier = Modifier.padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Items")
                item.items.forEach {
                    OrderItem(it)
                }

            }
            Button(onClick = { onItemDeleteClickListener?.invoke(item) }) {
                Text(text = "Delete")
            }
        }

    }
}

@Composable
private fun OrderItem(item: Order.Item, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(horizontal = 5.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(size = 5.dp))
            .widthIn(100.dp)
    ) {
        Text(text = item.name)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.id.orEmpty())
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview() {

    OrderListItem(
        item = Order(name = "Coca cola"),
        onItemDeleteClickListener = null
    )
}

// Previews
@Preview(showBackground = true)
@Composable
private fun ProductListScreenLoadingPreview() {
    OrderListScreen(
        uiState = OrderListUiState(
            isLoading = true
        )
    )
}

// Note: Paging preview only works in interactive mode
// See https://issuetracker.google.com/issues/194544557
@Preview(showBackground = true)
@Composable
private fun ProductListScreenNotEmptyListPreview() {
    OrderListScreen(
        uiState = OrderListUiState(
            orders = emptyList(),
            isLoading = false
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenErrorPreview() {
    OrderListScreen(
        uiState = OrderListUiState(
            orders = emptyList(),
            isLoading = false,
            error = RuntimeException("Invalid query exception.")
        )
    )
}