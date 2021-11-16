package toy.playvip.utils

import spock.lang.Specification

class CalculationUtilTest extends Specification {
    def "최대값 테스트"(){
        when:
        def x = Math.max(1,2)
        then:
        x == 2
    }

    def "두 수 비교"(){
        expect:
        Math.max(a,b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }
}
