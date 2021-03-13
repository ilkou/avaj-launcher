package io.github.ilkou.avaj.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Md5Decrypt {
    public static String decryptAircraftType(String encryptedType) {
        return Md5Encrypt.getEncryptedTypes(encryptedType);
    }
}
