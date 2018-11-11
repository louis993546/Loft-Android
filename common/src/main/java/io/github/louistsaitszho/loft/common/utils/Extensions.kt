/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
@file:Suppress("NOTHING_TO_INLINE")

package io.github.louistsaitszho.loft.common.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.nio.charset.Charset
import kotlin.random.Random

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

inline fun Activity.openCamera(requestCode: Int) {
    Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
        takePictureIntent.resolveActivity(this.packageManager)?.also {
            startActivityForResult(takePictureIntent, requestCode)
        }
    }
}

/**
 * A simple function to make generating random string easier
 */
inline fun Random.nextString(length: Int) = String(nextBytes(length), Charset.defaultCharset())