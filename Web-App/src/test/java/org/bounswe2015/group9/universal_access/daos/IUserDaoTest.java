package org.bounswe2015.group9.universal_access.daos;


import org.bounswe2015.group9.universal_access.daos.utils.TestCase;
import org.bounswe2015.group9.universal_access.daos.utils.TestCaseHelper;
import org.bounswe2015.group9.universal_access.entities.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IUserDaoTest extends BaseDaoTest {

    @Autowired
    IUserDao userDao;

    private static final String TEST_CASES_PATH = "/daos/userDao/test_cases.json";

    private Map<String, TestCase<User, User>> testCases = TestCaseHelper.getTestCases(TEST_CASES_PATH, User.class, User.class);

    @Override
    List<String> getSetUpQueries() throws IOException {
        return Arrays.asList(
                "/migrations/V1.0.2__create_user.sql",
                "/daos/userDao/setup.sql"
        );
    }

    @Test
    public void testGetByEmail() {
        User[] outputs = testCases.get("getByEmail").outputs;

        for (User output: outputs) {
            User actual = userDao.getUserByEmail(output.getEmail());
            assertEquals(output, actual);
        }
    }
}
