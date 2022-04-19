package org.example.tests;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(SerenityRunner.class)
public class PersonBasicTest {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost:8888";
    }

    @Title("Get All the Person Data in JSON Array")
    @Test
    public void getPersonAll() {
        SerenityRest.given().basePath("persons")
                .when().get()
                .then().log().all().statusCode(200);
    }

    @Title("Get Single the Person Data")
    @Test
    public void getSinglePerson() {
        RestAssured.baseURI = "http://localhost:8888";
        SerenityRest.given().basePath("persons/1")
                .when().get()
                .then().log().all().statusCode(200);

    }
    @Pending
    @Test
    public void thisIsAPendingTest(){

    }

    @Ignore
    @Test
    public void thisIsASkippedTest(){

    }


    @Test
    public void thisIsAtestWithError(){
        System.out.println("This is an error"+(5/0));
    }


    @Test
    public void fileDoesNotExist() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }

    @Manual
    @Test
    public void thisIsAManualTest() {

    }
}
