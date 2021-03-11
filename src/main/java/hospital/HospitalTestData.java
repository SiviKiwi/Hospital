package hospital;

import hospital.healthpersonal.Nurse;
import hospital.healthpersonal.doctor.GeneralPractitioner;
import hospital.healthpersonal.doctor.Surgeon;
public final class HospitalTestData {
    private HospitalTestData() {
// not called
    }
    /**
     * @param hospital
     */
    public static void fillRegisterWithTestData(final Hospital hospital) {
// Add some departments
        Department emergency = new Department("Akutten");
        emergency.getEmployees().put("12345678910", new Employee("Odd Even", "Primtallet", "12345678910"));
        emergency.getEmployees().put("12345678911", new Employee("Huppasahn", "DelFinito", "12345678911"));
        emergency.getEmployees().put("12345678912", new Employee("Rigmor", "Mortis", "12345678912"));
        emergency.getEmployees().put("12345678913", new GeneralPractitioner("Inco", "Gnito", "12345678913"));
        emergency.getEmployees().put("12345678914", new Surgeon("Inco", "Gnito", "12345678914"));
        emergency.getEmployees().put("12345678915", new Nurse("Nina", "Teknologi", "12345678915"));
        emergency.getEmployees().put("12345678916", new Nurse("Ove", "Ralt", "12345678916"));
        emergency.getPatients().put("12345678917", new Patient("Inga", "Lykke", "12345678917"));
        emergency.getPatients().put("12345678918", new Patient("Ulrik", "Smål", "12345678918"));
        hospital.getDepartments().add(emergency);
        Department childrenPolyclinic = new Department("Barn poliklinikk");
        childrenPolyclinic.getEmployees().put("12345678919", new Employee("Salti", "Kaffen", "12345678919"));
        childrenPolyclinic.getEmployees().put("12345678920", new Employee("Nidel V.", "Elvefølger", "12345678920"));
        childrenPolyclinic.getEmployees().put("12345678921", new Employee("Anton", "Nym", "12345678921"));
        childrenPolyclinic.getEmployees().put("12345678922", new GeneralPractitioner("Gene", "Sis", "12345678922"));
        childrenPolyclinic.getEmployees().put("12345678923", new Surgeon("Nanna", "Na", "12345678923"));
        childrenPolyclinic.getEmployees().put("12345678924", new Nurse("Nora", "Toriet", "12345678924"));
        childrenPolyclinic.getPatients().put("12345678925", new Patient("Hans", "Omvar", "12345678925"));
        childrenPolyclinic.getPatients().put("12345678926", new Patient("Laila", "La", "12345678926"));
        childrenPolyclinic.getPatients().put("12345678927", new Patient("Jøran", "Drebli", "12345678927"));
        hospital.getDepartments().add(childrenPolyclinic);
    }
}