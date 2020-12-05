package com.github.mateusz512.intellijcrxcleaner.configuration

class ConfigurationProvider {
    companion object {
        fun getObsoleteAttributes(): Collection<Regex> {
            return setOf(
                "jcr:lastModified.*",
                "jcr:created.*",
                "jcr:isCheckedOut",
                "cq:lastReplicat.*",
                "cq:lastModifi.*",
                "dam:extracted",
                "dam:assetState",
                "dc:modified",
                ".*_x0040_.*",
                "jcr:uuid"
            ).map { it.toRegex() }
        }
    }
}