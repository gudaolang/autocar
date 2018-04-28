package shiro;

import com.sun.jersey.core.util.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author lee
 * @Date:26/03/2018
 */

public class Base64Test {


    public static void main(String[] args) {

//        System.out.println(CodecSupport.toBytes("abc"));

        byte[] aa = Base64.encode(CodecSupport.toBytes("abc"));

//        System.out.println(Base64.encode(CodecSupport.toBytes("abc")));

//        System.out.println(CodecSupport.toString(Base64.decode(aa)));

        System.out.println(new Md5Hash("admin", "1521530199981", 2));

//        System.out.println(new Md5Hash("abc", "123", 2));

        SimpleHash hash = new SimpleHash("md5", "admin", "1521530199981", 2);

        System.out.println(hash.toString());

//        System.out.println(Md5Util.getMd5("abc"));
//        System.out.println(Md5Hash.fromBase64String(new Md5Hash("abc", "123").toBase64()));

//        System.out.println(Md5Util.getMd5("abc123"));
    }
}
