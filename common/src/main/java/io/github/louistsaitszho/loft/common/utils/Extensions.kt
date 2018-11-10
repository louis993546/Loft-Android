@file:Suppress("NOTHING_TO_INLINE")

package io.github.louistsaitszho.loft.common.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * This place houses a bunch of random extension functions
 * TODO a lot of them are probably replaceable by android-ktx, but I'm still stuck at support 27.1.1
 *   right now because of the stupid navigation
 */

inline fun EditText.getInputText(): String = text.toString()

/**
 * Show keyboard + focus on that edit text. Exactly as the name suggest. Note that if it cannot
 * focus on this EditText, keyboard will not be trigger.
 *
 * @receiver is the EditText that you want to focus on
 */
inline fun EditText.showSoftKeyboardAndFocus() {
    if (requestFocus()) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}

inline fun Fragment.hideSoftKeyboard() {
    (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(view?.windowToken, 0)
}