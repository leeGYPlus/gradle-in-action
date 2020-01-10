package com.gylee.gradlep

import org.gradle.api.Plugin
import org.gradle.api.Project


public class PluginImpl implements Plugin<Project> {
    void apply(Project project) {
        project.task('testTask') << {
            println "Hello gradle plugin"
        }
    }

    public void apply2(Project project) {

        project.afterEvaluate {
            project.android.applicationVariants.each { variant ->
                def preDexTask = project.tasks.findByName("preDex${variant.name.capitalize()}")
                def dexTask = project.tasks.findByName("dex${variant.name.capitalize()}")
                def proguardTask = project.tasks.findByName("proguard${variant.name.capitalize()}")


                if (preDexTask) {
                    Set<File> preDexTaskInputFiles = preDexTask.inputs.files.files

                    project.logger.error "Name:preDexTaskInputFiles=====>${preDexTask.name}"
                    preDexTaskInputFiles.each { inputFile ->
                        def path = inputFile.absolutePath
                        project.logger.error path
                    }
                }

                if (dexTask) {
                    Set<File> dexTaskInputFiles = dexTask.inputs.files.files

                    project.logger.error "Name:dexTaskInputFiles=====>${dexTask.name}"
                    dexTaskInputFiles.each { inputFile ->
                        def path = inputFile.absolutePath
                        project.logger.error path

                    }
                }

                if (proguardTask) {
                    Set<File> proguardTaskInputFiles = proguardTask.inputs.files.files

                    project.logger.error "Name:proguardTask=====>${proguardTask.name}"
                    proguardTaskInputFiles.each { inputFile ->
                        def path = inputFile.absolutePath
                        project.logger.error path
                    }
                }
            }
        }
    }
}