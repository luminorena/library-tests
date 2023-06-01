package library;

import com.github.javafaker.Faker;
import library.models.LibraryModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static library.specs.RequestSpec.*;
import static library.specs.ResponseSpec.*;
import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class LibraryApplicationTests {
    Faker faker = new Faker();
    String title = faker.book().title();
    String author = faker.book().author();
    String genre = faker.book().genre();
    int year = faker.number().numberBetween(1990, 2023);
    int pages = faker.number().randomDigitNotZero();


    @DisplayName("Проверка создания книги")
    @Test
    void createBook(){
        LibraryModel body = new LibraryModel();
        body.setTitle(title);
        body.setAuthor(author);
        body.setGenre(genre);
        body.setYear(year);
        body.setPages(pages);
             given()
            .spec(createBooksRequestSpec)
            .body(body)
            .when()
            .post()
            .then()
            .spec(createBooksResponseSpec)
            .assertThat().body(containsString(""));
    }
    @DisplayName("Получить список всех книг")
    @Test
    void getAllBooks() {
        given()
                .spec(getAllBooksRequestSpec)
                .when()
                .get()
                .then()
                .spec(getAllBooksResponseSpec)
                .assertThat().body(containsString("title"))
                .assertThat().body(containsString("author"))
                .assertThat().body(containsString("genre"))
                .assertThat().body(containsString("year"))
                .assertThat().body(containsString("pages"));
    }

    @DisplayName("Получить книгу по её идентификатору")
    @Test
    void getBookById(){
        LibraryModel response =
        given()
                .spec(getBookByIdRequestSpec)
                .when()
                .get()
                .then()
                .spec(getBookByIdResponseSpec)
                .extract().as(LibraryModel.class);
        assertThat(response.getId()).isEqualTo(1);

    }
// does not work
@DisplayName("Проверка редактирования книги")
    @Test
    void updateBookEntity(){
        LibraryModel body = new LibraryModel();
        String newAuthor = faker.book().author();
        String newTitle = faker.book().title();
        String newGenre = faker.book().genre();
        int newYear = 2023;
        int newPages = 200;
        LibraryModel response =
                given()
                        .spec(updateBookRequestSpec)
                        .body(body.setAuthor(newAuthor))
                        .body(body.setTitle(newTitle))
                        .body(body.setGenre(newGenre))
                        .body(body.setYear(newYear))
                        .body(body.setPages(newPages))
                        .when()
                        .put()
                        .then()
                        .spec(updateBookResponseSpec)
                        .extract().as(LibraryModel.class);

        assertThat(response.getAuthor()).isEqualTo(newAuthor);


    }
    @DisplayName("Проверка удаления книги")
    @Test
    void deleteBook(){
                given()
                        .spec(deleteBookRequestSpec)
                        .when()
                        .delete()
                        .then()
                        .spec(deleteBookResponseSpec)
                        .assertThat().body(containsString(""));

    }

    @DisplayName("Проверка удаления одной и той же книги более одного раза; статус 304")
    @Test
    void deleteSameBookTwice(){
        given()
                .spec(deleteBookTwiceRequestSpec)
                .when()
                .delete()
                .then()
                .spec(deleteBookTwiceResponseSpec)
                .assertThat().body(containsString(""));

    }


}
