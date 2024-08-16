package dev.allay.moody.config

import com.squareup.moshi.JsonClass
import java.util.concurrent.TimeUnit

@JsonClass(generateAdapter = true)
data class MoodyConfig(
    val enabled: Boolean = true,
    val delay: MoodyTime = MoodyTime(1, TimeUnit.SECONDS),
    val types: List<MoodyType> = listOf(
        MoodyType(
            "4d8257956e3876da0af97a1117ed814b720b4d045fd52bed85f74113523eacb7",
            listOf(":)"),
        ),
        MoodyType(
            "5c9b725f495221290543690643c96bab9b0327cb2b61258a7fed4a44679df48",
            listOf(":0", ":o", ":O"),
        ),
        MoodyType(
            "6f929c74b8fa4fc258224b2fa0ef6851fd5f7ac6d99eb796b2d87725ea3f631",
            listOf(":]", ":|"),
        ),
        MoodyType(
            "1d0f2925df37fbd5f80829cafb3e9e9ac00f75a991b2131c26e0b2198e300018",
            listOf("<3"),
        ),
        MoodyType(
            "47b7a9c64f7aa04c46a596003b145113494877ecbf656ea97320e624d25680f",
            listOf(":*"),
        ),
        MoodyType(
            "3539ee32cd3ded2d185e1cb68586bc4d5f35e2b6a60a1b9b7113ca1421e82e",
            listOf(":D", ":d"),
        ),
        MoodyType(
            "1b497d21df087f4092ae3ef9249452dfc126bf3e7f295583910b19381ae9eb85",
            listOf("-_-"),
        ),
        MoodyType(
            "bf1e03da7e1e1eb2a12a4f991b06dffb3be4a7fcc7ab33fe7dbe7ebf9283a65a",
            listOf(":."),
        ),
        MoodyType(
            "b62bbc5f291b1968b86155444f4961e9b963506d7f25c9af3de7d871fdb50f0f",
            listOf(";)"),
        ),
        MoodyType(
            "574aee6e8726947c4a9355e5897585f48ae8bf00e261d78e5769c975eddb9462",
            listOf(";("),
        ),
        MoodyType(
            "d7255504f5d9a4aa26ce89b28428e72cc6d9459c100ba22fc4ccc3a1b169b8a0",
            listOf("oo"),
        ),
        MoodyType(
            "3ebc1c39e87166f4507459a61f2fba2c62ef03b8ecdfa30db09345525745f199",
            listOf(":[]"),
        ),
        MoodyType(
            "82e2063d7470ab811cc9073d9d0cb270f0a760db01fcbb87b1908d5e395070ed",
            listOf(":--|", ":--/", ":-/"),
        ),
        MoodyType(
            "bc8277af4e7f965b17c4369fe680d3fe88b94269b52496c09a1cf5016f7f516e",
            listOf(":>"),
        ),
        MoodyType(
            "6910b22b5f29eef94ab4207484281bb69c5286c161753a154510342a114d718c",
            listOf("-.-"),
        ),
        MoodyType(
            "a79812621484cd2f0b0158d83ca39fef48024f0be588a5a5d23238b3afe90d99",
            listOf(">:("),
        ),
        MoodyType(
            "a79812621484cd2f0b0158d83ca39fef48024f0be588a5a5d23238b3afe90d99",
            listOf(">:("),
        ),
        MoodyType(
            "551c8e23ddf916cf15e69615dea1dce20e697b9bbf9f28840c42ab929745128e",
            listOf(":}"),
        ),
        MoodyType(
            "d1207ffe69f06f7b8173bf5b924c4d8f7976383c7e59dce538ffa63af84d7595",
            listOf("::}"),
        ),
        MoodyType(
            "408ffac078376cfd47de892904d014a8e0c56f4924575d400264a7c62607df65",
            listOf("^^"),
        ),
        MoodyType(
            "b003750d959cd5685ce4697ff6d3ff6b1d8f2f40afbf1ff625393fa071b4681a",
            listOf("xd", "xD", "XD", "Xd"),
        ),
    ),
)
