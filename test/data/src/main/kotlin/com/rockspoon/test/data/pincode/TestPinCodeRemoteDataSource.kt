package com.rockspoon.test.data.pincode

import com.rockspoon.merchant.core.data.pincode.PinCodeRemoteDataSource

/**
 * A fake pin code remote data source.
 */
class TestPinCodeRemoteDataSource(
    var pinCode: String = "1234"
) : PinCodeRemoteDataSource {

    /**
     * This update implementation generates a new pin code that is the reverse of the old one.
     */
    override suspend fun updatePinCode(currentPinCode: String): Boolean {
        return if (this.pinCode == currentPinCode) {
            this.pinCode = currentPinCode.reversed()
            true
        } else false
    }
}