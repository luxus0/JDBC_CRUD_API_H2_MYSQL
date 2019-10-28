package spring_boot.spring_boot.Jdbc.Example_4.Rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot.spring_boot.Jdbc.Example_4.Entity.Registration;
import spring_boot.spring_boot.Jdbc.Example_4.Repo.Registration_Repo;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Registration_Rest {

    private List<Registration> registrationList;

    private Registration_Repo repo;

    @GetMapping("/getRegistration")
    public List<Registration> getRegistration()
    {
        return registrationList;
    }

    @GetMapping("/getRegistration/{id}")
    public ResponseEntity<Registration> getRegistrationId(@PathVariable("id") long id) throws Exception {
        Registration reg = repo.findById(id).orElseThrow(() -> new Exception("Registration not found for this id :: " +id));;
        return ResponseEntity.ok().body(reg);
    }

    @PostMapping("/addRegistration")
    public void addRegistration(@RequestBody Registration registration)
    {
        registrationList = new ArrayList<>();

        registrationList.add(new Registration(0,"Julia", "Klementa", 23, 168, "Bolesława Chrobrego 43 Zamość", 64373578, "12.04.2000", "--", "brenka213@o2.pl"));
        registrationList.add(new Registration(1,"Melita", "Bozos", 20, 175, "Józefa Milienia 78", 643757657, "12.04.1998", "--", "rubieza213@o2.pl"));
        registrationList.add(new Registration(2,"Mitra", "Salek", 22, 166, "Władimira Kazeja 12 ", 633457435, "16.07.1996", "--", "belitrasa3@o2.pl"));
        registrationList.add(new Registration(3,"Wladimir", "Merkel", 30, 180, "Darta fatra 435 Montenegro", 64335578, "20.10.2002", "20.07.2020", "buriatia213@o2.pl"));
        registrationList.add(new Registration(4,"Datowa", "Kampanija", 19, 163, "Jaderka Bizor 532 Seshell", 54688456, "28.11.1987", "--", "burez@mail.com"));


        registrationList.add(registration);
        System.out.println("All registration people:" +registrationList);
    }

    @PostMapping("/addRegistrationId/{id}")
    public void addRegistrationId(@PathVariable("id") long id,@RequestBody Registration reg)
    {
        registrationList.add(reg);
    }

    @PutMapping("/updateRegistration/{id}")
    public void updateRegistration(@PathVariable("id") long id, @RequestBody Registration registration) throws Exception {


    registration.setName(registration.getName());
    registration.setSurname(registration.getSurname());
    registration.setAge(registration.getAge());
    registration.setAdress(registration.getAdress());
    registration.setHeight(registration.getHeight());
    registration.setDateBirth(registration.getDateBirth());
    registration.setDateDeath(registration.getDateDeath());
    registration.setPesel(registration.getPesel());
    registration.setEmail(registration.getEmail());

    registrationList.add(registration);

    }

    @DeleteMapping("/deleteRegistration")
    public void deleteRegistration()
    {
        registrationList.clear();
    }

    @DeleteMapping("/deleteRegistrationId/{id}")
    public void deleteRegistrationId(@PathVariable("id") long id)
    {
        registrationList.remove(id);
        System.out.println("Delete all registration from id: " +id);
    }


}
