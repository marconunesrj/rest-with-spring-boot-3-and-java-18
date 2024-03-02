//package br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.controller.withxml;
//
//import static io.restassured.RestAssured.given;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//import br.com.xmrtecnologia.restwithspringboot3java18.app.configs.TestConfigs;
//import br.com.xmrtecnologia.restwithspringboot3java18.app.data.vo.v1.security.TokenVO;
//import br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.testcontainers.AbstractIntegrationTest;
//import br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.vo.AccountCredentialsVO;
//import br.com.xmrtecnologia.restwithspringboot3java18.app.integrationtests.vo.PersonVOXML;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.specification.RequestSpecification;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@TestMethodOrder(OrderAnnotation.class)
//public class PersonControllerXmlTestOriginal extends AbstractIntegrationTest {
//    
//    private static RequestSpecification specification;
//    private static XmlMapper objectMapper;
//
//    private static PersonVOXML person;
//    
//    @BeforeAll
//    public static void setup() {
//        objectMapper = new XmlMapper();
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        
//        person = new PersonVOXML();
//    }
//    
//    @Test
//    @Order(1)
//    public void authorization() throws JsonMappingException, JsonProcessingException {
//        
//        AccountCredentialsVO user = new AccountCredentialsVO("leandro", "admin123");
//        
//        var accessToken = given()
//                .basePath("/auth/signin")
//                    .port(TestConfigs.SERVER_PORT)
//                    .contentType(TestConfigs.CONTENT_TYPE_XML)
//                    .accept(TestConfigs.CONTENT_TYPE_XML)
//                .body(user)
//                .when()
//                    .post()
//                .then()
//                    .log().all()
//                    .statusCode(200)
//                        .extract()
//                        .body()
//                            .as(TokenVO.class)
//                        .getAccessToken();
//        
//        specification = new RequestSpecBuilder()
//                .addHeader(TestConfigs.HEADER_PARAM_AUTHORIZATION, "Bearer " + accessToken)
//                .setBasePath("/api/person/v1")
//                .setPort(TestConfigs.SERVER_PORT)
//                    .addFilter(new RequestLoggingFilter(LogDetail.ALL))
//                    .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
//                .build();
//    }
//    
//    @Test
//    @Order(2)
//    public void testCreate() throws JsonMappingException, JsonProcessingException {
//        mockPerson();
//        
//        System.out.println("Entrei no testCreate");
//        System.out.println(person);
//        
//        var content = given().spec(specification)
//                .contentType(TestConfigs.CONTENT_TYPE_XML)
//                .accept(TestConfigs.CONTENT_TYPE_XML)
//                    .body(person)
//                .when()
//                    .post()
//                .then()
//                    .log().all()
//                    .statusCode(200)
//                        .extract()
//                        .body()
//                            .asString();
//        
//        PersonVOXML persistedPerson = objectMapper.readValue(content, PersonVOXML.class);
//        person = persistedPerson;
//        
//        System.out.println(person);
//        
//        assertNotNull(persistedPerson);
//        
//        assertNotNull(persistedPerson.getId());
//        assertNotNull(persistedPerson.getFirstName());
//        assertNotNull(persistedPerson.getLastName());
//        assertNotNull(persistedPerson.getAddress());
//        assertNotNull(persistedPerson.getGender());
//        
//        assertTrue(persistedPerson.getId() > 0);
//        
//        assertEquals("Nelson", persistedPerson.getFirstName());
//        assertEquals("Piquet", persistedPerson.getLastName());
//        assertEquals("Brasília - DF - Brasil", persistedPerson.getAddress());
//        assertEquals("Male", persistedPerson.getGender());
//    }
//
////    @Test
////    @Order(3)
////    public void testUpdate() throws JsonMappingException, JsonProcessingException {
////        person.setLastName("Piquet Souto Maior");
////        
////        var content = given().spec(specification)
////                .contentType(TestConfigs.CONTENT_TYPE_XML)
////                .accept(TestConfigs.CONTENT_TYPE_XML)
////                    .body(person)
////                    .when()
////                    .post()
////                .then()
////                    .statusCode(200)
////                        .extract()
////                        .body()
////                            .asString();
////        
////        PersonVOXML persistedPerson = objectMapper.readValue(content, PersonVOXML.class);
////        person = persistedPerson;
////        
////        assertNotNull(persistedPerson);
////        
////        assertNotNull(persistedPerson.getId());
////        assertNotNull(persistedPerson.getFirstName());
////        assertNotNull(persistedPerson.getLastName());
////        assertNotNull(persistedPerson.getAddress());
////        assertNotNull(persistedPerson.getGender());
////        
////        assertEquals(person.getId(), persistedPerson.getId());
////        
////        assertEquals("Nelson", persistedPerson.getFirstName());
////        assertEquals("Piquet Souto Maior", persistedPerson.getLastName());
////        assertEquals("Brasília - DF - Brasil", persistedPerson.getAddress());
////        assertEquals("Male", persistedPerson.getGender());
////    }
////
////    @Test
////    @Order(4)
////    public void testFindById() throws JsonMappingException, JsonProcessingException {
////        mockPerson();
////            
////        var content = given().spec(specification)
////                .contentType(TestConfigs.CONTENT_TYPE_XML)
////                .accept(TestConfigs.CONTENT_TYPE_XML)
////                    .pathParam("id", person.getId())
////                    .when()
////                    .get("{id}")
////                .then()
////                    .statusCode(200)
////                        .extract()
////                        .body()
////                            .asString();
////        
////        PersonVOXML persistedPerson = objectMapper.readValue(content, PersonVOXML.class);
////        person = persistedPerson;
////        
////        assertNotNull(persistedPerson);
////        
////        assertNotNull(persistedPerson.getId());
////        assertNotNull(persistedPerson.getFirstName());
////        assertNotNull(persistedPerson.getLastName());
////        assertNotNull(persistedPerson.getAddress());
////        assertNotNull(persistedPerson.getGender());
////
////        assertEquals(person.getId(), persistedPerson.getId());
////        
////        assertEquals("Nelson", persistedPerson.getFirstName());
////        assertEquals("Piquet Souto Maior", persistedPerson.getLastName());
////        assertEquals("Brasília - DF - Brasil", persistedPerson.getAddress());
////        assertEquals("Male", persistedPerson.getGender());
////    }
////    
////    @Test
////    @Order(5)
////    public void testDelete() throws JsonMappingException, JsonProcessingException {
////
////        given().spec(specification)
////            .contentType(TestConfigs.CONTENT_TYPE_XML)
////            .accept(TestConfigs.CONTENT_TYPE_XML)
////                .pathParam("id", person.getId())
////                .when()
////                .delete("{id}")
////            .then()
////                .statusCode(204);
////    }
////    
////    @Test
////    @Order(6)
////    public void testFindAll() throws JsonMappingException, JsonProcessingException {
////        
////        var content = given().spec(specification)
////                .contentType(TestConfigs.CONTENT_TYPE_XML)
////                .accept(TestConfigs.CONTENT_TYPE_XML)
////                    .when()
////                    .get()
////                .then()
////                    .statusCode(200)
////                        .extract()
////                        .body()
////                            .asString();
////        
////        List<PersonVOXML> people = objectMapper.readValue(content, new TypeReference<List<PersonVOXML>>() {});
////        
////        PersonVOXML foundPersonOne = people.get(0);
////        
////        assertNotNull(foundPersonOne.getId());
////        assertNotNull(foundPersonOne.getFirstName());
////        assertNotNull(foundPersonOne.getLastName());
////        assertNotNull(foundPersonOne.getAddress());
////        assertNotNull(foundPersonOne.getGender());
////        
////        assertEquals(1, foundPersonOne.getId());
////        
////        assertEquals("Ayrton", foundPersonOne.getFirstName());
////        assertEquals("Senna", foundPersonOne.getLastName());
////        assertEquals("São Paulo", foundPersonOne.getAddress());
////        assertEquals("Male", foundPersonOne.getGender());
////        
////        PersonVOXML foundPersonSix = people.get(5);
////        
////        assertNotNull(foundPersonSix.getId());
////        assertNotNull(foundPersonSix.getFirstName());
////        assertNotNull(foundPersonSix.getLastName());
////        assertNotNull(foundPersonSix.getAddress());
////        assertNotNull(foundPersonSix.getGender());
////        
////        assertEquals(9, foundPersonSix.getId());
////        
////        assertEquals("Nelson", foundPersonSix.getFirstName());
////        assertEquals("Mvezo", foundPersonSix.getLastName());
////        assertEquals("Mvezo – South Africa", foundPersonSix.getAddress());
////        assertEquals("Male", foundPersonSix.getGender());
////    }
////
////    
////    @Test
////    @Order(7)
////    public void testFindAllWithoutToken() throws JsonMappingException, JsonProcessingException {
////        
////        RequestSpecification specificationWithoutToken = new RequestSpecBuilder()
////            .setBasePath("/api/person/v1")
////            .setPort(TestConfigs.SERVER_PORT)
////                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
////                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
////            .build();
////        
////        given().spec(specificationWithoutToken)
////            .contentType(TestConfigs.CONTENT_TYPE_XML)
////            .accept(TestConfigs.CONTENT_TYPE_XML)
////                .when()
////                .get()
////            .then()
////                .statusCode(403);
////    }
//    
//    private void mockPerson() {
//        person.setFirstName("Nelson");
//        person.setLastName("Piquet");
//        person.setAddress("Brasília - DF - Brasil");
//        person.setGender("Male");
//    }
//}
