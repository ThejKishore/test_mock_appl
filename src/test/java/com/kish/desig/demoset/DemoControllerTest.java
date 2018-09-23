package com.kish.desig.demoset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DemoController.class)
@ExtendWith(SpringExtension.class)
class DemoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReservationJpa reservationJpa;

    @Test
    @DisplayName("get_about_us")
    void aboutUs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/aboutus")))
                .andExpect(status().isOk())
                .andExpect(content().string("About us is up and working"));
    }


    @Test
    @DisplayName("get_reservations_by_lastname_karuneegar")
    void getReservations() throws Exception
    {
        Mockito.when(reservationJpa.findAllByLastName(anyString()))
                .thenReturn(Arrays.asList(new Reservation(null,"Thej","Karuneegar")));

        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/reservations/Karuneegar")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("@.[0].firstName").value("Thej"));
    }
}