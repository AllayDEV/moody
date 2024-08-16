package dev.allay.moody.config

data class MoodyType(
    val texture: String,
    val symbols: List<String>,
) {

    private val specialCharacters = listOf(
        "(", ")", "[", "]", "{", "}", "*", "+", "^", "|", "_",
    )

    @Transient
    val regex: Regex = Regex(buildString {
        append("(?:")
        append(symbols
            .filter { it.trim().isNotEmpty() }
            .joinToString("|") {
                specialCharacters.fold(it) { text, char ->
                    text.replace(char, "\\$char")
                }
            })
        append(")")
    }, RegexOption.CANON_EQ)

}