package com.github.mateusz512.intellijcrxcleaner.services

import com.intellij.openapi.project.Project
import com.github.mateusz512.intellijcrxcleaner.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
