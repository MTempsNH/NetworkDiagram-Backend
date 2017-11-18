package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import hello.Numeric;

@Controller
public class PrimeController {

    @Autowired
    Numeric numeric;

    @RequestMapping("/prime")
    public void prime(@RequestParam(value="dest", required=false, defaultValue="100") Integer dest, Model model) {
        model.addAttribute("dest", dest);
        model.addAttribute("primeNumbers", determinePrime(dest));
    };

    public String determinePrime(Integer dest){
        Integer i = 2;
        String primeNumbers = "0,1,";

        do {
            if(numeric.isPrime(i)){
                primeNumbers = primeNumbers + i + ',';
            }
            
            i++;
        } while (i <= dest);

        return primeNumbers;
    };
}