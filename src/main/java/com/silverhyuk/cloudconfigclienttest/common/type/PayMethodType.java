package com.silverhyuk.cloudconfigclienttest.common.type;

public enum PayMethodType implements EnumModel{

    CARD("카드"),
    TCASH("실시간계좌이체"),
    ICASH("가상계좌"),
    CELL("휴대폰"),
    FPAYMENT("해외결제"),
    POINT("포인트"),
    DECOMO("docomo 휴대폰 지불"),
    auone("au 간편결제");

    private final String value;

    PayMethodType(String value) {
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
