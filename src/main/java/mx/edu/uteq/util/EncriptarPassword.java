/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Ricardo
 */
public class EncriptarPassword {
    public static void main(String[] args) {
        String password = "hello123";
        System.out.println("pwd:" + password);
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        System.out.println("pwd encriptado:" + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}

