package pl.sind.gradle.frontend.util

import spock.lang.Specification
import spock.lang.Unroll

class PlatformHelperTest
        extends Specification {

    @Unroll
    def "check os and architecture for #osProp (#archProp)"() {
        given:
        PlatformHelper helper = PlatformHelper.fromMap(["os.name": osProp, "os.arch": archProp])

        expect:
        helper.os == osName
        helper.arch == osArch
        helper.windows == isWindows

        where:
        osProp      | archProp | osName    | osArch | isWindows
        'Windows 8' | 'x86'    | 'windows' | 'x86'  | true
        'Windows 8' | 'x86_64' | 'windows' | 'x64'  | true
        'Mac OS X'  | 'x86'    | 'darwin'  | 'x86'  | false
        'Mac OS X'  | 'x86_64' | 'darwin'  | 'x64'  | false
        'Linux'     | 'x86'    | 'linux'   | 'x86'  | false
        'Linux'     | 'x86_64' | 'linux'   | 'x64'  | false
        'SunOS'     | 'x86'    | 'sunos'   | 'x86'  | false
        'SunOS'     | 'x86_64' | 'sunos'   | 'x64'  | false
    }

    def "throw exception if unsupported os"() {
        given:
        PlatformHelper helper = PlatformHelper.fromMap(["os.name": 'Nonsense', "os.arch": 'Nonsense'])

        when:
        helper.os

        then:
        thrown(IllegalArgumentException)
    }

    def "should handle system properties"() {
        given:
        PlatformHelper helper = PlatformHelper.fromSystem()

        when:
        helper.os

        then:
        helper.os != null
        helper.arch != null
        noExceptionThrown()
    }
}
