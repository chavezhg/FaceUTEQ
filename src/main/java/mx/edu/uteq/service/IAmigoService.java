/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uteq.service;

import java.util.List;
import mx.edu.uteq.domain.Amigo;
import mx.edu.uteq.domain.Usuario;

/**
 *
 * @author Ricardo
 */
public interface IAmigoService {
    public List<Amigo> getAll();
    public List<Amigo> getAllNotFriends(int idUsua);
    public void insert(Amigo amigo);
    public void delete(Amigo amigo);
    public Amigo findById(Amigo amigo);
}
