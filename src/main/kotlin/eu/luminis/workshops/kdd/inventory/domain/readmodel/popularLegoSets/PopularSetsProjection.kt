package eu.luminis.workshops.kdd.inventory.domain.readmodel.popularLegoSets

import eu.luminis.workshops.kdd.inventory.domain.writemodel.legoset.LegoSetBookedEvent
import eu.luminis.workshops.kdd.inventory.domain.writemodel.legoset.LegoSetEvent
import eu.luminis.workshops.kdd.lego.domain.LegoSetNumber
import eu.luminis.workshops.kdd.system.eventbus.EventBus
import java.time.Instant

class PopularSetsProjection(
    eventBus: EventBus<LegoSetEvent>,
    private val nowProvider: () -> Instant = Instant::now
) {
    init {
        eventBus.subscribe(::handleEvent)
    }

    fun mostPopularSets(): List<LegoSetBookingCounts> = TODO()

    private fun handleEvent(event: LegoSetEvent) {
        when (event) {
            is LegoSetBookedEvent -> updateBookingCounts(event)
            else -> {}
        }
    }

    private fun updateBookingCounts(event: LegoSetBookedEvent) {
        TODO()
    }
}

data class LegoSetBookingCounts(
    val legoSet: LegoSetNumber,
    val timesBookedLast2Weeks: Int,
    val timesBooked2WeeksBefore: Int,
    val timesBookedAllTime: Int,
)