package com.silverhyuk.cloudconfigclienttest.common.type;

public enum UseType implements EnumModel{

    USE("사용"),
    NOT_USED("미사용");

    private final String value;

    UseType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
