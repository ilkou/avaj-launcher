package io.github.ilkou.avaj.md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class Md5Encrypt {
    private static final HashMap<String, String> types;
    private static final String[] aircraftTypes = { "Baloon", "JetPlane", "Helicopter" };

    static {
        types = new HashMap<String, String>();
        try {
            types.put(encryptData(aircraftTypes[0]), aircraftTypes[0]);
            types.put(encryptData(aircraftTypes[0]), aircraftTypes[0]);
            types.put(encryptData(aircraftTypes[0]), aircraftTypes[0]);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Here ");
            e.printStackTrace();
        }
    }

    public static String getEncryptedTypes(String type) {
        return types.get(type);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static String encryptData(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encryptedDataAsBytes = md.digest(data.getBytes());
        return bytesToHex(encryptedDataAsBytes);
    }

}
