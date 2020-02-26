package com.gylee.gradleplugin2


import org.gradle.api.Plugin
import org.gradle.api.Project

public class TwoPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.task('testTask').doLast {
            print 'Hello gradle plugin'
        }
    }
}