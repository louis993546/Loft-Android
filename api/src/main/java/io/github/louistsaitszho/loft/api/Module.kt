package io.github.louistsaitszho.loft.api

import org.koin.dsl.module.module

class Module {
    companion object {
        val apiModule = module {
            single<LoftApi> { LoftApiImpl() }
        }
    }
}