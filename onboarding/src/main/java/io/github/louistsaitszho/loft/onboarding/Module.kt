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
package io.github.louistsaitszho.loft.onboarding

import io.github.louistsaitszho.loft.onboarding.creation.CreationRepository
import io.github.louistsaitszho.loft.onboarding.creation.CreationRepositoryImpl
import io.github.louistsaitszho.loft.onboarding.creation.CreationViewModel
import io.github.louistsaitszho.loft.onboarding.joining.JoiningViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class Module {
    companion object {
        val onboardingModule = module {
            single<CreationRepository> { CreationRepositoryImpl(get(), get()) }

            viewModel { JoiningViewModel() }
            viewModel { CreationViewModel(repository = get()) }
        }
    }
}