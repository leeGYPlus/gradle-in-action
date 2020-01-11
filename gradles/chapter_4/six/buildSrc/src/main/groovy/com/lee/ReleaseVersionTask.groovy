package com.lee;


import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class ReleaseVersionTask extends DefaultTask{

    // 通过注解声明 task 的输入和输出
    @Input Boolean release
    @OutputFile
    File destFile

    // 在构造器中设置 task 的 group 和 description 属性
    ReleaseVersionTask(){
        group = 'versioning'
        description = 'Make project a release version.'
    }

    // 通过注解声明被执行的方法
    @TaskAction
    void start(){
        project.version.release = true
        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: 'true')
        }
    }
}