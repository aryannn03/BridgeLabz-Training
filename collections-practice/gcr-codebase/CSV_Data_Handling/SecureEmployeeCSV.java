import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecureEmployeeCSV {

    private static final String KEY = "1234567890123456";

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void writeEncryptedCSV(String filePath) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write("ID,Name,Email,Salary\n");

        bw.write("101,John," + encrypt("john@gmail.com") + "," + encrypt("60000") + "\n");
        bw.write("102,Alice," + encrypt("alice@gmail.com") + "," + encrypt("55000") + "\n");
        bw.write("103,Bob," + encrypt("bob@gmail.com") + "," + encrypt("50000") + "\n");

        bw.close();
        System.out.println("Encrypted CSV written successfully");
    }

    public static void readDecryptedCSV(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println(
                data[0] + " " +
                data[1] + " " +
                decrypt(data[2]) + " " +
                decrypt(data[3])
            );
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        String path = "collections-practice/gcr-codebase/CSV_Data_Handling/secure_employees.csv";
        writeEncryptedCSV(path);
        readDecryptedCSV(path);
    }
}
