package RSA;

/*
 * @author Wicho
 */
 /*

Aqui es donde va a estar todo el algoritmo del RSA

 */
import exameninterfaz.ClienteInterfaz;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class rsa {

    private BigInteger P;
    private BigInteger Q;
    public BigInteger N;
    private BigInteger PHI;
    private BigInteger e;
    public  BigInteger d;     

    public rsa(int tamPrimo) {
                
        P = new BigInteger(tamPrimo, 10, new Random());        
        do{
            Q = new BigInteger(tamPrimo, 10, new Random());
        }while(Q.compareTo(P)==0);
        
        N = P.multiply(Q);
        PHI = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
        
        do{
            e = new BigInteger(2*tamPrimo, new Random());
        }while ((e.compareTo(PHI)!=-1) || (e.gcd(PHI).compareTo(BigInteger.valueOf(1))!=0));

        d = e.modInverse(PHI);
        
    }

    /*public rsa(BigInteger e, BigInteger d, BigInteger N) {
        this.e = e;
        this.d = d;
        this.N = N;
    }*/
      
    
    
    private static String bToS(byte[] cipher) {
        String temp = "";
        for (byte b : cipher) {
            temp += Byte.toString(b);
        }
        return temp;
    }

    // Encrypting the message
    public BigInteger encryptMessage(BigInteger message) {
        return message.modPow(e, N)/*.toByteArray()*/;
    }

    // Decrypting the message
    public BigInteger decryptMessage(BigInteger message) {
        return message.modPow(d, N)/*.toByteArray()*/;
    }
}
