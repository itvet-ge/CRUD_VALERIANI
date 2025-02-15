package ge.itvet.homework.company.repository;


import ge.itvet.homework.company.model.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    List<Company> findAll(int page, int size);
    Optional<Company> findById(Long id);
    Company save(Company company);
    void deleteById(Long id);
}


