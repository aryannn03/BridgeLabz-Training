import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest{
    FileProcessor f=new FileProcessor();

    @Test
    void testWriteAndReadFile() throws IOException{
        String filename="test.txt";
        String content="JUnitTest";
        f.writeToFile(filename,content);
        assertEquals(content,f.readFromFile(filename));
    }

    @Test
    void testFileExistsAfterWrite() throws IOException{
        String filename="exist.txt";
        f.writeToFile(filename,"data");
        File file=new File(filename);
        assertTrue(file.exists());
    }

    @Test
    void testReadFileNotFound(){
        assertThrows(IOException.class,()->f.readFromFile("nofile.txt"));
    }
}
