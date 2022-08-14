package za.ac.cput.service;
/*
Online Shopping System
Lihle Langa 217181147
 */
import za.ac.cput.domain.Login;

public interface LoginService extends IService<Login, String>{
    boolean delete(String s);
}
