package dev.allay.moody.config

import java.util.concurrent.TimeUnit

data class MoodyTime(
    val time: Long,
    val unit: TimeUnit,
)
