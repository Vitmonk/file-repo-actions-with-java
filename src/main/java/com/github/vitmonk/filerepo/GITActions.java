package com.github.vitmonk.filerepo;

import java.io.File;
import java.util.Iterator;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.junit.Test;

public class GITActions {

    @Test
    public void testClone() throws Exception {

        File cloneFolder = Files.createTempDir();

        try {
            CloneCommand cloneCommand = Git.cloneRepository()
                    .setDirectory(cloneFolder)
                    .setURI("https://github.com/githubtraining/hellogitworld.git");

            try (Git git = cloneCommand.call()) {
                @SuppressWarnings("resource") // it will be closed in git.close()
                Repository repository = git.getRepository();

                System.out.println("Cloned: " + repository.getAllRefs().get("HEAD"));

                System.out.println("Clone folder contents:");
                Iterator<File> filesIterator = FileUtils.iterateFiles(
                        cloneFolder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

                while (filesIterator.hasNext()) {
                    File file = filesIterator.next();
                    System.out.println(file.getAbsolutePath());
                }
            }

        } finally {
            // cleanup
            FileUtils.deleteQuietly(cloneFolder);
        }
    }
}
