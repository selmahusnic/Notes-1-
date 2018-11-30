package Notes.Notes

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.IOException
import java.net.URISyntaxException
import java.awt.Desktop
import org.springframework.boot.SpringApplication
import java.net.URI


@SpringBootApplication
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
        openHomePage()
    }

    private fun openHomePage() {
        try {
            val homepage = URI("http://localhost:8080/")
            Desktop.getDesktop().browse(homepage)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}