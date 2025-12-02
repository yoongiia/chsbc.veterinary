груд. 03, 2025 12:59:16 ДП org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.14.Final
груд. 03, 2025 12:59:16 ДП org.hibernate.boot.jaxb.internal.stax.LocalXmlResourceResolver resolveEntity
WARN: HHH90000012: Recognized obsolete hibernate namespace http://hibernate.sourceforge.net/hibernate-configuration. Use namespace http://www.hibernate.org/dtd/hibernate-configuration instead.  Support for obsolete DTD/XSD namespaces may be removed at any time.
груд. 03, 2025 12:59:16 ДП org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator instantiateC3p0Provider
WARN: HHH000022: c3p0 properties were encountered, but the c3p0 provider class was not found on the classpath; these properties are going to be ignored.
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [org.postgresql.Driver] at URL [jdbc:postgresql://localhost:5432/vet_clinik]
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=postgres, password=****}
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
груд. 03, 2025 12:59:17 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
груд. 03, 2025 12:59:17 ДП org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.PostgreSQLDialect
Hibernate:

    alter table appointment
       drop constraint FK8y0it8yrd322ps2jklm5f8e07
груд. 03, 2025 12:59:17 ДП org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@1a674e4a] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate:

    alter table appointment
       drop constraint FK97ym201tvtxg3slhf3khn36ye
Hibernate:

    alter table pet
       drop constraint FK7qfti9yba86tgfe9oobeqxfxg
Hibernate:

    drop table if exists appointment cascade
Hibernate:

    drop table if exists owner cascade
Hibernate:

    drop table if exists pet cascade
Hibernate:

    drop table if exists veterinarian cascade
Hibernate:

    create table appointment (
       appointment_id  serial not null,
        appointment_date date not null,
        appointment_time time not null,
        diagnosis_treatment varchar(255) not null,
        is_vaccinated boolean not null,
        pet_id int4 not null,
        vet_id int4 not null,
        primary key (appointment_id)
    )
груд. 03, 2025 12:59:17 ДП org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@2b5b60b3] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate:

    create table owner (
       owner_id  serial not null,
        apartment varchar(255),
        city varchar(255),
        first_name varchar(255),
        house varchar(255),
        last_name varchar(255),
        middle_name varchar(255),
        phone varchar(255),
        street varchar(255),
        primary key (owner_id)
    )
Hibernate:

    create table pet (
       pet_id  serial not null,
        name varchar(255) not null,
        species varchar(255),
        owner_id int4 not null,
        primary key (pet_id)
    )
Hibernate:

    create table veterinarian (
       vet_id  serial not null,
        experience_years int4,
        full_name varchar(255) not null,
        primary key (vet_id)
    )
Hibernate:

    alter table owner
       add constraint UK_q3nfx0w9lmfnyeepg23ccenhu unique (phone)
Hibernate:

    alter table appointment
       add constraint FK8y0it8yrd322ps2jklm5f8e07
       foreign key (pet_id)
       references pet
Hibernate:

    alter table appointment
       add constraint FK97ym201tvtxg3slhf3khn36ye
       foreign key (vet_id)
       references veterinarian
Hibernate:

    alter table pet
       add constraint FK7qfti9yba86tgfe9oobeqxfxg
       foreign key (owner_id)
       references owner
>>> Завантаження даних...
Hibernate:
    insert
    into
        veterinarian
        (experience_years, full_name)
    values
        (?, ?)
Hibernate:
    insert
    into
        veterinarian
        (experience_years, full_name)
    values
        (?, ?)
