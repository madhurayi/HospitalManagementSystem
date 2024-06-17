CREATE TABLE appointment
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_dt       datetime NULL,
    updated_dt       datetime NULL,
    patient_id       BIGINT NULL,
    doctor_id        BIGINT NULL,
    appointment_time datetime     NOT NULL,
    reason           VARCHAR(255) NOT NULL,
    CONSTRAINT pk_appointment PRIMARY KEY (id)
);

CREATE TABLE bill
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_dt datetime NULL,
    updated_dt datetime NULL,
    amount DOUBLE NOT NULL,
    date       datetime     NOT NULL,
    status     VARCHAR(255) NOT NULL,
    patient_id BIGINT NULL,
    CONSTRAINT pk_bill PRIMARY KEY (id)
);

CREATE TABLE doctor
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_dt    datetime NULL,
    updated_dt    datetime NULL,
    name          VARCHAR(255) NOT NULL,
    qualification VARCHAR(255) NOT NULL,
    speciality    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE patient
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_dt   datetime NULL,
    updated_dt   datetime NULL,
    name         VARCHAR(255) NOT NULL,
    gender       VARCHAR(255) NULL,
    age          VARCHAR(255) NULL,
    phone_number VARCHAR(255) NOT NULL,
    address      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_patient PRIMARY KEY (id)
);

ALTER TABLE appointment
    ADD CONSTRAINT FK_APPOINTMENT_ON_DOCTOR FOREIGN KEY (doctor_id) REFERENCES doctor (id);

ALTER TABLE appointment
    ADD CONSTRAINT FK_APPOINTMENT_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);

ALTER TABLE bill
    ADD CONSTRAINT FK_BILL_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patient (id);