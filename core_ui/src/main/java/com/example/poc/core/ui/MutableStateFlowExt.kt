package com.example.poc.core.ui

import kotlinx.coroutines.flow.MutableStateFlow

// TODO check if this shit I found on web is correct https://www.droidcon.com/2021/08/25/make-sure-to-update-your-stateflow-safely-in-kotlin/
// TODO put this in commons? We need a :core_commons for this kind of extension or it
//  can also be put here in ui because now it's being used by UI implementations
inline fun <T> MutableStateFlow<T>.update(block: (T) -> T) {
    while (true) {
        val prevValue = value
        val nextValue = block(prevValue)
        if (compareAndSet(prevValue, nextValue)) {
            return
        }
    }
}