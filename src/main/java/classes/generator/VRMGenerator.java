package classes.generator;
import classes.Main;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.HashMap;

public class VRMGenerator {
    private static int invalidCharacters = 0;
    private static int duplicateVRM = 0;

    int getInvalidCharacters() {
        return invalidCharacters;
    }

    int getDuplicateVRM() {
        return duplicateVRM;
    }

    public String Base_generator(int manufacture_date) {
        String registration_plate = "";
        if (manufacture_date >= 1903 && manufacture_date <= 1962) {
            registration_plate = historicVRM(manufacture_date);
        } else if (manufacture_date >= 1963 && manufacture_date <= 1982) {
            registration_plate = suffixVRM(manufacture_date);
        } else if (manufacture_date >= 1983 && manufacture_date <= 2000) {
            registration_plate = prefixVRM(manufacture_date);
        } else if (manufacture_date >= 2001) {
            registration_plate = currentVRM(manufacture_date);
        } else {
            registration_plate = datelessVRM(manufacture_date);
        }

        if(registration_plate.contains("I") || (registration_plate.contains("Q"))) {
            invalidCharacters++;
            Base_generator(manufacture_date);
        }

        if(Main.vehicle_registry.get(registration_plate) != null ){
            duplicateVRM++;
            Base_generator(manufacture_date);
        }
        return registration_plate;
    }

    private static String datelessVRM(int manufacture_date){
        return "Q" + generateDigits(3) + (generateLetters(3));
    }

    private static String historicVRM(int manufacture_date) {
        if(manufacture_date > 1930) {
            return (generateLetters(3) + generateDigits(3));
        }else{
            return (generateDigits(3) + generateLetters(3));
        }
    }

    private static String suffixVRM(int manufacture_date) {
        HashMap<Integer, String> dates = new HashMap<>();
        dates.put(1963, "A");
        dates.put(1964, "B");
        dates.put(1965, "C");
        dates.put(1966, "D");
        dates.put(1967, "E");
        dates.put(1968, "F");
        dates.put(1969, "G");
        dates.put(1970, "H");
        dates.put(1971, "J");
        dates.put(1972, "K");
        dates.put(1973, "M");
        dates.put(1974, "N");
        dates.put(1975, "P");
        dates.put(1976, "R");
        dates.put(1977, "S");
        dates.put(1978, "T");
        dates.put(1979, "V");
        dates.put(1980, "W");
        dates.put(1981, "X");
        dates.put(1982, "Y");
        return ( generateLetters(3) + generateDigits(3) + dates.get(manufacture_date));
    }

    private static String prefixVRM(int manufacture_date) {
        HashMap<Integer, String> dates = new HashMap<>();
        dates.put(1983, "A");
        dates.put(1984, "B");
        dates.put(1985, "C");
        dates.put(1986, "D");
        dates.put(1987, "E");
        dates.put(1988, "F");
        dates.put(1989, "G");
        dates.put(1990, "H");
        dates.put(1991, "J");
        dates.put(1992, "K");
        dates.put(1993, "L");
        dates.put(1994, "M");
        dates.put(1995, "N");
        dates.put(1996, "P");
        dates.put(1997, "R");
        dates.put(1998, "S");
        dates.put(1999, "T");
        dates.put(2000, "V");
        dates.put(2001, "W");
        return ( dates.get(manufacture_date) + generateDigits(3) + generateLetters(3));
    }

    private static String currentVRM(int manufacture_date) {
        String year = String.valueOf((manufacture_date));
       return generateLetters(2) + year.substring(2,4) + generateLetters(3);
    }

    private static String generateLetters(int amount){
        return RandomStringUtils.random(amount, "ABCDEFGHJKLMNOPRSTUVWXY");
    }

    private static String generateDigits(int amount){
        return RandomStringUtils.random(amount, "0123456789");
    }

}



