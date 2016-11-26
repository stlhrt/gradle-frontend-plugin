package pl.sind.gradle.frontend.util

import org.gradle.internal.impldep.com.google.common.collect.ImmutableMap

class PlatformHelper {
    private final ImmutableMap<String, String> props

    private PlatformHelper(Map<String, String> properties) {
        this.props = ImmutableMap.copyOf(properties)
    }

    private String getProp(final String name) {
        props.get name, System.getProperty(name)
    }

    String getOs() {
        final String name = getProp("os.name").toLowerCase()
        if (name.contains("windows")) {
            return "windows"
        }

        if (name.contains("mac")) {
            return "darwin"
        }

        if (name.contains("linux")) {
            return "linux"
        }

        if (name.contains("freebsd")) {
            return "linux"
        }

        if (name.contains("sunos")) {
            return "sunos"
        }

        throw new IllegalArgumentException("Unsupported OS: " + name)
    }

    String getArch() {
        final String arch = getProp("os.arch").toLowerCase()
        if (arch.contains("64")) {
            return "x64"
        }
        //as Java just returns "arm" on all ARM variants, we need a system call to determine the exact arch
        if (arch.equals("arm")) {
            def systemArch = 'uname -m'.execute().text.trim()
            //the node binaries for 'armv8l' are called 'arm64', so we need to distinguish here
            if (systemArch.equals("armv8l")) {
                return "arm64"
            } else {
                return systemArch
            }
        }

        return "x86"
    }

    boolean isWindows() {
        return this.os == 'windows'
    }

    static PlatformHelper fromSystem(){
        return new PlatformHelper(System.getProperties())
    }

    static PlatformHelper fromMap(Map<String, String> map){
        return new PlatformHelper(map)
    }
}
