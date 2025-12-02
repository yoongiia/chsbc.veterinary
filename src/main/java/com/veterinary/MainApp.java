package com.veterinary; // Правильний пакет

// НІЯКИХ ІМПОРТІВ DTO, БО ВІН ПОРУЧ
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Veterinarian.class)
                .addAnnotatedClass(Pet.class)
                .addAnnotatedClass(Appointment.class)
                .buildSessionFactory();

        // ЕТАП 1: Наповнення даними
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            System.out.println(">>> Завантаження даних...");

            Veterinarian v1 = new Veterinarian("Петренко Ірина Василівна", 5);
            Veterinarian v2 = new Veterinarian("Іваненко Андрій Миколайович", 3);
            Veterinarian v3 = new Veterinarian("Мельник Оксана Петрівна", 7);
            session.persist(v1); session.persist(v2); session.persist(v3);

            // 1. Коваленко
            Owner o1 = new Owner("Коваленко", "Олег", "Іванович", "м. Київ", "вул. Шевченка", "12", "кв.5", "380501234567");
            Pet p1 = new Pet(o1, "Барсік", "кіт");
            session.persist(o1); session.persist(p1);
            session.persist(new Appointment(p1, v1, LocalDate.parse("2024-09-14"), LocalTime.parse("10:00"), "Щеплення комплекс.", true));

            // 2. Сидоренко
            Owner o2 = new Owner("Сидоренко", "Марія", "Олексіївна", "м. Київ", "вул. Лесі Українки", "3", null, "380661234567");
            Pet p2 = new Pet(o2, "Рекс", "собака");
            session.persist(o2); session.persist(p2);
            session.persist(new Appointment(p2, v1, LocalDate.parse("2024-09-14"), LocalTime.parse("11:30"), "Щеплення від сказу", true));

            // 3. Бондаренко
            Owner o3 = new Owner("Бондаренко", "Дмитро", "Сергійович", "м. Київ", "просп. Перемоги", "33", null, "380731234567");
            Pet p3 = new Pet(o3, "Муся", "кішка");
            session.persist(o3); session.persist(p3);
            session.persist(new Appointment(p3, v2, LocalDate.parse("2024-09-14"), LocalTime.parse("14:20"), "Огляд після опер.", false));

            // 4. Ткаченко
            Owner o4 = new Owner("Ткаченко", "Юлія", "Ігорівна", "м. Київ", "вул. Хрещатик", "25", null, "380671234567");
            Pet p4 = new Pet(o4, "Джек", "собака");
            session.persist(o4); session.persist(p4);
            session.persist(new Appointment(p4, v2, LocalDate.parse("2024-09-14"), LocalTime.parse("15:30"), "Чищення зубів", false));

            // 5. Кравченко
            Owner o5 = new Owner("Кравченко", "Сергій", "Володимир.", "м. Київ", "вул. Саксаганського", "7", null, "380631234567");
            Pet p5 = new Pet(o5, "Зірка", "кішка");
            session.persist(o5); session.persist(p5);
            session.persist(new Appointment(p5, v3, LocalDate.parse("2024-09-15"), LocalTime.parse("09:15"), "Лікування шкіри", false));

            // 6. Марченко
            Owner o6 = new Owner("Марченко", "Ірина", "Олегівна", "м. Київ", "Б. Хмельницького", "10", null, "380501234568");
            Pet p6 = new Pet(o6, "Буч", "собака");
            session.persist(o6); session.persist(p6);
            session.persist(new Appointment(p6, v3, LocalDate.parse("2024-09-15"), LocalTime.parse("11:00"), "Щеплення комплекс.", true));

            // 7. Шевчук
            Owner o7 = new Owner("Шевчук", "Павло", "Миколайович", "м. Київ", "вул. Антоновича", "72", null, "380661234568");
            Pet p7 = new Pet(o7, "Сімба", "кіт");
            session.persist(o7); session.persist(p7);
            session.persist(new Appointment(p7, v1, LocalDate.parse("2024-09-15"), LocalTime.parse("14:45"), "Кастрація", false));

            // 8. Гончарук
            Owner o8 = new Owner("Гончарук", "Наталія", "Вікторівна", "м. Київ", "В. Васильківська", "5", null, "380731234568");
            Pet p8 = new Pet(o8, "Ласка", "собака");
            session.persist(o8); session.persist(p8);
            session.persist(new Appointment(p8, v2, LocalDate.parse("2024-09-16"), LocalTime.parse("10:30"), "Щеплення від сказу", true));

            // 9. Лисенко
            Owner o9 = new Owner("Лисенко", "Артем", "Олегович", "м. Київ", "вул. Дегтярівська", "33", null, "380671234568");
            Pet p9 = new Pet(o9, "Мурка", "кішка");
            session.persist(o9); session.persist(p9);
            session.persist(new Appointment(p9, v3, LocalDate.parse("2024-09-16"), LocalTime.parse("12:15"), "Лікування очей", false));

            // 10. Павленко
            Owner o10 = new Owner("Павленко", "Катерина", "Сергіївна", "м. Київ", "Є. Коновальця", "18", null, "380631234568");
            Pet p10 = new Pet(o10, "Тедді", "собака");
            session.persist(o10); session.persist(p10);
            session.persist(new Appointment(p10, v1, LocalDate.parse("2024-09-16"), LocalTime.parse("15:00"), "Щеплення комплекс.", true));

            // 11. Ковальчук
            Owner o11 = new Owner("Ковальчук", "Михайло", "Іванович", "м. Київ", "вул. Дорогожицька", "2", null, "380501234569");
            Pet p11 = new Pet(o11, "Рудь", "кіт");
            session.persist(o11); session.persist(p11);
            session.persist(new Appointment(p11, v2, LocalDate.parse("2024-09-17"), LocalTime.parse("09:45"), "Огляд після лікув.", false));

            // 12. Бондаренко (інший телефон)
            Owner o12 = new Owner("Бондаренко", "Дмитро", "Сергійович", "м. Київ", "просп. Перемоги", "33", null, "380661234569");
            Pet p12 = new Pet(o12, "Муся", "кішка");
            session.persist(o12); session.persist(p12);
            session.persist(new Appointment(p12, v3, LocalDate.parse("2024-09-17"), LocalTime.parse("13:30"), "Щеплення комплекс.", true));

            session.getTransaction().commit();
            System.out.println(">>> Дані успішно збережено!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ЕТАП 2: Звіт
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            // Вибираємо всі деталі окремо, щоб передати їх в DTO
            String hql = "SELECT new com.veterinary.AppointmentInfoDTO(" +
                    "a.appointmentDate, a.appointmentTime, " +
                    "o.lastName, o.firstName, o.middleName, o.phone, " +
                    "o.city, o.street, o.house, o.apartment, " +
                    "p.name, p.species, v.fullName, v.experienceYears, " +
                    "a.diagnosisTreatment, a.isVaccinated) " +
                    "FROM Appointment a " +
                    "JOIN a.pet p JOIN p.owner o JOIN a.veterinarian v " +
                    "ORDER BY a.appointmentDate, a.appointmentTime";

            List<AppointmentInfoDTO> results = session.createQuery(hql, AppointmentInfoDTO.class).getResultList();

            String line = new String(new char[200]).replace('\0', '-');
            System.out.println("\n" + line);
            // Заголовки таблиці
            System.out.printf("| %-25s | %-15s | %-25s | %-12s | %-5s | %-25s | %-30s | %-10s | %-5s | %-12s |\n",
                    "Власник тварини", "Тварина і вид", "Ветеринар", "Дата", "Час", "Діагноз", "Адреса власника", "Вакцинація", "Стаж", "Телефон");
            System.out.println(line);
            
            for (AppointmentInfoDTO info : results) {
                System.out.println(info.toString());
            }
            System.out.println(line + "\n");

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}