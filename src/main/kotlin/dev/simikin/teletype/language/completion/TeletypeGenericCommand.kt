package dev.simikin.teletype.language.completion

enum class TeletypeGenericCommand(val command: String, val key: String) {
    NULL("^@", "\\0"),
    START_OF_HEADER("^A", "\\1"),
    START_OF_TEXT("^B", "\\2"),
    END_OF_TEXT("^C", "\\3"),
    END_OF_TRANSMISSION("^D", "\\4"),
    ENQUIRY("^E", "\\5"),
    ACKNOWLEDGE("^F", "\\6"),
    BELL("^G", "\\a"),
    BACKSPACE("^H", "\\b"),
    TAB("^I", "\\t"),
    NEW_LINE("^J", "\\n"),
    VERTICAL_TAB("^K", "\\v"),
    FORM_FEED("^L", "\\f"),
    CARRIAGE_RETURN("^M", "\\r"),
    SHIFT_OUT("^N", "\\16"),
    SHIFT_IN("^O", "\\17"),
    DATA_LINK_ESCAPE("^P", "\\20"),
    DATA_CONTROL_1("^Q", "\\21"),
    DATA_CONTROL_2("^R", "\\22"),
    DATA_CONTROL_3("^S", "\\23"),
    DATA_CONTROL_4("^T", "\\24"),
    NEGATIVE_ACKNOWLEDGE("^U", "\\25"),
    SYNCHRONIZE("^V", "\\26"),
    END_TEXT_BLOCK("^W", "\\27"),
    CANCEL("^X", "\\30"),
    END_OF_MEDIUM("^Y", "\\31"),
    SUBSTITUTE("^Z", "\\32"),
    ESCAPE("^[", "\\33"),
    FILE_SEPARATOR("^\\", "\\34"),
    GROUP_SEPARATOR("^]", "\\35"),
    RECORD_SEPARATOR("^^", "\\36"),
    UNIT_SEPARATOR("^_", "\\37"),
    DELETE("^?", "\\177");

    companion object {
        private val mapping = values().associateBy(TeletypeGenericCommand::command)
        fun fromSymbol(symbol: String) = mapping[symbol]
    }
}
