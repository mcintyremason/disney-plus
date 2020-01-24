package MakeChange

import spock.lang.Specification

class AppTest extends Specification {
    def "total combinations for a dollar equals 242"() {
        setup:
        def app = new App()

        when:
        app.main()

        then:
        app.comboCount == 242
    }
}
