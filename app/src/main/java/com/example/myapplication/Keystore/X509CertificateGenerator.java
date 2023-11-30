package com.example.myapplication.Keystore;

import org.bouncycastle.x509.X509V3CertificateGenerator;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

public class X509CertificateGenerator {

    public static X509Certificate generateCertificate() throws NoSuchAlgorithmException, IOException, CertificateException {
        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get public and private keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Generate X.509 certificate
        X509Certificate certificate = generateX509Certificate(publicKey, privateKey);

        return certificate;
    }

    private static X509Certificate generateX509Certificate(PublicKey publicKey, PrivateKey privateKey) throws CertificateEncodingException, CertificateException, NoSuchAlgorithmException {
        // Set certificate information
        X509Certificate certificate = null;
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            Date startDate = new Date(); // Valid from now
            Date endDate = new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000); // Valid for 1 year

            BigInteger serialNumber = new BigInteger(160, new java.security.SecureRandom());

            X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
            X500Principal issuerName = new X500Principal("CN=Issuer");
            X500Principal subjectName = new X500Principal("CN=Subject");

            certGen.setSerialNumber(serialNumber);
            certGen.setIssuerDN(issuerName);
            certGen.setNotBefore(startDate);
            certGen.setNotAfter(endDate);
            certGen.setSubjectDN(subjectName);
            certGen.setPublicKey(publicKey);
            certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

            certificate = certGen.generate(privateKey);
        } catch (SignatureException | InvalidKeyException e) {
            throw new RuntimeException(e);
        } finally {
            Security.removeProvider(org.bouncycastle.jce.provider.BouncyCastleProvider.PROVIDER_NAME);
        }

        return certificate;
    }

}
