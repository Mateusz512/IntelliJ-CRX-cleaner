package com.github.mateusz512.crxcleaner.configuration

import com.intellij.openapi.components.Service

@Service
class ConfigurationProvider {

    val obsoleteAttributes = setOf(
            """jcr:lastModified.*""",
            """jcr:created.*""",
            """jcr:isCheckedOut""",
            """cq:lastReplicat.*""",
            """cq:lastModifi.*""",
            """dam:extracted""",
            """dam:assetState""",
            """dc:modified""",
            """.*_x0040_.*""",
            """jcr:uuid""",
            """cq:lastRolledout.*"""
        ).map(String::toRegex)
    
}
