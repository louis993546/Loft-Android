package io.github.louistasitszho.loft.common

import io.github.louistasitszho.loft.common.keyValueStore.KeyValueStore
import io.github.louistasitszho.loft.common.keyValueStore.KeyValueStoreImpl
import io.github.louistasitszho.loft.common.network.API
import io.github.louistasitszho.loft.common.network.APIImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

class Module {
    companion object {
        val commonModule = module {
            single<KeyValueStore> { KeyValueStoreImpl(androidApplication()) }
            single<API> { APIImpl() }
        }
    }
}