package library.specs;

import io.restassured.specification.RequestSpecification;
import library.helpers.CustomApiListener;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static library.helpers.CustomApiListener.withCustomTemplates;

public class RequestSpec {
    public static RequestSpecification createBooksRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/create_books")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification getAllBooksRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/books")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification getBookByIdRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/books/1")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification updateBookRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/books/1")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification deleteBookRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/books/1")
            .log().all()
            .contentType(JSON);

    public static RequestSpecification deleteBookTwiceRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("http://localhost:8080")
            .basePath("/books/1")
            .log().all()
            .contentType(JSON);

}
