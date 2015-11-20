package org.bounswe2015.group9.universal_access.daos.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TestCase<Input, Output> {
    public Input[] inputs;
    public Output[] outputs;
}
