package com.github.vitmonk.filerepo;

import java.io.File;
import java.util.Iterator;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Test;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

public class SVNActions {

    @Test
    public void testCheckout() throws Exception {

        SVNClientManager clientManager = SVNClientManager.newInstance();
        SVNUpdateClient updateClient = clientManager.getUpdateClient();

        File checkoutFolder = Files.createTempDir();

        try {
            SVNURL url = SVNURL.parseURIEncoded("http://svn.apache.org/repos/asf/subversion/svn-logos/");
            boolean allowUnversionedObstructions = true;
            long headRevision = updateClient.doCheckout(url, checkoutFolder,
                    SVNRevision.HEAD, SVNRevision.HEAD,
                    SVNDepth.INFINITY, allowUnversionedObstructions);

            System.out.println("Checked out the revision: " + headRevision);

            System.out.println("Checkout folder contents:");
            Iterator<File> filesIterator = FileUtils.iterateFiles(
                    checkoutFolder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

            while (filesIterator.hasNext()) {
                File file = filesIterator.next();
                System.out.println(file.getAbsolutePath());
            }
        } finally {
            // cleanup
            FileUtils.deleteQuietly(checkoutFolder);
        }
    }
}
