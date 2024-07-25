package com.chi.demo03.web01.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // Uri versioning
    @GetMapping("v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Suga");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Jung Kook", "Jeon"));
    }

    // Request parameter versioning
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1RequestParameter() {
        return new PersonV1("Suga");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2RequestParameter() {
        return new PersonV2(new Name("Jung Kook", "Jeon"));
    }

    // (Custom) headers versioning
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1RequestHeader() {
        return new PersonV1("Suga");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2RequestHeader() {
        return new PersonV2(new Name("Jung Kook", "Jeon"));
    }

    // Media type versioning
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1AcceptHeader() {
        return new PersonV1("Suga");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2AcceptHeader() {
        return new PersonV2(new Name("Jung Kook", "Jeon"));
    }
}
