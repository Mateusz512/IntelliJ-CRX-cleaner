package com.github.mateusz512.crxcleaner.configuration

import com.intellij.openapi.components.Service

@Service
class ConfigurationProvider {

    val obsoleteAttributes = setOf(
            """jcr:lastModified.*""".toRegex(),
            """jcr:created.*""".toRegex(),
            """jcr:isCheckedOut""".toRegex(),
            """cq:lastReplicat.*""".toRegex(),
            """cq:lastModifi.*""".toRegex(),
            """dam:extracted""".toRegex(),
            """dam:assetState""".toRegex(),
            """dc:modified""".toRegex(),
            """.*_x0040_.*""".toRegex(),
            """jcr:uuid""".toRegex()
        )
    
}
