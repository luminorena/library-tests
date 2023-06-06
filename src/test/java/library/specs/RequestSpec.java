package library.specs;

import io.restassured.specification.RequestSpecification;
import library.helpers.CustomApiListener;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static library.helpers.CustomApiListener.withCustomTemplates;

public class RequestSpec {
    public static RequestSpecification baseSpec = with()
            // В нее перенести filter, contentType и baseUrl.
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .contentType(JSON);

    public static RequestSpecification createBooksRequestSpec = with()
            .basePath("/create_books")
            .log().all();


    public static RequestSpecification getAllBooksRequestSpec = with()
            .basePath("/books")
            .log().all();

    public static RequestSpecification getBookByIdRequestSpec = with()
            .basePath("/books/1")
            .log().all();


    public static RequestSpecification updateBookRequestSpec = with()
            .basePath("/books/2")
            .log().all();

    public static RequestSpecification deleteBookRequestSpec = with()
            .basePath("/books/1")
            .log().all();

    public static RequestSpecification deleteBookTwiceRequestSpec = with()
            .basePath("/books/1")
            .log().all();


}
