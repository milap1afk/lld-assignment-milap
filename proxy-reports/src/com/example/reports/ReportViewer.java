package com.example.reports;

public class ReportViewer {
    public void openReport(Report report, User user) {
        report.display(user);
    }
}
