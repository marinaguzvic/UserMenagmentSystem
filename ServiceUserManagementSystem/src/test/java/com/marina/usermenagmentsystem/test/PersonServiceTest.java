/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.test;

import com.marina.usermenagmentsystem.service.PersonService;
import com.marina.usermenagmentsystem.service.PositionService;
import com.marina.usermenagmentsystem.service.model.PersonDTO;
import com.marina.usermenagmentsystem.service.model.PositionDTO;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MARINA
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class, H2JpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { SpringTestConfig.class })
@Transactional
//@Import(SpringTestConfig.class)
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:output.sql")
//@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Autowired
    PositionService positionService;

//    @Before
//    public void initializeDatabase() {
//        Session session = em.unwrap(Session.class);
//        session.doWork(new Work() {
//            @Override
//            public void execute(Connection connection) throws SQLException {
//                try {
//                    File script = new File(getClass().getResource("/data.sql").getFile());
//                    RunScript.execute(connection, new FileReader(script));
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException("could not initialize with script");
//                }
//            }
//        });
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        em.clear();
//        em.close();
//        emf.close();
//    }

    @Test
    public void testListOfPersons() {
        List<PersonDTO> persons = personService.getAll();
        Assert.assertEquals(5, persons.size());
    }

    @Test
    public void testGetPerson() {
        PersonDTO person = personService.get(4L);
        Assert.assertFalse(person == null);
        Assert.assertEquals("Marina", person.getFirstName());
        Assert.assertEquals("Guzvic", person.getLastName());
        Assert.assertEquals("marina.guzvic@gmail.com", person.getEmail());
    }

    @Test
    public void testSavePerson() {
        PersonDTO person = new PersonDTO(null, "test@test.com", "Test", "Test", "+381641121333", "Female", new Date(), positionService.get(1L), null);
        personService.insert(person);
        List<PersonDTO> persons = personService.getAll();
        Assert.assertEquals(6, persons.size());
    }

    @Test
    public void updatePerson() {
        PersonDTO person = personService.get(4L);
        Assert.assertFalse(person == null);
        person.setFirstName("Marinica");
        person.setLastName("Guzviceva");
        person.setPosition(positionService.get(2L));
        person = personService.update(person);
        Assert.assertEquals("Marinica", person.getFirstName());
        Assert.assertEquals("Guzviceva", person.getLastName());
        Assert.assertEquals(positionService.get(2L), person.getPosition());
    }

    @Test
    public void testDeletePerson() {
        personService.delete(5L);
        List<PersonDTO> persons = personService.getAll();
        Assert.assertEquals(4, persons.size());
    }
}
