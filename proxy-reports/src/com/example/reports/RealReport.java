package com.example.reports;

public class RealReport implements Report {
    private final String reportName;
    private final String content;

    public RealReport(String reportName) {
        this.reportName = reportName;
        System.out.println("Loading report from disk: " + reportName);
        this.content = "Confidential Report Data for " + reportName;
    }

    @Override
    public void display(User user) {
        System.out.println("Displaying report: " + reportName);
        System.out.println(content);
    }
}
