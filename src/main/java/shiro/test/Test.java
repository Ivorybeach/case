package shiro.test;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Test {
	public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "666";
        int hashIterations = 1;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
        String str = obj.toString();
        System.out.println(str);
    }
}
