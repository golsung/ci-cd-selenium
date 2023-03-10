package cloud.ez2learn.seleniumproj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class CalculatorController {

//    @PostMapping("/sum")
//    public int sum(@RequestBody Operand operand) {
//       Calculator calculator = new Calculator(operand.getA1(), operand.getA2());
//        return calculator.getResult();
//    }

    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        Calculator calculator = new Calculator(a, b);
        return calculator.getResult();
    }

    // @RequestMapping("/diff")
    // public int diff(@RequestParam("a") int a, @RequestParam("b") int b) {
    //     Calculator calculator = new Calculator(a, b);

    //     return calculator.getDifference();
    // }

}

