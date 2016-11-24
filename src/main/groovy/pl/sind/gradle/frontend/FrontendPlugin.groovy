package pl.sind.gradle.frontend

import org.gradle.api.Plugin
import org.gradle.api.Project


class FrontendPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create(FrontendPluginExtension.NAME, FrontendPluginExtension, project)
    }
}
