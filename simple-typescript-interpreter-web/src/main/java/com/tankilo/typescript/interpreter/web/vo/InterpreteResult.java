package com.tankilo.typescript.interpreter.web.vo;

public class InterpreteResult {
    private long timeCost;
    private boolean successful;
    private String consoleOutput;
    private StringBuilder consoleSb = new StringBuilder();
    private String returnValue;

    public long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(long timeCost) {
        this.timeCost = timeCost;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getConsoleOutput() {
        return consoleSb.toString();
    }

    public void appendConsoleOutput(String consoleOutput) {
        consoleSb.append(consoleOutput);
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }
}
