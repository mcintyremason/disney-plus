package EndOfZWorld

import spock.lang.Specification
import java.util.ArrayList;

class AppTest extends Specification {
    def "total combinations for a dollar equals 242"() {
        setup:
        def app = new App()

        when:
        app.main("Quarter,4,Dime,10,Nickel,20,Penny,100")

        then:
        app.comboCount == 242
    }

    def "total combinations for arbitraty list of values"() {
        setup:
        def app = new App()
        app.comboCount = 0
        app.formats = new ArrayList<Integer>();

        when:
        app.main("Coin,1.5,Arrowhead,3,Button,150")

        then:
        app.comboCount == 6
    }
}
