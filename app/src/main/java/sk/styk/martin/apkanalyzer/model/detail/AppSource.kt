package sk.styk.martin.apkanalyzer.model.detail

enum class AppSource(val sourceName: String, val installerPackageName: String? = null) {

    GOOGLE_PLAY("Google Play", "com.android.vending"),
    AMAZON_STORE("Amazon App Store", "com.amazon.venezia"),
    SYSTEM_PREINSTALED("Pre-installed", "system"),
    UNKNOWN("Unknown");

    override fun toString(): String {
        return sourceName
    }

    companion object {
        fun valueOf(value: String): AppSource = values().firstOrNull { it.sourceName == value } ?: UNKNOWN
    }

}
