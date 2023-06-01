package library.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class ResponseSpec {
    public static ResponseSpecification createBooksResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(201)
                    .build();

    public static ResponseSpecification getAllBooksResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification getBookByIdResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification updateBookResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification deleteBookResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification deleteBookTwiceResponseSpec =
            new ResponseSpecBuilder()
                    .log(STATUS)
                    .log(BODY)
                    .expectStatusCode(304)
                    .build();

}
