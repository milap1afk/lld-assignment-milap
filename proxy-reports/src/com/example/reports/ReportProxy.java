package com.example.reports;

public class ReportProxy implements Report {
    private final String reportName;
    private final String requiredRole;
    private RealReport realReport;

    public ReportProxy(String reportName, String requiredRole) {
        this.reportName = reportName;
        this.requiredRole = requiredRole;
        this.realReport = null;
    }

    @Override
    public void display(User user) {
        if (!user.getRole().equals(requiredRole)) {
            System.out.println("Access denied for user: " + user.getUsername());
            return;
        }

        if (realReport == null) {
            realReport = new RealReport(reportName);
        }
        realReport.display(user);
    }
}
