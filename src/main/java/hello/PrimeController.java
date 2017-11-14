package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrimeController {

    @RequestMapping("/prime")
    public void prime(@RequestParam(value="dest", required=false, defaultValue="100") Integer dest, Model model) {
        model.addAttribute("dest", dest);
        model.addAttribute("primeNumbers", determinePrime(dest));
    };

    public String determinePrime(Integer dest){
        Integer i = 2;
        boolean prime = true;
        String primeNumbers = "0,1,";

        do {
            if(isPrime(i)){
                primeNumbers = primeNumbers + i + ',';
            }

            i++;
        } while (i <= dest);

        return primeNumbers;
    };

    public Boolean isPrime(Integer num){
        boolean prime = true;
        Integer k = num-1;

        do {
            Integer mod = num % k;
            if(mod == 0){
                prime = false;
            }

            k--;
        } while (k > 1);

        return prime;
    };
}