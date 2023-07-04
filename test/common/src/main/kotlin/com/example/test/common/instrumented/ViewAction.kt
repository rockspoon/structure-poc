package com.example.test.common.instrumented

import android.graphics.Rect
import android.view.InputDevice
import android.view.MotionEvent
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.annotation.Px
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.action.GeneralClickAction
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.Tap
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import org.hamcrest.Matcher
import org.hamcrest.Matchers

/**
 * Drags a view from a location to a location.
 *
 * Example usage:
 *
 * ```
 * val dx = findViewById<Slide>(R.id.my_slide).marginStart
 * ...
 * onView(withId(R.id.my_slide))
 *      .perform(drag(from = GeneralLocation.CENTER_LEFT, to = GeneralLocation.CENTER))
 * ```
 * @param from start location of coordinates. Ex: GeneralLocation.CENTER_LEFT
 * @param fromDx the horizontal offset in pixels from the start position.
 * @param fromDy the vertical offset in pixels from the start position.
 * @param to end location of coordinates. Ex: GeneralLocation.CENTER
 * @param toDx the horizontal offset in pixels from the end position.
 * @param toDy the vertical offset in pixels from the end position.
 */
@Suppress("LongParameterList")
fun drag(
    from: CoordinatesProvider,
    @Px fromDx: Int = 0,
    @Px fromDy: Int = 0,
    to: CoordinatesProvider,
    @Px toDx: Int = 0,
    @Px toDy: Int = 0
): ViewAction = ViewActions.actionWithAssertions(
    GeneralSwipeAction(
        Swipe.SLOW,
        { view ->
            val coordinates = from.calculateCoordinates(view)
            coordinates[0] = coordinates[0] + fromDx
            coordinates[1] = coordinates[1] + fromDy
            coordinates
        },
        { view ->
            val coordinates = to.calculateCoordinates(view)
            coordinates[0] = coordinates[0] + toDx
            coordinates[1] = coordinates[1] + toDy
            coordinates
        },
        Press.FINGER
    )
)

/**
 * Click in a view with a span from the preferred location.
 *
 * Example usage:
 *
 * ```
 * val dx = findViewById<View>(R.id.my_view).marginStart
 * ...
 * onView(withId(R.id.my_view))
 *      .perform(click(GeneralLocation.CENTER_LEFT, dx))
 * ```
 *
 * @param location start location of coordinates. Ex: GeneralLocation.CENTER_LEFT
 * @param dx pixel offset on x-axis
 * @param dy pixel offset on y-axis
 */
fun click(
    location: CoordinatesProvider,
    @Px dx: Int = 0,
    @Px dy: Int = 0
): ViewAction = ViewActions.actionWithAssertions(
    GeneralClickAction(
        Tap.SINGLE,
        { view ->
            location.calculateCoordinates(view).apply {
                this[0] = this[0] + dx
                this[1] = this[1] + dy
            }
        },
        Press.FINGER,
        InputDevice.SOURCE_UNKNOWN,
        MotionEvent.ACTION_DOWN
    )
)

/**
 * Implements a scroll to action in nested scroll views.
 *
 * Notice that usually nesting scroll views are not advised and it should be flatten,
 * so this test class should most of the cases not benecessary.
 */
fun nestedScrollTo(): ViewAction = ViewActions.actionWithAssertions(
    object : ViewAction {

        override fun getConstraints(): Matcher<View> {
            return Matchers.allOf(
                ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
                ViewMatchers.isDescendantOfA(
                    Matchers.anyOf(
                        ViewMatchers.isAssignableFrom(ScrollView::class.java),
                        ViewMatchers.isAssignableFrom(HorizontalScrollView::class.java),
                        ViewMatchers.isAssignableFrom(NestedScrollView::class.java)
                    )
                )
            )
        }

        override fun getDescription(): String = "scroll to view"

        override fun perform(uiController: UiController?, view: View?) {
            if (ViewMatchers.isDisplayingAtLeast(90).matches(view)) {
                //View is already displayed
                return
            }
            val rect = Rect()
            view!!.getDrawingRect(rect)
            if (!view.requestRectangleOnScreen(rect, true)) {
                // Scrolling to view was requested, but none of the parents scrolled.
            }
            uiController!!.loopMainThreadUntilIdle()
            if (!ViewMatchers.isDisplayingAtLeast(90).matches(view)) {
                throw PerformException.Builder()
                    .withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(
                        RuntimeException(
                            "Scrolling to view was attempted, but the view is not displayed"
                        )
                    )
                    .build()
            }
        }
    }
)


