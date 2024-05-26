package Колекции;
import java.math.BigInteger;
import java.util.*;

public class DifferentMapRealization {
    public static void main(String[] args) {
        Map<BigInteger,String> telephoneBook = new LinkedHashMap<>();
        telephoneBook.put(new BigInteger("89217255054"),"Сидоров Агафон Никанорович");
        telephoneBook.put(new BigInteger("89535720971"),"Петров Петр Петрович");
        telephoneBook.put(new BigInteger("89103315675"),"Иванов Иван Иванович");
        telephoneBook.put(new BigInteger("89297255382"),"Александров Алексей Николаевич");
        telephoneBook.put(new BigInteger("89535729876"),"Павлов Михаил Петрович");
        telephoneBook.put(new BigInteger("89123785603"),"Смирнов Илья Михайлович");

        Map<BigInteger, String> telephoneBook1 = new HashMap<>();
        telephoneBook1.putAll(telephoneBook);
        for (Map.Entry<BigInteger,String> e: telephoneBook1.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.println(e.getValue());
        }
        System.out.println();

        for (Map.Entry<BigInteger,String> e: telephoneBook.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.println(e.getValue());
        }
        System.out.println();

        Map<BigInteger,String> sortedTelephoneBook = new TreeMap<>(telephoneBook1);
        for (Map.Entry<BigInteger,String> e: sortedTelephoneBook.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.println(e.getValue());
        }

    }
}