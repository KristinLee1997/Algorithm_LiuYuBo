package structure.binarytree.d_BinarySearchTree;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/4 20:45
 * @desc 文件相关操作
 **/
public class FileOperations {
    public static boolean readFile(String filename, Vector<String> words) {
        if (filename == null) {
            System.out.println("filename is null");
            return false;
        }

        //文件读取
        Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Cannot open" + filename);
            return false;
        }

        //简单分词
        //这个分词方式相对简陋,没有考虑文本处理中的特殊问题
        //在这里只做demo展示用
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }
        return true;
    }

    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }
}
