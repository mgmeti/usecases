import org.json.JSONObject;

public class PayUResponseParser {

  public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"status\": 1,\n" +
                "  \"msg\": \"1 out of 1 Transactions Fetched Successfully\",\n" +
                "  \"transaction_details\": {\n" +
                "    \"7fa6c4783a363b3da573\": {\n" +
                "      \"mihpayid\": \"403993715521889530\",\n" +
                "      \"request_id\": \"\",\n" +
                "      \"bank_ref_num\": \"721522\",\n" +
                "      \"amt\": \"10.00\",\n" +
                "      \"transaction_amount\": \"10.00\",\n" +
                "      \"txnid\": \"7fa6c4783a363b3da573\",\n" +
                "      \"additional_charges\": \"0.00\",\n" +
                "      \"productinfo\": \"Test\",\n" +
                "      \"firstname\": \"K\",\n" +
                "      \"bankcode\": \"CC\",\n" +
                "      \"udf1\": \"\",\n" +
                "      \"udf3\": \"\",\n" +
                "      \"udf4\": \"\",\n" +
                "      \"udf5\": \"\",\n" +
                "      \"field2\": \"177047\",\n" +
                "      \"field9\": \"No Error\",\n" +
                "      \"error_code\": \"E000\",\n" +
                "      \"addedon\": \"2020-10-26 14:12:13\",\n" +
                "      \"payment_source\": \"payu\",\n" +
                "      \"card_type\": \"UNKNOWN\",\n" +
                "      \"error_Message\": \"No Error\",\n" +
                "      \"net_amount_debit\": 10,\n" +
                "      \"disc\": \"0.00\",\n" +
                "      \"mode\": \"CC\",\n" +
                "      \"PG_TYPE\": \"CC-PG\",\n" +
                "      \"card_no\": \"512345XXXXXX2346\",\n" +
                "      \"name_on_card\": \"Test\",\n" +
                "      \"udf2\": \"\",\n" +
                "      \"status\": \"success\",\n" +
                "      \"unmappedstatus\": \"captured\",\n" +
                "      \"Merchant_UTR\": null,\n" +
                "      \"Settled_At\": \"0000-00-00 00:00:00\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Parse the JSON string into a JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);

        // Extract the `transaction_details` object
        JSONObject transactionDetails = jsonObject.getJSONObject("transaction_details");

        // The key inside `transaction_details` is dynamic, so retrieve it programmatically
        String dynamicKey = transactionDetails.keys().next();

        // Extract the nested transaction object
        JSONObject transaction = transactionDetails.getJSONObject(dynamicKey);

        // Extract the required fields
        String mihpayid = transaction.getString("mihpayid");
        String txnid = transaction.getString("txnid");
        String status = transaction.getString("status");
        String bankRefNum = transaction.getString("bank_ref_num");

        // Print the extracted fields
        System.out.println("mihpayid: " + mihpayid);
        System.out.println("txnid: " + txnid);
        System.out.println("status: " + status);
        System.out.println("bank_ref_num: " + bankRefNum);
    }
}