package com.kish.desig.demoset;

import io.restassured.RestAssured;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemosetApplicationTests {


    @LocalServerPort
    int serverPort ;

    @BeforeEach
    public void restAssuredSetup(){
        RestAssured.port = serverPort;
    }


    @RepeatedTest(value = 5 )
    @DisplayName("Initial loading test....")
    public void testAboutUs() {
        val response = get("/aboutus")
                .then()
                .log()
                .body();
        val responseTxt = response.extract().body().asString();
//        assertEquals(responseTxt , "About us is up and working");
        assertThat(responseTxt).isEqualTo("About us is up and working");
    }

    @Test
    @DisplayName("get_user_by_lastname")
    public void getUserByLastname() {
        val response = get("/reservations/karuneegar")
                .then()
                .log()
                .body();
        val reservations = response.extract().body().as(List.class);
        assertThat(reservations).isEqualTo(Collections.EMPTY_LIST);


    }

}
