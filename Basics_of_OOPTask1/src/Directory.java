import java.io.File;

class Directory
{
    private File dir;

    Directory(String dirName)
    {
        setDir(dirName);
    }

    File getDir() {
        return dir;
    }

    private void setDir(String dirName) {
        this.dir = new File(dirName);
    }
}
