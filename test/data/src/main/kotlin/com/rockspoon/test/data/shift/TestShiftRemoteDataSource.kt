package com.rockspoon.test.data.shift

import com.rockspoon.merchant.core.data.shift.Shift
import com.rockspoon.merchant.core.data.shift.ShiftEvent
import com.rockspoon.merchant.core.data.shift.ShiftRemoteDataSource
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.math.roundToLong

class TestShiftRemoteDataSource(
    val initialItems: List<Shift> = INITIAL_ITEMS
) : ShiftRemoteDataSource {

    private val items: MutableList<Shift> = initialItems.toMutableList()

    override suspend fun getShift(id: String?): Shift? {
        return if (id == null) findNonFinishedShift()
        else items.find { it.id == id }
            ?: throw RuntimeException("Entity with ID '$id' not found.")
    }

    private fun findNonFinishedShift(): Shift? =
        items.find { it.events.last().subType != ShiftEvent.SubType.END }

    override suspend fun updateShift(shift: Shift): Shift {
        val oldItem = items.find { it.id == shift.id }
        val index = items.indexOf(oldItem)
        items.remove(oldItem)
        items.add(index, shift)
        return shift
    }

    override suspend fun insertShift(shift: Shift): Shift {
        this.items.add(shift)
        return shift
    }

    override suspend fun listShifts(
        startDatetime: Instant?,
        endDatetime: Instant?,
        pageSize: Int,
        next: String,
        previous: String
    ): List<Shift> {
        return if (startDatetime != null && endDatetime != null) items.filter { shift ->
            val startEvent = shift.events.find { it.type == ShiftEvent.Type.SHIFT }!!
            startEvent.datetime > startDatetime && startEvent.datetime < endDatetime
        } else items
    }

    companion object {
        val INITIAL_ITEMS = listOf(
            Shift(
                id = "1",
                shiftMaxDurationInMinutes = 8 * 60,
                mealBreakMaxDurationInMinutes = 1 * 60,
                restBreakMaxDurationInMinutes = (.5 * 60).roundToLong(),
                waiveBreakMaxDurationInMinutes = 0,
                events = listOf(
                    ShiftEvent(
                        "1",
                        "1",
                        "1",
                        ShiftEvent.Type.SHIFT,
                        ShiftEvent.SubType.START,
                        Clock.System.now()
                    )
                )
            )
        )
    }
}