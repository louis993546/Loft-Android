@file:Suppress("NOTHING_TO_INLINE")

package io.github.louistsaitszho.loft.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

inline fun TextView.getInputText(): String = this.text.toString()

inline fun Fragment.showSoftKeyboard() {
    (this.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this.view, InputMethodManager.SHOW_IMPLICIT)
}

inline fun Fragment.hideSoftKeyboard() {
    (this.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(this.view?.windowToken, 0)
}