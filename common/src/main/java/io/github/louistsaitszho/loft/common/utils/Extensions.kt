@file:Suppress("NOTHING_TO_INLINE")

package io.github.louistsaitszho.loft.common.utils

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

/**
 * This place houses a bunch of random extension functions
 * TODO a lot of them are probably replaceable by android-ktx, but I'm still stuck at support 27.1.1
 *   right now because of the stupid navigation
 */

inline fun TextView.getInputText(): String = this.text.toString()

/**
 * Show keyboard + focus on that edit text. Exactly as the name suggest
 * @receiver is the EditText that you want to focus on
 * @param fragment is needed to get the activity to get system service to access keyboard -_-
 */
inline fun EditText.showSoftKeyboardAndFocus(fragment: Fragment) {
    if (this.requestFocus()) {
        (fragment.requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}

inline fun Fragment.hideSoftKeyboard() {
    (this.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(this.view?.windowToken, 0)
}

//Add 1 item to MutableLiveData<List>>
inline fun <T> MutableLiveData<List<T>>.addItem(t: T) {
    this.postValue(when {
        this.value == null -> listOf(t)
        else -> this.value?.plus(t)
    })
}

inline fun <T> MutableList<T>.reset(newList: List<T>): MutableList<T> {
    this.clear()
    this.addAll(newList)
    return this
}