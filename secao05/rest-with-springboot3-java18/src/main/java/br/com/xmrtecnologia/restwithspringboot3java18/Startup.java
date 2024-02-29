package br.com.xmrtecnologia.restwithspringboot3java18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
        
        /**   
        // Para criar uma Senha com Hash e utilizar para Novo Usuário
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        
        Pbkdf2PasswordEncoder pbkdf2Encoder =
                new Pbkdf2PasswordEncoder(
                    "", 8, 185000,
                    SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        
        encoders.put("pbkdf2", pbkdf2Encoder);
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        
        String result1 = passwordEncoder.encode("admin123");
        String result2 = passwordEncoder.encode("admin234");
        String result3 = passwordEncoder.encode("12345678");
        System.out.println("Encode: admin123 -> My hash result1 " + result1);
        System.out.println("Encode: admin234 -> My hash result2 " + result2);
        System.out.println("Encode: 12345678 -> My hash result3 " + result3);
        
        // Resposta
        Encode: admin123 -> My hash result1 {pbkdf2}264b2a581f609ac1396b823bdd8b7d8bf1c836a3f8b6860efe4607c6b280eeba0dd9ec925913d17c
        Encode: admin234 -> My hash result2 {pbkdf2}0246caffa857b5196b99f1454e0d671681f4f1dd390c2eca58a5cd8b354604ad981d8d4a719ed970
        Encode: 12345678 -> My hash result3 {pbkdf2}623563cbeeb20ae96eefb602db842df68402e5c33256d9ac1e1b27adf5c0d77f2090c4323dc7aaf6
        */

    }

}
