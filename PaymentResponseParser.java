import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentResponseParser {
     public static void main(String[] args) {
        String response = "{\n" +
                "  status: 1,\n" +
                "  msg: \"Card Stored Successfully.\",\n" +
                "  cardToken: \"917757449926e57ff2662\",\n" +
                "  card_number: \"XXXXXXXXXXXX1165\",\n" +
                "  card_label: \"My_card\",\n" +
                "  network_token: \"44173XXX1000XXX1\",\n" +
                "  issuer_token: \"QQ3LkzgZOnEjY428\",\n" +
                "}";

        // Regex pattern to capture all desired fields at once
        String regexPattern = "cardToken: \"(.*?)\".*?" +
                              "card_number: \"(.*?)\".*?" +
                              "card_label: \"(.*?)\".*?" +
                              "network_token: \"(.*?)\".*?" +
                              "issuer_token: \"(.*?)\"";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regexPattern, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);

        // Extract and print the fields if the pattern matches
        if (matcher.find()) {
            System.out.println("cardToken: " + matcher.group(1));
            System.out.println("card_number: " + matcher.group(2));
            System.out.println("card_label: " + matcher.group(3));
            System.out.println("network_token: " + matcher.group(4));
            System.out.println("issuer_token: " + matcher.group(5));
        } else {
            System.out.println("No match found!");
        }
    }
}