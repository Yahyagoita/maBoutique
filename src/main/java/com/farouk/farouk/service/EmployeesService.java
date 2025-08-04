package com.farouk.farouk.service;


import com.farouk.farouk.model.Employees;
import com.farouk.farouk.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository empRepo;
   public List<Employees> getAllEmployees(){
       return empRepo.findAll();
   }

   public Employees save(Employees emp){
       return empRepo.save(emp);
   }
   public void deleteById(long id){
        empRepo.deleteById(id);
   }
    // Mettre à jour un employé existant
    public Employees updateEmployee(Long id, Employees updatedEmployee) {
        Optional<Employees> optionalEmployee = empRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employees existingEmployee = optionalEmployee.get();
            // Mise à jour des champs (exemple)
            existingEmployee.setSurname(updatedEmployee.getSurname());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            // Sauvegarder les modifications
            return empRepo.save(existingEmployee);
        } else {
            // Ici tu peux gérer le cas où l'employé n'existe pas, par ex. lancer une exception
            throw new RuntimeException("Employé non trouvé avec l'id : " + id);
        }
    }



}
