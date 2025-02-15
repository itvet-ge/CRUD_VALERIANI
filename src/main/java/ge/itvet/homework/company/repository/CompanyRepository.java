package ge.itvet.homework.company.repository;


import ge.itvet.homework.company.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository {

    public List<Company> findAll(int page, int size) {
        return null;
    }

    public Optional<Company> findById(Long id) {
        return Optional.empty();
    }

    public Company save(Company company) {
        return null;
    }

    public void deleteById(Long id) {

    }

}
