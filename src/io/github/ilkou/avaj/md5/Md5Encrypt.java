package io.github.ilkou.avaj.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Md5Encrypt {
    private static final HashMap<String, String> types;
    private static final String[] aircraftTypes = { "Baloon", "JetPlane", "Helicopter" };

    static {
        types = new HashMap<String, String>();
        try {
            types.put(encryptData(aircraftTypes[0]), aircraftTypes[0]);
            types.put(encryptData(aircraftTypes[1]), aircraftTypes[1]);
            types.put(encryptData(aircraftTypes[2]), aircraftTypes[2]);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getEncryptedTypes(String type) {
        if (types.containsKey(type)) {
            return types.get(type);
        }
        return "";
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
