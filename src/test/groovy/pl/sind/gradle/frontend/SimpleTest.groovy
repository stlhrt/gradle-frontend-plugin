package pl.sind.gradle.frontend

import nebula.test.ProjectSpec


class SimpleTest extends ProjectSpec {

    def 'nothing'(){
        given:
        def test = new Empty(name: 'none')

        when:
        def name = test.name

        then:
        name == 'none'
    }
}
