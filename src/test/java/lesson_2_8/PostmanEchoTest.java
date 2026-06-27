package lesson_2_8;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class PostmanEchoTest {

    private static final String BASE_URL = "https://postman-echo.com";
    private static final String TEXT_BODY = "This is expected to be sent back as part of response body.";

    static {
        RestAssured.config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
    }

    @Test
    public void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
        .when()
                .get(BASE_URL + "/get")
        .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo(BASE_URL + "/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void postRawTextTest() {
        String body = "{\n \"test\": \"value\"\n}";

        given()
                .header("Content-Type", "text/plain")
                .body(body)
        .when()
                .post(BASE_URL + "/post")
        .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(body))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("headers.content-type", equalTo("text/plain"))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("foo1=bar1&foo2=bar2")
        .when()
                .post(BASE_URL + "/post")
        .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(""))
                .body("files.size()", equalTo(0))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void putRequestTest() {
        given()
                .header("Content-Type", "text/plain")
                .body(TEXT_BODY)
        .when()
                .put(BASE_URL + "/put")
        .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(TEXT_BODY))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("headers.content-type", equalTo("text/plain"))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URL + "/put"));
    }

    @Test
    public void patchRequestTest() {
        given()
                .header("Content-Type", "text/plain")
                .body(TEXT_BODY)
        .when()
                .patch(BASE_URL + "/patch")
        .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(TEXT_BODY))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("headers.content-type", equalTo("text/plain"))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URL + "/patch"));
    }

    @Test
    public void deleteRequestTest() {
        given()
                .header("Content-Type", "text/plain")
                .body(TEXT_BODY)
        .when()
                .delete(BASE_URL + "/delete")
        .then()
                .statusCode(200)
                .body("args.size()", equalTo(0))
                .body("data", equalTo(TEXT_BODY))
                .body("files.size()", equalTo(0))
                .body("form.size()", equalTo(0))
                .body("headers.content-type", equalTo("text/plain"))
                .body("json", nullValue())
                .body("url", equalTo(BASE_URL + "/delete"));
    }
}
