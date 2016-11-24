package pl.sind.gradle.frontend

import nebula.test.ProjectSpec


class FrontendExtensionSpec extends ProjectSpec {

    def 'should initialize extension on project apply'() {
        when:
        this.project.apply plugin: 'pl.sind.gradle-frontend-plugin'
        def ext = project.extensions.getByType(FrontendPluginExtension)

        then:
        ext != null
        ext.workDir != null
        ext.nodeModulesDir != null
        ext.nodeDir != null
        ext.cacheDir != null
        ext.distBaseUrl == 'https://nodejs.org/dist'
        ext.version == '6.9.1'


    }
}
