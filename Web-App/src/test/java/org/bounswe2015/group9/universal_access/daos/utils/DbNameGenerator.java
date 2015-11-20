package org.bounswe2015.group9.universal_access.daos.utils;

import java.util.Random;

public class DbNameGenerator {
    String generateDbName() {
        return "dao_test" + new Random().nextInt(999999);
    }
}