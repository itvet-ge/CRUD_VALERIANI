package ge.itvet.homework.company.controller;

import ge.itvet.homework.company.model.Company;
import ge.itvet.homework.company.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@Api(tags = "კომპანიის მენეჯმენტი")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "კომპანიის წამოღება ID-ით")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = service.findById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    @ApiOperation(value = "ყველა კომპანიის წამოღება (პეიჯინგით)")
    public ResponseEntity<List<Company>> getAllCompanies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Company> companies = service.findAll(page, size);
        return ResponseEntity.ok(companies);
    }

    @PostMapping
    @ApiOperation(value = "ახალი კომპანიის შექმნა")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = service.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "კომპანიის რედაქტირება")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        Company updatedCompany = service.save(company);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "კომპანიის წაშლა")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}