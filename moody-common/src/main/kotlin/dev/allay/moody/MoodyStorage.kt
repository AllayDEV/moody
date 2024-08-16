package dev.allay.moody

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.allay.moody.config.MoodyConfig
import okio.buffer
import okio.sink
import okio.source
import java.io.File

class MoodyStorage(
    private val file: File,
) {

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @OptIn(ExperimentalStdlibApi::class)
    private val configAdapter = moshi.adapter<MoodyConfig>()
        .indent(" ".repeat(2))

    lateinit var config: MoodyConfig

    private fun createParent() {
        val parent = file.parentFile
        if (parent.exists().not()) {
            parent.mkdirs()
        }
    }

    internal fun createConfig() {
        if (file.exists()) {
            return
        }
        createParent()
        file.createNewFile()
        file.outputStream().use {
            val bufferedSink = it.sink().buffer()
            configAdapter.toJson(bufferedSink, MoodyConfig())
            bufferedSink.close()
        }
    }

    internal fun loadConfig() {
        if (file.exists().not()) {
            return
        }
        createParent()
        file.inputStream().use {
            val bufferedSource = it.source().buffer()
            config = configAdapter.fromJson(bufferedSource)
                ?: MoodyConfig()

            bufferedSource.close()
        }
    }

}