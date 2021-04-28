package Student.Function;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PictureFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return f.isDirectory()||f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".jpeg") || f.getName().toLowerCase().endsWith(".png") || f.getName().toLowerCase().endsWith(".gif");
    }

    @Override
    public String getDescription() {
        return "图片文件(*.GIF,*.JPEG,*.JPG,*.PNG)";
    }
}
