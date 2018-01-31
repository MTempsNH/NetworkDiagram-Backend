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
        model.addAttribute("primeNumbers", determinePrime(2, dest, "0,1,"));
    };

    public String determinePrime(Integer count, Integer dest, String primeNumbers){

        if(count >= dest){
            return primeNumbers;
        }

        if(numeric.isPrime(count)){
            primeNumbers = primeNumbers + count + ',';
        }
        
        count++;

        return determinePrime(count, dest, primeNumbers);
    }
}