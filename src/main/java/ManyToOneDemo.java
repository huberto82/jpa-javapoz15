import dao.DogDao;
import dao.DogDaoJpa;
import dao.MedicalReportDao;
import dao.MedicalReportDaoJpa;
import entity.MedicalReport;

import java.util.List;
import java.util.Scanner;

public class ManyToOneDemo {
    public static void main(String[] args) {
        MedicalReportDao mdao = new MedicalReportDaoJpa();
        DogDao dogs = new DogDaoJpa();
        System.out.println("Dodaj raport medyczny psa:");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        System.out.println("Podaj id psa:");
        long id = scanner.nextLong();
        mdao.save(new MedicalReport(content, dogs.findById(id)));
        List<MedicalReport> list = mdao.findByDogId(id);
        list.stream().forEach(System.out::println);
    }
}
