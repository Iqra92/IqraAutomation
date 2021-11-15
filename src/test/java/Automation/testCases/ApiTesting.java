package Automation.testCases;

import groovy.util.logging.Log4j;
import io.restassured.response.Response;
import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;


public class ApiTesting {
    @Test
    void CreatedBoard(){
        Response response = get("https://api.trello.com/1/boards/iD0n4JJO?key=64fc3f6eb0c94583d2d5dd729c0e8fe0&token=8d6cf76288a43b0d09ce35e251dad55407e91462f98209af0238e0fed4c718e1");
        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Header : "+response.getHeader( "content-type"));

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);
    }
    @Test
    void CreatedCard1(){
        Response response = get("https://api.trello.com/1/cards/ldGZA9xi?key=64fc3f6eb0c94583d2d5dd729c0e8fe0&token=8d6cf76288a43b0d09ce35e251dad55407e91462f98209af0238e0fed4c718e1");
        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Header : "+response.getHeader( "content-type"));

        int statusCode = response.getStatusCode();

            Assert.assertEquals(statusCode,200);

        }

    @Test
    void CreatedCard2(){
        Response response = get("https://api.trello.com/1/cards/6TMQMRk8?key=64fc3f6eb0c94583d2d5dd729c0e8fe0&token=8d6cf76288a43b0d09ce35e251dad55407e91462f98209af0238e0fed4c718e1");
        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Header : "+response.getHeader( "content-type"));

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);
    }
    @Test
    void UpdatedCard(){
        Response response = get("https://api.trello.com/1/cards/6TMQMRk8?key=64fc3f6eb0c94583d2d5dd729c0e8fe0&token=8d6cf76288a43b0d09ce35e251dad55407e91462f98209af0238e0fed4c718e1&idList=6190b042a78cc38bbb435a3c&name=This is my first card - updated");
        System.out.println("Response : "+response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time Taken: "+response.getTime());
        System.out.println("Header : "+response.getHeader( "content-type"));

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode,200);


    }
}
