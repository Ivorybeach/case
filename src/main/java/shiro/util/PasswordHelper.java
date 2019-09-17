package shiro.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import shiro.pojo.User;

public class PasswordHelper {
    private String algorithmName = "md5";
    private final int hashIterations = 1;

    public String encryptPassword(String password) {
    	//没有使用salt
        SimpleHash newPass = new SimpleHash(algorithmName, password,null, hashIterations);
        return newPass.toString();
    }
}