Hibernate:
    insert
    into
        veterinarian
        (experience_years, full_name)
    values
        (?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        owner
        (apartment, city, first_name, house, last_name, middle_name, phone, street)
    values
        (?, ?, ?, ?, ?, ?, ?, ?)
Hibernate:
    insert
    into
        pet
        (name, owner_id, species)
    values
        (?, ?, ?)
Hibernate:
    insert
    into
        appointment
        (appointment_date, appointment_time, diagnosis_treatment, is_vaccinated, pet_id, vet_id)
    values
        (?, ?, ?, ?, ?, ?)
>>> Дані успішно збережено!
Hibernate:
    select
        appointmen0_.appointment_date as col_0_0_,
        appointmen0_.appointment_time as col_1_0_,
        owner2_.last_name as col_2_0_,
        owner2_.first_name as col_3_0_,
        owner2_.middle_name as col_4_0_,
        owner2_.phone as col_5_0_,
        owner2_.city as col_6_0_,
        owner2_.street as col_7_0_,
        owner2_.house as col_8_0_,
        owner2_.apartment as col_9_0_,
        pet1_.name as col_10_0_,
        pet1_.species as col_11_0_,
        veterinari3_.full_name as col_12_0_,
        veterinari3_.experience_years as col_13_0_,
        appointmen0_.diagnosis_treatment as col_14_0_,
        appointmen0_.is_vaccinated as col_15_0_
    from
        appointment appointmen0_
    inner join
        pet pet1_
            on appointmen0_.pet_id=pet1_.pet_id
    inner join
        owner owner2_
            on pet1_.owner_id=owner2_.owner_id
    inner join
        veterinarian veterinari3_
            on appointmen0_.vet_id=veterinari3_.vet_id
    order by
        appointmen0_.appointment_date,
        appointmen0_.appointment_time

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
| Власник тварини           | Тварина і вид   | Ветеринар                 | Дата         | Час   | Діагноз                   | Адреса власника                | Вакцинація | Стаж  | Телефон      |
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
| Коваленко Олег Іванович   | Барсік (кіт)       | Петренко Ірина Василівна  | 2024-09-14   | 10:00    | Щеплення комплекс.             | м. Київ, вул. Шевченка, 12,... | Так        | 5     | 380501234567    |
| Сидоренко Марія Олексі... | Рекс (собака)      | Петренко Ірина Василівна  | 2024-09-14   | 11:30    | Щеплення від сказу             | м. Київ, вул. Лесі Українки, 3 | Так        | 5     | 380661234567    |
| Бондаренко Дмитро Серг... | Муся (кішка)       | Іваненко Андрій Миколайович | 2024-09-14   | 14:20    | Огляд після опер.              | м. Київ, просп. Перемоги, 33   | Ні         | 3     | 380731234567    |
| Ткаченко Юлія Ігорівна    | Джек (собака)      | Іваненко Андрій Миколайович | 2024-09-14   | 15:30    | Чищення зубів                  | м. Київ, вул. Хрещатик, 25     | Ні         | 3     | 380671234567    |
| Кравченко Сергій Волод... | Зірка (кішка)      | Мельник Оксана Петрівна   | 2024-09-15   | 09:15    | Лікування шкіри                | м. Київ, вул. Саксаганськог... | Ні         | 7     | 380631234567    |
| Марченко Ірина Олегівна   | Буч (собака)       | Мельник Оксана Петрівна   | 2024-09-15   | 11:00    | Щеплення комплекс.             | м. Київ, Б. Хмельницького, 10  | Так        | 7     | 380501234568    |
| Шевчук Павло Миколайович  | Сімба (кіт)        | Петренко Ірина Василівна  | 2024-09-15   | 14:45    | Кастрація                      | м. Київ, вул. Антоновича, 72   | Ні         | 5     | 380661234568    |
| Гончарук Наталія Вікто... | Ласка (собака)     | Іваненко Андрій Миколайович | 2024-09-16   | 10:30    | Щеплення від сказу             | м. Київ, В. Васильківська, 5   | Так        | 3     | 380731234568    |
| Лисенко Артем Олегович    | Мурка (кішка)      | Мельник Оксана Петрівна   | 2024-09-16   | 12:15    | Лікування очей                 | м. Київ, вул. Дегтярівська, 33 | Ні         | 7     | 380671234568    |
| Павленко Катерина Серг... | Тедді (собака)     | Петренко Ірина Василівна  | 2024-09-16   | 15:00    | Щеплення комплекс.             | м. Київ, Є. Коновальця, 18     | Так        | 5     | 380631234568    |
| Ковальчук Михайло Іван... | Рудь (кіт)         | Іваненко Андрій Миколайович | 2024-09-17   | 09:45    | Огляд після лікув.             | м. Київ, вул. Дорогожицька, 2  | Ні         | 3     | 380501234569    |
| Бондаренко Дмитро Серг... | Муся (кішка)       | Мельник Оксана Петрівна   | 2024-09-17   | 13:30    | Щеплення комплекс.             | м. Київ, просп. Перемоги, 33   | Так        | 7     | 380661234569    |
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

груд. 03, 2025 12:59:18 ДП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:postgresql://localhost:5432/vet_clinik]