package com.curso.demo.model.clases;

import java.util.Collection;
import java.util.HashMap;

public class ConcesionarioWeb {
    private HashMap<Integer, ClienteWeb>listaClientes;

    public ConcesionarioWeb() {
    }
    public ClienteWeb clienteId(int id){
        return listaClientes.get(id);
    }
    public ClienteWeb getCliente(String name){
        return listaClientes.get(name);
    }

    public Collection<ClienteWeb> getClientes(){
        return listaClientes.values();
    }

}
