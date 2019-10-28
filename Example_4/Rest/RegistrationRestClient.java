package spring_boot.spring_boot.Jdbc.Example_4.Rest;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import spring_boot.spring_boot.Jdbc.Example_4.Entity.Registration;

import java.util.Scanner;

public class RegistrationRestClient
{

    private static void addRegistationClient() {
        RestTemplate restTemplate = new RestTemplate();
        String jsonToSent = "{\"id\":5,\"name\":\"Mirka\",\"surname\":\"Bosek\",\"age\":34,\"height\":168, \"adress\":\"Bimerka Street 456\",\"pesel\":34,\"dateBirth\":\"12.07.1986\",\"dateDeath\":\"12.07.2017\",\"email\":\"jonek@gmail.com\"}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity httpEntity = new HttpEntity(jsonToSent, httpHeaders);

        ResponseEntity exchange = restTemplate.exchange(
                "http://localhost:8080/addRegistration",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }

    private static void addRegistationClientId()
    {
        RestTemplate rest = new RestTemplate();

        Registration reg1 = new Registration(6,"Wlader", "Sawoje", 22, 188, "Geratz 456", 546566, "12.07.2001","--", "Jaremko@io.cfb");
        Registration reg2 = new Registration(7,"Wlader", "bbb", 25, 184, "Birma 456", 54656236, "12.07.1990","--", "eeeemko@wert.dq");
        Registration reg3 = new Registration(8,"Witalij", "Bartek", 25, 186, "Rtedg 445", 5475675, "12.07.2000","--", "Jtadop@police.df");
        Registration reg4 = new Registration(9,"Nikola", "sapdori", 30, 180, "duta 213", 5465654, "12.07.1998","--", "gerta@seri.com");


        Registration result1 = rest.postForObject("http://localhost:8080/addRegistrationId/6",reg1,Registration.class);
        Registration result2 = rest.postForObject("http://localhost:8080/addRegistrationId/7",reg2,Registration.class);
        Registration result3 = rest.postForObject("http://localhost:8080/addRegistrationId/8",reg3,Registration.class);
        Registration result4 = rest.postForObject("http://localhost:8080/addRegistrationId/9",reg4,Registration.class);


    }



    private static void getRegistrationClient() {

        RestTemplate rest = new RestTemplate();


        ResponseEntity<Registration[]> exchange = rest.exchange("http://localhost:8080/getRegistration", HttpMethod.GET, HttpEntity.EMPTY, Registration[].class);
    }

   /* private static void getRegistrationClientId()
    {
        RestTemplate rest = new RestTemplate();


        Map<String,String> params = new HashMap <String,String>();
        params.put("id","1");

        rest.getForObject("http://localhost:8080/getRegistration/1",Registration.class,params);
    }*/



    private static void deleteRegistrationClient()
    {
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/deleteRegistration",HttpMethod.DELETE,HttpEntity.EMPTY,Void.class);
        System.out.println("DELETE:");
        System.out.println("Response Body: " +responseEntity.getBody());
        System.out.println("Response Header: " +responseEntity.getHeaders());
        System.out.println("Response status code: " +responseEntity.getStatusCode());
        System.out.println("Response status code value: " +responseEntity.getStatusCodeValue());

    }

    private static void deleteRegistrationClientId()
    {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Registration> entity = new HttpEntity<>(headers);

        ResponseEntity<Registration> responseEntity = restTemplate.exchange("http://localhost:8080/deleteRegistrationId/{0}",HttpMethod.DELETE,entity,Registration.class);

        System.out.println("DELETE by id:");
        System.out.println("Response Body: " +responseEntity.getBody());
        System.out.println("Response Header: " +responseEntity.getHeaders());
        System.out.println("Response status code: " +responseEntity.getStatusCode());
        System.out.println("Response status code value: " +responseEntity.getStatusCodeValue());

    }



    public static void main(String[] args)
    {
        addRegistationClient();
        addRegistationClientId();
        getRegistrationClient();
        //getRegistrationClientId();

        System.out.println("-----CHOOSE--- \n1.DELETE ALL Registration Person\n2.DELETE BY ID Registration Person");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose)
        {
            case 1:
            {
                deleteRegistrationClient();
                break;
            }
            
            case 2:
            {
                deleteRegistrationClientId();
                break;
            }
            default:
            {
                System.out.println("Registriation List is full");
            }
                
        }
        
        


    }
}
