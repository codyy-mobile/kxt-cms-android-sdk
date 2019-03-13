package com.codyy.cms.events.cls;

public class SharingDesktopEvent {
    private boolean isSharing;
    private String stream;

    public SharingDesktopEvent(boolean isSharing, String stream) {
        this.isSharing = isSharing;
        this.stream = stream;
    }

    public boolean isSharing() {
        return isSharing;
    }

    public void setSharing(boolean sharing) {
        isSharing = sharing;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
}
