package Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController



@RestController

@Controller
class MainController{
   // @GetMapping(value = "/")
    fun homepage(): String {
        return "index"
    }


}