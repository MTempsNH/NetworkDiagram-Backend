package hello;

import org.springframework.stereotype.Component;

@Component
public class Numeric {

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
    }
}