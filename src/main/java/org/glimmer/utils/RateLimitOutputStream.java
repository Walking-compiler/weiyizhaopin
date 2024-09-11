package org.glimmer.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class RateLimitOutputStream extends FilterOutputStream {

    private final long bytesPerSecond;
    private final long startTime;
    private long bytesWritten;

    public RateLimitOutputStream(OutputStream out, long bytesPerSecond) {
        super(out);
        this.bytesPerSecond = bytesPerSecond;
        this.startTime = System.currentTimeMillis();
        this.bytesWritten = 0;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        int maxBytes = (int) (bytesPerSecond * (System.currentTimeMillis() - startTime) / 1000 - bytesWritten);
        if (maxBytes <= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maxBytes = (int) (bytesPerSecond * (System.currentTimeMillis() - startTime) / 1000 - bytesWritten);
        }
        if (len > maxBytes) {
            len = maxBytes;
        }
        super.write(b, off, len);
        bytesWritten += len;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] bytes = new byte[]{(byte) b};
        write(bytes, 0, 1);
    }
}