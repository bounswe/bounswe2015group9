package org.bounswe2015.group9.universal_access.daos.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.util.Map;
import java.util.TimeZone;

public class TestCaseHelper {
    public static <Input, Output> Map<String, TestCase<Input, Output>> getTestCases(String path, Class<Input> inputClass,
                                                                                    Class<Output> outputClass) {
        ObjectMapper om = new ObjectMapper();

        om.setConfig(om.getDeserializationConfig().with(TimeZone.getDefault()));
        om.registerModule(new JodaModule());

        Map<String, TestCase<Input, Output>> testCases = null;
        try {
            TypeFactory typeFactory = om.getTypeFactory();
            JavaType keyType = typeFactory.constructType(String.class);
            JavaType valueType = typeFactory.constructParametricType(TestCase.class, inputClass, outputClass);
            JavaType mapType = typeFactory.constructMapType(Map.class, keyType, valueType);

            testCases = om.readValue(FileReader.readFromFile(path), mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases;
    }
}
