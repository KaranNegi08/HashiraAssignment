import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static long convertToDecimal(String value, int base) {
        long result = 0;
        for (char c : value.toCharArray()) {
            int digit = Character.isDigit(c) ? c - '0' : Character.toLowerCase(c) - 'a' + 10;
            result = result * base + digit;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("input.json")));
        JSONObject data = new JSONObject(content);

        JSONObject keys = data.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");

        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Roots in decimal:");

        Map<Integer, Long> roots = new TreeMap<>();

        for (String key : data.keySet()) {
            if (key.equals("keys")) continue;
            JSONObject root = data.getJSONObject(key);
            int base = Integer.parseInt(root.getString("base"));
            String value = root.getString("value");
            roots.put(Integer.parseInt(key), convertToDecimal(value, base));
        }

        for (Map.Entry<Integer, Long> entry : roots.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
