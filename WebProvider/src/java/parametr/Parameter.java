package parametr;

public enum Parameter {

    USER_LOGIN("login"),
    FULL_NAME("fullName"),
    USER_PASSWORD("password"),
    ID_CLIENT("idClient"),
    ID_TARIF("idTarif"),
    SERIA_PASSPORT("seriaPassport"),
    NUM_PASSPORT("numPassport"),
    ADRESS("adress"),
    EMAIL("email"),
    DATE("dateContract"),
    TARIF("tarif"),
    SERVICE("descripService"),
    NUMPERSACCOUNT("numPersonalAccount"),
    SUMPAY("sumPay"),
    STATUS("statusContract"),
    NUM_CONTRACT("numContract"),
    SUMPERSACCOUNT("sumPersAccount"),
    NAME_TARIF("nameTarif"),
    TRAFIC("trafic"),
    PRICE("price"),
    SPEED("speed"),
    DESCRIP_SERVICE("nameService"),
    PRICESERVICE("priceService"),
    NOTE("note"),
    DATEPAY("datePays");


    private String parameter;

    private Parameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return this.parameter;
    }

}
