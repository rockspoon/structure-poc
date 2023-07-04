package com.example.poc.core.data.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Fake data for testing
 */
class ProductLocalDataSourceImpl(
    private val initialItems: List<Product> = INITIAL_ITEMS
) : ProductLocalDataSource {

    override val products: Flow<List<Product>> = flowOf(initialItems)

    override fun get(productId: Long): Flow<Product> {
        val product = initialItems.first { it.id == productId }
        return flowOf(product)
    }

    override suspend fun list(
        query: String?,
        pageSize: Int?,
        cursorId: Long
    ): List<Product> {
        // simulates a SQL like query
        return initialItems
            .filter { it.id!! > cursorId }
            .searchLike(query ?: "")
            .let { if (pageSize != null) it.take(pageSize) else it }
    }

    /**
     * Search using like extension.
     */
    private fun List<Product>.searchLike(query: String) = this
        .map { Pair(it, it.like(query)) }
        .filter { it.second }
        .map { it.first }

    private fun Product.like(query: String = ""): Boolean = query.isBlank() ||
            id.toString().like(query) ||
            title.like(query)

    /**
     * Returns true if the string is similar to the other.
     */
    // NOTE This algorithm can be improved. It's probably better do a likelihood probability score
    // and sort the list by it. Or yet use an library. An easy system is count the number of common
    // chars and give weight 3 if in the beginning, 2 if sequential, and 1 if simply appears.
    private fun String.like(query: String = ""): Boolean {
        val queryLowercase = query.lowercase()
        val stringLowercase = this.lowercase()

        // If only one letter, just check the first one because otherwise the match is meaningless.
        if (queryLowercase.length == 1) return stringLowercase.startsWith(queryLowercase)
        return stringLowercase.contains(queryLowercase.lowercase())
    }

    companion object {
        val INITIAL_ITEMS = listOf(
            Product(1, "Coca-cola"),
            Product(2, "RedBull"),
            Product(3, "Sushi"),
            Product(4, "King fish"),
            Product(
                id = 5,
                title = "Big Mac",
                imageUrl = "",
                description = "The Big Mac is a hamburger sold by the international fast food restaurant chain McDonald's. It was introduced in the Greater Pittsburgh area in 1967 and across the United States in 1968. It is one of the company's flagship products and signature dishes. The Big Mac contains two beef patties, cheese, shredded lettuce, pickles, minced onions, and a Thousand Island-type dressing advertised as \"special sauce\", on a three-slice sesame-seed bun. "
            ),
            Product(6, "Fries"),
            Product(7, "Pizza Pasta"),
            Product(8, "Ramen"),
            Product(9, "Food"),
            Product(10, "Food"),
            Product(11, "Food"),
            Product(12, "Food"),
            Product(13, "Food"),
            Product(14, "Food"),
            Product(15, "Food"),
            Product(16, "Food"),
            Product(17, "Food"),
            Product(18, "Food"),
            Product(19, "Food"),
            Product(20, "Food"),
            Product(21, "Coca-cola"),
            Product(22, "RedBull"),
            Product(23, "Sushi"),
            Product(24, "King fish"),
            Product(25, "Burger"),
            Product(26, "Fries"),
            Product(27, "Food"),
            Product(28, "Food"),
            Product(29, "Food"),
            Product(30, "Food"),
            Product(31, "Food"),
            Product(32, "Food"),
            Product(33, "Food"),
            Product(34, "Food"),
            Product(35, "Food"),
            Product(36, "Food"),
            Product(37, "Food"),
            Product(38, "Food"),
            Product(39, "Food"),
            Product(40, "Food")
        )
    }
}