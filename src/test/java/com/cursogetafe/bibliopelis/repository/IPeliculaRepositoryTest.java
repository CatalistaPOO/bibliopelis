package com.cursogetafe.bibliopelis.repository;



import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.services.PeliculaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IPeliculaRepositoryTest {

    @Autowired
    private PeliculaService imr;

    @Test
    void createPelicula() {
        System.out.println(("Ejecutando el test de crear pelicula"));

        Pelicula peli = new Pelicula("Alien",
                "https://m.media-amazon.com/images/I/81XhWRvtxdL._UF894,1000_QL80_.jpg",
                "https://youtu.be/F5PUUOWKAh4?si=Z-mH2nykdcAdaSfM");
        this.imr.createpeli(peli);
    }

}