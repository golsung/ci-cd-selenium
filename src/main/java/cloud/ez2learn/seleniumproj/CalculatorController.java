package cloud.ez2learn.seleniumproj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculatorController {

    @RequestMapping("/")
    public String home() {
        return "Welcome GitHub Action Home!";
    }

    @RequestMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        Calculator calculator = new Calculator(a, b);

        return calculator.getSum();
    }

    // @RequestMapping("/diff")
    // public int diff(@RequestParam("a") int a, @RequestParam("b") int b) {
    //     Calculator calculator = new Calculator(a, b);

    //     return calculator.getDifference();
    // }

}

