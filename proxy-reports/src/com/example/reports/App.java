package com.example.reports;

public class App {
    public static void main(String[] args) {
        User admin = new User("Alice", "ADMIN");
        User student = new User("Bob", "STUDENT");

        Report financialReport = new ReportProxy("financial_report", "ADMIN");
        Report gradesReport = new ReportProxy("grades_report", "STAFF");

        ReportViewer reportViewer = new ReportViewer();

        System.out.println("User Bob tries to open financial report\n");
        reportViewer.openReport(financialReport, student);

        System.out.println("\nUser Alice tries to open financial report\n");
        reportViewer.openReport(financialReport, admin);

        System.out.println("\nUser Alice opens the report again\n");
        reportViewer.openReport(financialReport, admin);
    }
}
