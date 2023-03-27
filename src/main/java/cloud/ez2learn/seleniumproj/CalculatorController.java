package cloud.ez2learn.seleniumproj;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        Calculator calculator = new Calculator(a, b);
        return calculator.getSum();
    }

     @RequestMapping("/diff")
     public int diff(@RequestParam("a") int a, @RequestParam("b") int b) {
         Calculator calculator = new Calculator(a, b);

         return calculator.getDifference();
     }

}

