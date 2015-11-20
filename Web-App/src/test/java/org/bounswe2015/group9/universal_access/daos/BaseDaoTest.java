package org.bounswe2015.group9.universal_access.daos;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-config.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseDaoTest {

    abstract List<String> getSetUpQueries() throws IOException;

    @Autowired
    DriverManagerDataSource ds;

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws IOException {
        JdbcTemplate template = new JdbcTemplate(ds);
        for (String path : getSetUpQueries()) {
            Resource resource = applicationContext.getResource(path);
            JdbcTestUtils.executeSqlScript(template, resource, false);
        }
    }

    @After
    public void tearDown() throws IOException {
        String dbName = ds.getConnectionProperties().getProperty("DBNAME");
        JdbcTemplate template = new JdbcTemplate(ds);
        template.execute("DROP DATABASE " + dbName);
    }
}
