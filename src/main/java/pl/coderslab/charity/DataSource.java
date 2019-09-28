package pl.coderslab.charity;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import static org.apache.tomcat.jni.SSL.setPassword;

@Component
public class DataSource extends BasicDataSource {
    public DataSource() {
        setDriverClassName("com.mysql.cj.jdbc.Driver");
        setUrl("jdbc:mysql://localhost:3306/charity_donation?serverTimezone=UTC");
        setUsername("root");
        setPassword("coderslab");
    }
}
