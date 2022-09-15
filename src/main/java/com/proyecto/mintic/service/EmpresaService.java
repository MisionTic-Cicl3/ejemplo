package com.proyecto.mintic.service;

import com.proyecto.mintic.entity.EmpresaEntity;
import com.proyecto.mintic.Repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class EmpresaService {

    private EmpresaRepository repository;

   public EmpresaService(EmpresaRepository repository){
        this.repository=repository;
    }

    public ArrayList<EmpresaEntity> listarEmpresas(){
       return (ArrayList<EmpresaEntity>) repository.findAll();
    }

    public Optional<EmpresaEntity> buscarEmpresa(Long id){
       return repository.findById(id);
    }

    public ArrayList<EmpresaEntity> buscarDocument(String document){
       return repository.findByDocument(document);
    }

    public String agregarEmpresa(EmpresaEntity empresa) {
        if (!buscarEmpresa(empresa.getId()).isPresent()) {
            repository.save(empresa);
            return "La empresa se registró correctamente.";
        } else {
            return "La empresa ya existe. ";
        }
    }
    public String eliminarEmpresa(Long id){
        if(buscarEmpresa(id).isPresent()){
            repository.deleteById(id);
            return "Empresa eliminada";
        } else {
            return "La empresa a eliminar no existe";
        }
    }
}
