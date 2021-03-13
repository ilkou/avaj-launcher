package io.github.ilkou.avaj.md5;

public class Md5Decrypt {
    public static String decryptAircraftType(String encryptedType) {
        return Md5Encrypt.getEncryptedTypes(encryptedType);
    }
}
