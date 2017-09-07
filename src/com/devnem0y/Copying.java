package com.devnem0y;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Copying {

    private static final String SRC_DIR = "resource\\";
    private static final int BUFFER_SIZE = 1024;

    public Copying() {
    }

    public Copying(String DST_DIR) {
        new Copying().copyDir(SRC_DIR, DST_DIR);
    }

    private boolean copyDir(final String src, final String dst) {
        System.out.println("Copy directory: " + src);
        final File srcFile = new File(src);
        final File dstFile = new File(dst);
        dstFile.mkdir();
        File nextSrcFile;
        String nextSrcFilename, nextDstFilename;
        for (String filename : srcFile.list()) {
            nextSrcFilename = srcFile.getAbsolutePath()
                    + File.separator + filename;
            nextDstFilename = dstFile.getAbsolutePath()
                    + File.separator + filename;
            nextSrcFile = new File(nextSrcFilename);
            if (nextSrcFile.isDirectory()) {
                copyDir(nextSrcFilename, nextDstFilename);
            } else {
                copyFile(nextSrcFilename, nextDstFilename);
            }
        }
        return true;
    }

    private boolean copyFile(final String src, final String dst) {
        System.out.println("Copy file: " + src);
        final File srcFile = new File(src);
        final File dstFile = new File(dst);
        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(dstFile)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytes;
            while ((bytes = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytes);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Copying.class.getName())
                    .log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Copying.class.getName())
                    .log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
