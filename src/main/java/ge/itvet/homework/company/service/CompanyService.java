package ge.itvet.homework.company.service;

import ge.itvet.homework.company.model.Company;
import ge.itvet.homework.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll(int page, int size) {
        return repository.findAll(page, size);
    }

    public Optional<Company> findById(Long id) {
        return repository.findById(id);
    }

    public Company save(Company company) {
        validateCapitalBySphere(company);
        return repository.save(company);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void validateCapitalBySphere(Company company) {
        String sphere = company.getSphere();
        double capital = company.getCapital();

        if ("ტექნოლოგიები".equalsIgnoreCase(sphere) && capital < 50000) {
            throw new IllegalArgumentException("ტექნოლოგიების სფეროში მინიმალური კაპიტალი უნდა იყოს 50000");
        } else if ("მშენებლობა".equalsIgnoreCase(sphere) && capital < 100000) {
            throw new IllegalArgumentException("მშენებლობის სფეროში მინიმალური კაპიტალი უნდა იყოს 100000");
        }
    }
}