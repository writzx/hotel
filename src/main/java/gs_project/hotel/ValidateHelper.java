package gs_project.hotel;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelper {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PHONE_NUMBER_REGEX=
            Pattern.compile("\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$",Pattern.CASE_INSENSITIVE);



    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    public static boolean validatePhone(String phone) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX .matcher(phone);
        return matcher.find();
    }

    public static void main(String... args){
        Scanner sc=new Scanner(System.in);
        //System.out.println("Enter your Email:");
        //String email=sc.nextLine();
        //boolean k=validateEmail(email);
        String phone=sc.nextLine();
        boolean l=validatePhone(phone);
        //if(k==true) System.out.println("email accepted");
        //else System.out.println("email not accepted");
        if(l==true) System.out.println("phone no accepted");
        else System.out.println("phone number not accepted");
        sc.close();

    }
}
