package org.forkjoin.jteach.core.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Base64;
import java.util.UUID;

/**
 * 22 字符长度的uuid
 * @author zuoge85@gmail.com on 2017/6/6.
 */
public class UUIDUtils {
    public static String randomUUIDToBase64() {
        UUID uuid = UUID.randomUUID();
        byte[] uuidArr = asByteArray(uuid);
        return Base64.getEncoder().withoutPadding().encodeToString(uuidArr);
    }

    public static void main(String[] args) {
        System.out.println(randomUUIDToBase64());
        System.out.println(randomUUIDToBase64().length());
    }

    public static byte[] asByteArray(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];

        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte) (lsb >>> 8 * (7 - i));
        }

        return buffer;
    }

    public static UUID toUUID(byte[] byteArray) {

        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (byteArray[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (byteArray[i] & 0xff);
        }
        return new UUID(msb, lsb);
    }
}
