package com.lambdaschool.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // managed by Spring Boot - mappings of end points - annotatrion
@RequestMapping("/data") //  all endpoints start with /data
public class EmployeeController
{
    // localhost:2019/data/allemployees
    @GetMapping(value = "/allemployees")
    public ResponseEntity<?> getAllEmployees()
    {
        return new ResponseEntity<>(WebemployeesApplication.ourEmpList.empList, HttpStatus.OK);

    }

    // localhost:2019/data/employee/:id
    @GetMapping(value = "/employee/{id}")
        public ResponseEntity<?> getEmplDetail(@PathVariable long id)
        {
            Employee rtnEmp = WebemployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == id));
            return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
        }


}
