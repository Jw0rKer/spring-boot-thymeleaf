import github.jworker.MyApplication
import groovyx.net.http.RESTClient
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Shared

@SpringBootTest(classes = MyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class WeatherSpec extends spock.lang.Specification {
    @Shared
    def client = new RESTClient("http://localhost:80/");

    def "simple integeration test"() {
        when: " simple rest setup"

        def response = client.get(path: "current/1")

        then: "examine availabe rest"
        with(response) {
            data.id == 1
        }
    }


}