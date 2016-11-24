package pl.sind.gradle.frontend

import org.gradle.api.Project


class FrontendPluginExtension {

    public static final String NAME = 'frontend'
    /**
     * Where to get node distributions from.
     */
    String distBaseUrl = 'https://nodejs.org/dist'

    /**
     * Should the extension use system installed node if it is available in correct version.
     * It uses either node found in 'nodeDir' or uses one on path if available
     */
    boolean preferSystemNode = false

    /**
     * Where plugin downloads and caches node archives
     */
    File cacheDir

    /**
     * Where node is expected to be installed.
     * Note that it defaults to local .gradle folder where should be installed.
     */
    File nodeDir

    /**
     * Where system node is installed.
     * Use when node is not available on PATH or you want to use different version.
     */
    File systemNodeDir

    /**
     * Where node command is found.
     * Defaults to install dir may be other for system installed npm
     */
    File workDir

    /**
     * Where node_modules folder should be placed
     */
    File nodeModulesDir

    /**
     * Default node version
     */
    String version = '6.9.1'

    /**
     * Defines list of packages that need to be installed via
     * npm install -g X
     * Accepts standard node syntax if one needs specific versions.
     * You can change npm version here for example.
     */
    def globalPackages = []


    FrontendPluginExtension (Project project) {
        cacheDir = new File( project.projectDir, '.gradle/nodejs/archives' )
        nodeDir = new File( project.projectDir, '.gradle/nodejs/install' )
        workDir = nodeDir
        nodeModulesDir = project.projectDir
    }
}
