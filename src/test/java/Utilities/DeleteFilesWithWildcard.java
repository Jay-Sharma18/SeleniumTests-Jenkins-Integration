//Utility class to delete old Test reports when new test run starts

package Utilities;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DeleteFilesWithWildcard {
    public static void deleteOldFiles() {
        String directoryPath = "test-output"; // Replace with the actual directory path
        String wildcardPattern = "Test-Report*.html"; // Replace with your wildcard pattern

        File directory = new File(directoryPath);
        File[] filesToDelete = directory.listFiles(new WildcardFilter(wildcardPattern));

        if (filesToDelete != null && filesToDelete.length > 0) {
            for (File file : filesToDelete) {
                try {
                    if (file.delete()) {
                        System.out.println("Deleted file: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                } catch (SecurityException e) {
                    System.err.println("Permission denied. Unable to delete file: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found matching the wildcard pattern.");
        }
    }

    // Custom FilenameFilter implementation for wildcard matching
    private static class WildcardFilter implements FilenameFilter {
        private final Pattern pattern;

        public WildcardFilter(String wildcardPattern) {
            pattern = Pattern.compile(wildcardPattern.replace(".", "\\.").replace("*", ".*").replace("?", "."));
        }

        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
