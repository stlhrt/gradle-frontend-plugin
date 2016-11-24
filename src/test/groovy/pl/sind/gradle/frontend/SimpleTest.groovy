package pl.sind.gradle.frontend

import nebula.test.ProjectSpec


class SimpleTest extends ProjectSpec {

    def 'nothing'(){
        given:
        def test

        when:
        test = true

        then:
        test
    }
}
