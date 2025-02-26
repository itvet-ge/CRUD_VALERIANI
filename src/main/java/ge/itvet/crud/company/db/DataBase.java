package ge.itvet.crud.company.db;

import java.sql.PreparedStatement;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.sql.*;

@Log4j2
@Configuration
public class DataBase {

       @PostConstruct
    public void init() {
        String url = "jdbc:postgresql://localhost:5432/postgres_java";
        String user = "postgres";
        String password = "cerdunia";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String nameParam = "snack";
            PreparedStatement stmt = conn.prepareStatement(
                    "select * from CRUD.categories where category_name = ?"
            );
            stmt.setString(1,nameParam);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("category_id");
                String name = resultSet.getString("category_name");
                String description = resultSet.getString("description");
                log.info("id:{}, name:{}, description:{}", id, name, description);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}