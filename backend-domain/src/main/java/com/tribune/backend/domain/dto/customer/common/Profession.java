package com.tribune.backend.domain.dto.customer.common;

public enum Profession {

    EMPLOYEE("profession_employee", 1),
    WORKER("profession_worker", 2),
    TRAINEE("profession_trainee", 3),
    OFFICIAL("profession_official", 4),
    FREELANCER("profession_freelancer", 5),
    MANAGING_PARTNER("profession_managing_partner", 6),
    HOUSEWIFE("profession_housewife", 7),
    HOUSEMAN("profession_houseman", 8),
    EXECUTIVE("profession_executive", 9),
    UNEMPLOYED("profession_unemployed", 10),
    PENSIONER("profession_pensioner", 11),
    RETIREE("profession_retiree", 12),
    PUPIL("profession_pupil", 13),
    SELF_EMPLOYED("profession_self_employed", 14),
    STUDENT("profession_student", 15),
    OTHER("profession_other", 16),
    MANAGER("profession_manager", 17),
    LIBERAL_PROFESSION("profession_liberal_profession", 18),
    HOUSEPARENT("profession_houseparent", 19),
    LIVING_OFF_INVESTMENTS("profession_living_off_investments", 20),
    COMPANY_DIRECTOR("profession_company_director", 21);;

    /**
     * String code representation of the academic title used by the legacy API for registration purposes.
     */
    private final String name;

    private final Integer code;

    Profession(final String name, final Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
