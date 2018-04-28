package shiro;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author lee
 * @Date:2018/4/17
 */

public class GuavaFilesTest {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/books.csv");

        if (!file.exists()) {
            file.createNewFile();
        }
        List<String> expectedLines = Lists.newArrayList("Being A Great Cook", " Art is Fun", " Be an Architect", " History of Football",
                " Gardening My Way");

        Files.write(Joiner.on(' ').join(expectedLines), file, Charsets.UTF_8);
        List<String> readLines = Files.readLines(file, Charsets.UTF_8, new ToListLineProcessor());
        System.out.println(readLines);
        System.out.println(expectedLines);
        assertThat(expectedLines, is(readLines));
    }
}

class ToListLineProcessor implements
        LineProcessor<List<String>> {
    private static final Splitter splitter = Splitter.on("");
    private static final int TITLE_INDEX = 1;
    private List<String> bookTitles = Lists.newArrayList();

    @Override
    public List<String> getResult() {
        return bookTitles;
    }

    @Override
    public boolean processLine(String line) throws IOException {
        bookTitles.add(Iterables.get(splitter.split(line), TITLE_INDEX));
        return true;
    }
}

